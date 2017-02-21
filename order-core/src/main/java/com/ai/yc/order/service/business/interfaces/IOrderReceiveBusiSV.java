package com.ai.yc.order.service.business.interfaces;

import com.ai.yc.order.api.orderreceive.param.OrderReceiveRequest;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveResponse;

public interface IOrderReceiveBusiSV {
	public OrderReceiveResponse updateOrderReceive(OrderReceiveRequest request);
}
