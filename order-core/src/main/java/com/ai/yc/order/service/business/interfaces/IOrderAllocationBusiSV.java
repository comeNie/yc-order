package com.ai.yc.order.service.business.interfaces;

import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationResponse;

public interface IOrderAllocationBusiSV {
	public OrderAllocationResponse saveOrderAllocation(OrderAllocationRequest request);
}
