package com.ai.yc.order.service.business.interfaces;

import com.ai.yc.order.api.orderfee.param.OrderFeeQueryRequest;
import com.ai.yc.order.api.orderfee.param.OrderFeeQueryResponse;

public interface IOrderFeeQueryBusiSV {
	public OrderFeeQueryResponse orderFeeQuery(OrderFeeQueryRequest request);
}
