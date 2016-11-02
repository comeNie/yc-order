package com.ai.yc.order.api.orderquery.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderquery.param.QueryOrderRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrderRsponse;
/**
 * 查询订单列表
 * Date: 2016年11月2日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
@Path("/queryOrder")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderQuerySV {
	/**
	 * 查询订单列表（我的订单）
	 * @param queryOrderRequest
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode ORD_2006
	 * @ApiDocMethod
     * @RestRelativeURL queryOrder/queryOrderPage
	 */
	@POST
	@Path("/queryOrderPage")
	QueryOrderRsponse queryOrder(QueryOrderRequest queryOrderRequest) throws BusinessException, SystemException;
}
