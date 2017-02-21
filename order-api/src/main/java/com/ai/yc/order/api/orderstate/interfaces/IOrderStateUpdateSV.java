package com.ai.yc.order.api.orderstate.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateRequest;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateResponse;

@Path("/OrderStateUpdateSV")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderStateUpdateSV {
	/**
	 * 修改订单状态
	 *  
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode ORD_2018
	 * @RestRelativeURL OrderStateUpdateSV/updateState
	 */
	@POST
	@Path("/updateState")
	public OrderStateUpdateResponse updateState(OrderStateUpdateRequest request)throws BusinessException,SystemException;
}
