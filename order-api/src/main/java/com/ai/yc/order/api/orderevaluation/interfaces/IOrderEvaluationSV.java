package com.ai.yc.order.api.orderevaluation.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationRequest;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationResponse;

@Path("/OrderEvaluationSV")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderEvaluationSV {
	/**
	 * ORD_2020_订单评价 
	 *  
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode ORD_2020
	 * @RestRelativeURL OrderEvaluationSV/orderEvaluation
	 */
	@POST
	@Path("/orderEvaluation")
	public OrderEvaluationResponse orderEvaluation(OrderEvaluationRequest request)  throws BusinessException, SystemException;
}
