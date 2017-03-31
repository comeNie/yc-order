package com.ai.yc.order.api.orderreprocess.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderreprocess.param.OrderReprocessRequest;
import com.ai.yc.order.api.orderreprocess.param.OrderReprocessResponse;
@Path("/OrderReprocessSV")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderReprocessSV {
	/**
	 * 订单返工
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode
	 * @RestRelativeURL OrderReprocessSV/orderReprocess
	 */
	@POST
	@Path("/orderReprocess")
	public OrderReprocessResponse orderReprocess(OrderReprocessRequest request)throws BusinessException,SystemException;
}
