package com.ai.yc.order.api.orderallocation.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationResponse;

@Path("/OrderAllocationSV")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderAllocationSV {
	/**
	 * ORD_2019_订单分配
	 *  
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode ORD_2019
	 * @RestRelativeURL OrderAllocationSV/orderAllocation
	 */
	public OrderAllocationResponse orderAllocation(OrderAllocationRequest request) throws BusinessException, SystemException;

}
