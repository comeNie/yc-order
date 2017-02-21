package com.ai.yc.order.api.paystatus.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.paystatus.param.UpdatePayStatusRequest;
import com.ai.yc.order.api.paystatus.param.UpdatePayStatusResponse;

/**
 * @Description: 修改订单支付状态
 * @author hougang@asiainfo.com
 * @date 2016年11月7日 上午9:58:09 
 * @version V1.0
 */
@Path("/paystatus")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IUpdatePayStatusSV {
	
	/**
     * 修改订单状态
     * @param 
     * @return 
     * @throws BusinessException,SystemException
     * @author hougang
     * @ApiDocMethod
     * @ApiCode ORD_2015
     * @RestRelativeURL paystatus/updatePayStatus
	 */
	@POST
	@Path("/updatePayStatus")
	UpdatePayStatusResponse updatePayStatus(UpdatePayStatusRequest req)throws BusinessException,SystemException;

}
