package com.ai.yc.order.api.orderallocation.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderallocation.interfaces.IOrderAllocationSV;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationResponse;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class OrderAllocationSVImpl implements IOrderAllocationSV {
	private static Logger logger = LoggerFactory.getLogger(OrderAllocationSVImpl.class);

	@Override
	public OrderAllocationResponse orderAllocation(OrderAllocationRequest request)
			throws BusinessException, SystemException {
		
		return null;
	}

}
