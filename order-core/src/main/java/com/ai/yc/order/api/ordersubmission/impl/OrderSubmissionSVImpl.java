package com.ai.yc.order.api.ordersubmission.impl;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.ordersubmission.interfaces.IOrderSubmissionSV;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionRequest;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionResponse;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class OrderSubmissionSVImpl implements IOrderSubmissionSV {

	@Override
	public OrderSubmissionResponse orderSubmission(OrderSubmissionRequest request)
			throws BusinessException, SystemException {
		OrderSubmissionResponse response = new OrderSubmissionResponse();
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "订单提交成功");
		response.setOrderId(10000l);
		response.setResponseHeader(responseHeader);
		return response;
	}

}
