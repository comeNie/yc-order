package com.ai.yc.order.api.orderfee.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderfee.param.OrderFeeQueryRequest;
import com.ai.yc.order.api.orderfee.param.OrderFeeQueryResponse;
@Path("/OrderFeeQuerySV")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderFeeQuerySV {
	/**
	 * 订单费用查询
	 *  
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode OrderFeeQuerySV-001
	 * @RestRelativeURL OrderFeeQuerySV/orderFeeQuery
	 */
	@POST
	@Path("/orderFeeQuery")
	public OrderFeeQueryResponse orderFeeQuery(OrderFeeQueryRequest request) throws BusinessException, SystemException;
}
