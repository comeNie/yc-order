package com.ai.yc.order.api.orderdeplay.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.yc.order.api.orderdeplay.param.OrderDeplayRequest;
@Path("/orderDeplaySV")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderDeplaySV {
	/**
	 * 订单延时
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode 
	 * @RestRelativeURL orderDeplaySV/orderDeplay
	 */
	 @POST
	    @Path("/orderDeplay")
	    public BaseResponse orderDeplay(OrderDeplayRequest request) throws BusinessException, SystemException;
}
