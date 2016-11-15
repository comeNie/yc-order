package com.ai.yc.order.api.orderreceive.impl;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderreceive.interfaces.IOrderReceiveSV;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveRequest;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveResponse;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class OrderReceiveSVImpl implements IOrderReceiveSV {

	@Override
	public OrderReceiveResponse orderReceive(OrderReceiveRequest request) throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

}
