package com.ai.yc.order.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveRequest;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveResponse;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdOdStateChgBusiSV;
import com.ai.yc.order.service.business.interfaces.IOrderReceiveBusiSV;

@Service
public class OrderReceiveBusiSVImpl implements IOrderReceiveBusiSV {
	
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Autowired
	private IOrdOdFeeTotalAtomSV ordOdFeeTotalAtomSV;
	@Autowired
	private IOrdOdStateChgBusiSV ordOdStateChgBusiSV;
	
	@Override
	@Transactional
	public OrderReceiveResponse updateOrderReceive(OrderReceiveRequest request) {
		// TODO Auto-generated method stub
		OrderReceiveResponse response = new OrderReceiveResponse();
		//
		OrdOrder ordOrderDb = this.ordOrderAtomSV.findByPrimaryKey(request.getBaseInfo().getOrderId());
		if (null == ordOrderDb) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "此订单信息不存在");
		}
		
		OrdOrder ordOrder = new OrdOrder();
		BeanUtils.copyVO(ordOrder, request.getBaseInfo());
		//
		this.ordOrderAtomSV.updateByPrimaryKeySelective(ordOrder);
		//
		OrdOdFeeTotal ordOdFeeTotal = new OrdOdFeeTotal();
		//BeanUtils.copyVO(ordOdFeeTotal, request.getFeeInfo());
		//this.ordOdFeeTotalAtomSV.updateByOrderIdSelective(request.getBaseInfo().getOrderId(),ordOdFeeTotal );
		//
		this.ordOdStateChgBusiSV.orderReceiveChgDesc(request, request.getBaseInfo().getInterperId(), request.getBaseInfo().getInterperType(), request.getBaseInfo().getLspId(),ordOrderDb.getState());
		//
		response.setOrderId(request.getBaseInfo().getOrderId());
		return response;
	}

}
