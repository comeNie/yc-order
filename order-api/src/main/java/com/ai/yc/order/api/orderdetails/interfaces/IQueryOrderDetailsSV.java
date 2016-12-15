package com.ai.yc.order.api.orderdetails.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderdetails.param.QueryOrderDetailsResponse;

/**
 * @Description: 订单详情查询
 * @author hougang@asiainfo.com
 * @date 2016年11月5日 上午9:56:20 
 * @version V1.0
 */
@Path("/orderdetails")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IQueryOrderDetailsSV {
	
	/**
	 * 订单详情查询（我的订单）
	 * @param orderId 订单ID
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author hougang
	 * @ApiCode ORD_2008
	 * @ApiDocMethod
     * @RestRelativeURL orderdetails/queryOrderDetails
	 */
	@POST
	@Path("/queryOrderDetails")
	QueryOrderDetailsResponse queryOrderDetails(Long orderId,String flag)throws BusinessException, SystemException;
	
	

}
