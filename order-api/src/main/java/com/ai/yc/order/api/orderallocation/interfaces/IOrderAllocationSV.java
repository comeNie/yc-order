package com.ai.yc.order.api.orderallocation.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderallocation.param.OrdAlloInterperFeeInfoResponse;
import com.ai.yc.order.api.orderallocation.param.OrdAlloInterperFeeRequest;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationCountRequest;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationCountResponse;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationResponse;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationSearchRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationSearchResponse;

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
	@POST
	@Path("/orderAllocation")
	public OrderAllocationResponse orderAllocation(OrderAllocationRequest request) throws BusinessException, SystemException;
	/**
	 * 分配订单查询
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode ORD_2025
	 * @RestRelativeURL OrderAllocationSV/ordAllocationInfo
	 */
	@POST
	@Path("/ordAllocationInfo")
	public OrderAllocationSearchResponse pageSearchAlloWaitReceive(OrderAllocationSearchRequest request) throws BusinessException, SystemException;

	
	/**
	 * 查询LSP下的译员佣金
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode ORD_2025
	 * @RestRelativeURL OrderAllocationSV/queryAlloInterperFee
	 */
	@POST
	@Path("/queryAlloInterperFee")
	public OrdAlloInterperFeeInfoResponse queryAlloInterperFee(OrdAlloInterperFeeRequest request) throws BusinessException, SystemException;
	/**
	 * 查询lsp分配订单数量
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode
	 * @RestRelativeURL OrderAllocationSV/queryAlloOrderCount
	 */
	@POST
	@Path("/queryAlloOrderCount")
	public OrdAllocationCountResponse queryAlloOrderCount(OrdAllocationCountRequest request) throws BusinessException, SystemException;
	
}
