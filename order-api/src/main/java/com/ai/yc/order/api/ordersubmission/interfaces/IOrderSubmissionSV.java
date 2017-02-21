package com.ai.yc.order.api.ordersubmission.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionRequest;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionResponse;
@Path("/OrderSubmissionSV")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderSubmissionSV {
	/**
	 * 订单提交
	 *  
	 * @param OrderSubmissionRequest
	 * @return OrderSubmissionResponse
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode OrderSubmissionSV-001
	 * @RestRelativeURL OrderSubmissionSV/orderSubmission
	 */
	@POST
	@Path("/orderSubmission")
	public OrderSubmissionResponse orderSubmission(OrderSubmissionRequest request)throws BusinessException,SystemException;
}
