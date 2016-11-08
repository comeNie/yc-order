package com.ai.yc.order.api.updateorder.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.updateorder.param.UpdateOrderRequest;
import com.ai.yc.order.api.updateorder.param.UpdateOrderResponse;

/**
 * @Description:订单信息修改
 * @author hougang@asiainfo.com
 * @date 2016年11月7日 下午4:30:56 
 * @version V1.0
 */
@Path("/updateorder")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IUpdateOrderSV {
	
	/**
     * 订单信息修改
     * @param 
     * @return 
     * @throws BusinessException,SystemException
     * @author hougang
     * @ApiDocMethod
     * @ApiCode ORD_2003
     * @RestRelativeURL updateorder/updateOrderInfo
	 */
	@POST
	@Path("/updateorder")
	UpdateOrderResponse updateOrderInfo(UpdateOrderRequest req)throws BusinessException,SystemException;

}
