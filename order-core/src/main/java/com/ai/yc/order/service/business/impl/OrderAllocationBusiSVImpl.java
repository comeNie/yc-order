package com.ai.yc.order.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.vo.BaseListResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationePersonRequest;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationePersones;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationExtendInfo;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationResponse;
import com.ai.yc.order.constants.OrdOdStateChgConstants;
import com.ai.yc.order.constants.OrdersConstants;
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
	/**
	 * 订单分配
	 */
	private final static String ORDER_ALLOCATION_CN = " %s 分配翻译订单";	
	private final static String ORDER_ALLOCATION_EN = " %s assigned the order";
	private final static String ORDER_ALLOCATION_CHECK_CN = " %s 分配审校订单";	
	private final static String ORDER_ALLOCATION_CHECK_EN = " %s assigned the proofreading order to Translator";

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
		ordOrderUpdate.setStateChgTime(DateUtil.getSysDate());
		ordOrderUpdate.setDisplayFlag(request.getOrderAllocationBaseInfo().getState());
		ordOrderUpdate.setDisplayFlagChgTime(DateUtil.getSysDate());
		this.ordOrderAtomSV.updateByPrimaryKeySelective(ordOrderUpdate);
		//3.入库订单轨迹表 状态为---211：已分配（口译订单则为瞬时状态，直接为“50：待确认”）
		OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
		ordOdStateChg.setStateChgId(SequenceUtil.createStateChgId());
		ordOdStateChg.setOrderId(request.getOrderAllocationBaseInfo().getOrderId());
		//获取中英文轨迹信息
		String descCn = String.format(ORDER_ALLOCATION_CN,request.getOrderAllocationBaseInfo().getOperName());
		String descEn = String.format(ORDER_ALLOCATION_EN,request.getOrderAllocationBaseInfo().getOperName());
		String descCheckCn = String.format(ORDER_ALLOCATION_CHECK_CN,request.getOrderAllocationBaseInfo().getOperName());
		String descCheckEn = String.format(ORDER_ALLOCATION_CHECK_EN,request.getOrderAllocationBaseInfo().getOperName());
		ordOdStateChg.setChgDescEn(descEn);
		ordOdStateChg.setChgDescD(descCn);
		ordOdStateChg.setChgDescUEn(descEn);
		ordOdStateChg.setChgDesc(descCn);
		List<OrderAllocationExtendInfo> list = request.getOrderAllocationExtendInfoList();
		if(!CollectionUtil.isEmpty(list)){
			OrderAllocationExtendInfo info = list.get(0);
			if(info!=null){
				if(OrdersConstants.OrdOperType.OPER_CHECK_TYPE.equals(info.getOperType())){
					ordOdStateChg.setChgDescEn(descCheckEn);
					ordOdStateChg.setChgDescD(descCheckCn);
					ordOdStateChg.setChgDescUEn(descCheckEn);
					ordOdStateChg.setChgDesc(descCheckCn);
				}
			}
		}
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
		//是否需要加上领取状态
		List<OrdOdPersonInfo> list = ordOdPersonInfoAtomSV.findByOrderId(orderId,OrdersConstants.RECEIVE_STATE);
		 for(OrdOdPersonInfo info:list){
			 OrdAllocationePersones persones = new OrdAllocationePersones();
			 BeanUtils.copyVO(persones, info);
			 personList.add(persones);
		 }
		 response.setResult(personList); 
		 ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "订单分配人员查询成功");
		 response.setResponseHeader(responseHeader);
		 return response;
	}

	@Override
	public BaseListResponse<OrdAllocationePersones> queryOrderAllocationPerson(OrdAllocationePersonRequest request) {
		BaseListResponse<OrdAllocationePersones> response = new BaseListResponse<OrdAllocationePersones>();
		List<OrdAllocationePersones> personList = new ArrayList<OrdAllocationePersones>();
		OrdOdPersonInfo ordOdPersonInfo = new OrdOdPersonInfo();
		BeanUtils.copyVO(ordOdPersonInfo, request);
		List<OrdOdPersonInfo> list = ordOdPersonInfoAtomSV.findPersonInfo(ordOdPersonInfo);
		 for(OrdOdPersonInfo info:list){
			 OrdAllocationePersones persones = new OrdAllocationePersones();
			 BeanUtils.copyVO(persones, info);
			 personList.add(persones);
		 }
		 response.setResult(personList); 
		 ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "订单分配人员查询成功");
		 response.setResponseHeader(responseHeader);
		 return response;
	}

}
