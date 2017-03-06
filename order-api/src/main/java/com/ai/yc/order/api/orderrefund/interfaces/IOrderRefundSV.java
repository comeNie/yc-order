package com.ai.yc.order.api.orderrefund.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderrefund.param.OrderRefundCheckRequest;
import com.ai.yc.order.api.orderrefund.param.OrderRefundRequest;
import com.ai.yc.order.api.orderrefund.param.OrderRefundResponse;
@Path("/OrderRefundSV")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderRefundSV {
	/**
	 * 退款申请
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode ORD_2013
	 * @RestRelativeURL OrderRefundSV/refund
	 */
	@POST
	@Path("/refund")
	public OrderRefundResponse refund(OrderRefundRequest request)throws BusinessException,SystemException;
	/**
	 * 退款审核
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode ORD_2013
	 * @RestRelativeURL OrderRefundSV/refundCheck
	 */
	@POST
	@Path("/refundCheck")
	public OrderRefundResponse refundCheck(OrderRefundCheckRequest request)throws BusinessException,SystemException;
}
