package com.ai.yc.order.api.orderlevel.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderlevel.param.OrderLevelRequest;
import com.ai.yc.order.api.orderlevel.param.OrderLevelResponse;

@Path("/OrderLevelSV")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderLevelSV {
	/**
	 * 获取订单级别 （算法）
	 *  
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode OrderLevelSV-001
	 * @RestRelativeURL OrderLevelSV/getOrderLevel
	 */
	@POST
	@Path("/getOrderLevel")
	public OrderLevelResponse getOrderLevel(OrderLevelRequest request)throws BusinessException,SystemException;
}
