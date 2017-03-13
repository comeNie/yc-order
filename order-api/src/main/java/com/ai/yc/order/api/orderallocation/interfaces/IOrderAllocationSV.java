package com.ai.yc.order.api.orderallocation.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseListResponse;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationePersonRequest;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationePersones;
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
	@POST
	@Path("/orderAllocation")
	public OrderAllocationResponse orderAllocation(OrderAllocationRequest request) throws BusinessException, SystemException;
	/**
	 * 分配人员信息查询
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode
	 * @RestRelativeURL OrderAllocationSV/orderAllocation
	 */
	@POST
	@Path("/ordPersonInfo")
	public BaseListResponse<OrdAllocationePersones> queryAllocationPersonInfoByOrdId(OrdAllocationePersonRequest request) throws BusinessException, SystemException;

}
