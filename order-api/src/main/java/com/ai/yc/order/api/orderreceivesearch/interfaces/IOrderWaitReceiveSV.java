package com.ai.yc.order.api.orderreceivesearch.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.orderreceivesearch.param.OrderWaitReceiveSearchRequest;
import com.ai.yc.order.api.orderreceivesearch.param.OrderWaitReceiveSearchResponse;
@Path("/OrderWaitReceiveSV")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderWaitReceiveSV {
	/**
	 * 
	 *  
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode OrderWaitReceiveSV-001
	 * @RestRelativeURL OrderWaitReceiveSV/pageSearchWaitReceive
	 */
	@POST
	@Path("/pageSearchWaitReceive")
	public OrderWaitReceiveSearchResponse pageSearchWaitReceive(OrderWaitReceiveSearchRequest request) throws BusinessException, SystemException;
}
