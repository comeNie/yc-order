package com.ai.yc.order.api.orderpay.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderpay.param.OrderPayProcessedResultRequest;
import com.ai.yc.order.api.orderpay.param.OrderPayProcessedResultResponse;

@Path("/OrderPayProcessedResultSV")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderPayProcessedResultSV {
	/**
	 * 订单支付结果处理
	 * 
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode OrderPayProcessedResultSV-001
	 * @RestRelativeURL OrderPayProcessedResultSV/orderPayProcessedResult
	 */
	@POST
	@Path("/orderPayProcessedResult")
	public OrderPayProcessedResultResponse orderPayProcessedResult(OrderPayProcessedResultRequest request)
			throws BusinessException, SystemException;
}
