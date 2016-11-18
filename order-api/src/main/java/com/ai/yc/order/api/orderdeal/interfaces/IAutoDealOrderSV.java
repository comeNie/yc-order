package com.ai.yc.order.api.orderdeal.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;

/**
 * @Description: 自动处理订单服务
 * @author hougang@asiainfo.com
 * @date 2016年11月1日 下午2:29:36 
 * @version V1.0
 */
@Path("/orderdeal")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IAutoDealOrderSV {
	
	 /**
     * 自动取消（关闭）订单服务
     * @param 
     * @return 
     * @throws BusinessException,SystemException
     * @author hougang
     * @ApiDocMethod
     * @ApiCode ORD_2031
     * @RestRelativeURL orderdeal/autoCancelOrder
	 */
	@POST
	@Path("/autoCancelOrder")
	BaseResponse autoCancelOrder()throws BusinessException,SystemException;
	
	 /**
     * 自动确认订单服务
     * @param 
     * @return 
     * @throws BusinessException,SystemException
     * @author hougang
     * @ApiDocMethod
     * @ApiCode ORD_2032
     * @RestRelativeURL orderdeal/autoConfirmOrder
	 */
	@POST
	@Path("/autoConfirmOrder")
	BaseResponse autoConfirmOrder()throws BusinessException,SystemException;

}
