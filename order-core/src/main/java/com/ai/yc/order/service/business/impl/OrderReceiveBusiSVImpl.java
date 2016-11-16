package com.ai.yc.order.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.sdk.util.BeanUtils;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveRequest;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveResponse;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrderReceiveBusiSV;

@Service
public class OrderReceiveBusiSVImpl implements IOrderReceiveBusiSV {
	
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Autowired
	private IOrdOdFeeTotalAtomSV ordOdFeeTotalAtomSV;
	
	@Override
	@Transactional
	public OrderReceiveResponse updateOrderReceive(OrderReceiveRequest request) {
		// TODO Auto-generated method stub
		OrderReceiveResponse response = new OrderReceiveResponse();
		//
		OrdOrder ordOrder = new OrdOrder();
		BeanUtils.copyVO(ordOrder, request.getBaseInfo());
		//
		this.ordOrderAtomSV.updateByPrimaryKeySelective(ordOrder);
		//
		OrdOdFeeTotal ordOdFeeTotal = new OrdOdFeeTotal();
		BeanUtils.copyVO(ordOdFeeTotal, request.getFeeInfo());
		this.ordOdFeeTotalAtomSV.updateByOrderIdSelective(request.getBaseInfo().getOrderId(),ordOdFeeTotal );
		//
		response.setOrderId(request.getBaseInfo().getOrderId());
		return response;
	}

}
