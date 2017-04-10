package com.ai.yc.order.service.business.interfaces;

import com.ai.yc.order.api.orderallocation.param.OrdAllocationCountRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationSearchRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationSearchResponse;

public interface IOrderAlloWaitReceiveBusiSV {
	public OrderAllocationSearchResponse pageSearchAlloWaitReceive(OrderAllocationSearchRequest request);
	
	public int pageSearchAlloWaitReceiveCount(OrdAllocationCountRequest request);
	
}
