package com.ai.yc.order.api.autooffer.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.autooffer.param.QueryAutoOfferReq;
import com.ai.yc.order.api.autooffer.param.QueryAutoOfferRes;

/**
 * @Description: 查询系统自动报价服务
 * @author hougang@asiainfo.com
 * @date 2016年11月1日 下午2:29:36 
 * @version V1.0
 */
@Path("/autooffer")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IQueryAutoOfferSV {
	
	 /**
     * 系统自动报价查询
     * @param 
     * @return 
     * @throws BusinessException,SystemException
     * @author hougang
     * @ApiDocMethod
     * @ApiCode ORD_2005
     * @RestRelativeURL autooffer/queryAutoOffer
	 */
	@POST
	@Path("/queryAutoOffer")
	QueryAutoOfferRes queryAutoOffer(QueryAutoOfferReq req)throws BusinessException,SystemException;

}
