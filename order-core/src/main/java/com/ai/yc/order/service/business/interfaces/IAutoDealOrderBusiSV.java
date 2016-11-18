package com.ai.yc.order.service.business.interfaces;

import com.ai.opt.base.vo.BaseResponse;

/**
 * @author hougang@asiainfo.com
 * @date 2016年11月18日 上午10:06:26 
 * @version V1.0
 */
public interface IAutoDealOrderBusiSV {
	
	BaseResponse autoCancelOrder();
	
	BaseResponse autoConfirmOrder();

}
