package com.ai.yc.order.service.business.interfaces;

import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionRequest;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionResponse;

public interface IOrderSubmissionBusiSV {
	public OrderSubmissionResponse saveOrderSubmission(OrderSubmissionRequest request);
}
