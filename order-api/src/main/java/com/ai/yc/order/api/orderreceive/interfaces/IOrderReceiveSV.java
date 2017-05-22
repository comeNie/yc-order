package com.ai.yc.order.api.orderreceive.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderreceive.param.OrderAlloReceiveRequest;
import com.ai.yc.order.api.orderreceive.param.OrderBackReceiveRequest;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveRequest;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveResponse;

@Path("/OrderReceiveSV")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderReceiveSV {
	/**
	 * 订单领取
	 *  
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode ORD_2010
	 * @RestRelativeURL OrderReceiveSV/orderReceive
	 */
	@POST
	@Path("/orderReceive")
	public OrderReceiveResponse orderReceive(OrderReceiveRequest request) throws BusinessException, SystemException;
	/**
	 * 分配订单领取
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode ORD_2024
	 * @RestRelativeURL OrderReceiveSV/orderAlloReceive
	 */
	@POST
	@Path("/orderAlloReceive")
	public OrderReceiveResponse orderAlloReceive(OrderAlloReceiveRequest request) throws BusinessException, SystemException;
	
	/**
	 * 运营后台订单分配（领取）
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode
	 * @RestRelativeURL OrderReceiveSV/orderBackReceive
	 */
	@POST
	@Path("/orderBackReceive")
	public OrderReceiveResponse orderBackReceive(OrderBackReceiveRequest request) throws BusinessException, SystemException;
	
	
	
}
