package com.ai.yc.order.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.sdk.util.BeanUtils;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationResponse;
import com.ai.yc.order.dao.mapper.bo.OrdOdPersonInfo;
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
		//1.分配人员信息表入库
		OrdOdPersonInfo ordOdPersonInfo = new OrdOdPersonInfo();
		BeanUtils.copyVO(ordOdPersonInfo, request.getOrderAllocationExtendInfo());
		ordOdPersonInfo.setOrderId(request.getOrderAllocationBaseInfo().getOrderId());
		ordOdPersonInfo.setPersonId(SequenceUtil.createPersonId());
		//2.修改订单主表状态字段
		//3.入库订单轨迹表 状态为---211：已分配（口译订单则为瞬时状态，直接为“50：待确认”）

		this.ordOdPersonInfoAtomSV.insertSelective(ordOdPersonInfo);
		return null;
	}

}
