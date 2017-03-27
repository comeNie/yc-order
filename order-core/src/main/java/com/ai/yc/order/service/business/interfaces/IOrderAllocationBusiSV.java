package com.ai.yc.order.service.business.interfaces;

import com.ai.opt.base.vo.BaseListResponse;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationePersonRequest;
import com.ai.yc.order.api.orderallocation.param.OrdAlloInterperFeeInfoResponse;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationInfo;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationResponse;

public interface IOrderAllocationBusiSV {
	public OrderAllocationResponse saveOrderAllocation(OrderAllocationRequest request);
	
	public BaseListResponse<OrdAllocationInfo> queryOrderAllocationPerson(OrdAllocationePersonRequest request);
	
	public OrdAlloInterperFeeInfoResponse queryAllocationInterperFee(long orderId);
}
