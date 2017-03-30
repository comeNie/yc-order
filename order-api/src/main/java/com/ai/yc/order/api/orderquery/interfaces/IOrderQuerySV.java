package com.ai.yc.order.api.orderquery.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderquery.param.OrdOrderCountRequest;
import com.ai.yc.order.api.orderquery.param.OrdOrderCountResponse;
import com.ai.yc.order.api.orderquery.param.QueryOrdCountRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrdCountResponse;
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
	 * 查询订单列表
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
	
	/**
	 * 订单数查询（用于客户我的订单和译员我的订单统计）
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode ORD_2011
	 * @ApiDocMethod
	 * @RestRelativeURL queryOrder/queryOrderCount
	 */
	@POST
	@Path("/queryOrderCount")
	QueryOrdCountResponse queryOrderCount(QueryOrdCountRequest request) throws BusinessException, SystemException;
	/**
	 * 订单数查询(用于领单大厅的订单数统计)
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gucl
	 * @ApiCode ORD_2022
	 * @ApiDocMethod
	 * @RestRelativeURL queryOrder/queryOrderCount4TaskCenter
	 */
	@POST
	@Path("/queryOrderCount4TaskCenter")
	QueryOrdCountResponse queryOrderCount4TaskCenter(QueryOrdCountRequest request) throws BusinessException, SystemException;
	/**
	 * 订单汇总信息查询
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode
	 * @RestRelativeURL queryOrder/queryOrderCountInfo
	 */
	@POST
	@Path("/queryOrderCountInfo")
	OrdOrderCountResponse queryOrderCountInfo(OrdOrderCountRequest request) throws BusinessException, SystemException;
}
