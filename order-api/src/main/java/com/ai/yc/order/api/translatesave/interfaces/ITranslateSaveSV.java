package com.ai.yc.order.api.translatesave.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.yc.order.api.translatesave.param.SaveTranslateInfoRequest;

/**
 * @Description: 保存翻译内容
 * @author hougang@asiainfo.com
 * @date 2016年11月17日 下午6:08:38 
 * @version V1.0
 */
@Path("/translatesave")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface ITranslateSaveSV {
	
	/**
     * 保存翻译内容
     * @param 
     * @return 
     * @throws BusinessException,SystemException
     * @author hougang
     * @ApiDocMethod
     * @ApiCode ORD_2030
     * @RestRelativeURL translatesave/saveTranslateInfo
	 */
	@POST
	@Path("/saveTranslateInfo")
	BaseResponse saveTranslateInfo(SaveTranslateInfoRequest request)throws BusinessException,SystemException;

}
