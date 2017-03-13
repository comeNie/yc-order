package com.ai.yc.order.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.vo.BaseListResponse;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationePersones;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationExtendInfo;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationResponse;
import com.ai.yc.order.constants.OrdOdStateChgConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOdPersonInfo;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOdPersonInfoAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdStateChgAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrderAllocationBusiSV;
import com.ai.yc.order.util.SequenceUtil;
@Service
public class OrderAllocationBusiSVImpl implements IOrderAllocationBusiSV {
	@Autowired
	private IOrdOdPersonInfoAtomSV ordOdPersonInfoAtomSV;//分配人员信息服务
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;//订单主表
	@Autowired
	private IOrdOdStateChgAtomSV ordOdStateChgAtomSV;//订单轨迹表
	
	@Override
	@Transactional
	public OrderAllocationResponse saveOrderAllocation(OrderAllocationRequest request) {
		
		//
		OrderAllocationResponse response = new OrderAllocationResponse();
		//1.分配人员信息表入库
		for(OrderAllocationExtendInfo orderAllocationExtendInfo : request.getOrderAllocationExtendInfoList() ){
			//
			OrdOdPersonInfo ordOdPersonInfo = new OrdOdPersonInfo();
			BeanUtils.copyVO(ordOdPersonInfo, orderAllocationExtendInfo);
			ordOdPersonInfo.setOrderId(request.getOrderAllocationBaseInfo().getOrderId());
			ordOdPersonInfo.setPersonId(SequenceUtil.createPersonId());
			ordOdPersonInfo.setReceiveState("0");//0:未领取
			//
			this.ordOdPersonInfoAtomSV.insertSelective(ordOdPersonInfo);
		}
		
		//2.修改订单主表状态字段
		//2.1 先查询订单主表信息
		OrdOrder ordOrderDb = this.ordOrderAtomSV.findByPrimaryKey(request.getOrderAllocationBaseInfo().getOrderId());
		//2.2 修改订单主表状态
		OrdOrder ordOrderUpdate = new OrdOrder();
		ordOrderUpdate.setOrderId(request.getOrderAllocationBaseInfo().getOrderId());
		ordOrderUpdate.setState(request.getOrderAllocationBaseInfo().getState());
		this.ordOrderAtomSV.updateByPrimaryKeySelective(ordOrderUpdate);
		//3.入库订单轨迹表 状态为---211：已分配（口译订单则为瞬时状态，直接为“50：待确认”）
		OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
		ordOdStateChg.setStateChgId(SequenceUtil.createStateChgId());
		ordOdStateChg.setOrderId(request.getOrderAllocationBaseInfo().getOrderId());
		ordOdStateChg.setChgDesc("订单 "+request.getOrderAllocationBaseInfo().getOrderId()+" 已分配");
		ordOdStateChg.setChgDescEn("");
		ordOdStateChg.setChgDescD("");
		ordOdStateChg.setChgDescUEn("");
		ordOdStateChg.setFlag(OrdOdStateChgConstants.FLAG_USER);
		ordOdStateChg.setOrgId("1");
		ordOdStateChg.setOperId(request.getOrderAllocationBaseInfo().getUserId());
		ordOdStateChg.setOperName(request.getOrderAllocationBaseInfo().getOperName());
		ordOdStateChg.setOrgState(ordOrderDb.getState());
		ordOdStateChg.setNewState(request.getOrderAllocationBaseInfo().getState());
		ordOdStateChg.setStateChgTime(DateUtil.getSysDate());
		//
		this.ordOdStateChgAtomSV.insertSelective(ordOdStateChg);
		//
		response.setOrderId(request.getOrderAllocationBaseInfo().getOrderId());
		//
		return response;
	}

	@Override
	public BaseListResponse<OrdAllocationePersones> queryOrderAllocationPerson(long orderId) {
		BaseListResponse<OrdAllocationePersones> response = new BaseListResponse<OrdAllocationePersones>();
		List<OrdAllocationePersones> personList = new ArrayList<OrdAllocationePersones>();
		//是否需要加上领取状态???????
		List<OrdOdPersonInfo> list = ordOdPersonInfoAtomSV.findByOrderId(orderId);
		 for(OrdOdPersonInfo info:list){
			 OrdAllocationePersones persones = new OrdAllocationePersones();
			 BeanUtils.copyVO(persones, info);
			 personList.add(persones);
		 }
		 response.setResult(personList); 
		 return response;
	}

}
