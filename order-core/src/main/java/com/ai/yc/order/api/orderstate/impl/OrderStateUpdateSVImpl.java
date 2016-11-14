package com.ai.yc.order.api.orderstate.impl;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderstate.interfaces.IOrderStateUpdateSV;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateRequest;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateResponse;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class OrderStateUpdateSVImpl implements IOrderStateUpdateSV {

	@Override
	public OrderStateUpdateResponse updateState(OrderStateUpdateRequest request)
			throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

}
