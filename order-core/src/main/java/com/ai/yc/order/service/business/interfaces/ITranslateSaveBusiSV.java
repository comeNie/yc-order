package com.ai.yc.order.service.business.interfaces;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.yc.order.api.translatesave.param.SaveTranslateInfoRequest;

/**
 * @author hougang@asiainfo.com
 * @date 2016年11月17日 下午8:27:39 
 * @version V1.0
 */
public interface ITranslateSaveBusiSV {
	
	BaseResponse saveTranslateInfo(SaveTranslateInfoRequest request);

}
