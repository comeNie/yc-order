package com.ai.yc.order.api.orderreview.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.yc.order.api.orderreview.param.OrderReviewRequest;

@Path("/orderreview")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderReviewSV {
	/**
	 * 手动审核订单
	 * 
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode ORD_2012
	 * @ApiDocMethod
	 * @RestRelativeURL orderreview/handReviewOrder
	 */
	@POST
	@Path("/handReviewOrder")
	public BaseResponse handReviewOrder(OrderReviewRequest request) throws BusinessException, SystemException;

}
