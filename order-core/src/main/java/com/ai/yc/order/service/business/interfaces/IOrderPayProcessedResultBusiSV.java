package com.ai.yc.order.service.business.interfaces;

import com.ai.yc.order.api.orderpay.param.OrderPayProcessedResultRequest;
import com.ai.yc.order.api.orderpay.param.OrderPayProcessedResultResponse;

public interface IOrderPayProcessedResultBusiSV {
	public OrderPayProcessedResultResponse updateOrderPayProcessedResult(OrderPayProcessedResultRequest request);
}
