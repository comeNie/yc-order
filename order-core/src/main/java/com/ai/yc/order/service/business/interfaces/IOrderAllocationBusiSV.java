package com.ai.yc.order.service.business.interfaces;

import com.ai.opt.base.vo.BaseListResponse;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationePersonRequest;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationePersones;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationResponse;

public interface IOrderAllocationBusiSV {
	public OrderAllocationResponse saveOrderAllocation(OrderAllocationRequest request);
	
	public BaseListResponse<OrdAllocationePersones> queryOrderAllocationPerson(long orderId);
	
	public BaseListResponse<OrdAllocationePersones> queryOrderAllocationPerson(OrdAllocationePersonRequest request);
}
