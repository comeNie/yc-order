package com.ai.yc.order.service.business.interfaces;

import com.ai.yc.order.api.autooffer.param.QueryAutoOfferReq;
import com.ai.yc.order.api.autooffer.param.QueryAutoOfferRes;

/**
 * @author hougang@asiainfo.com
 * @date 2016年11月2日 下午3:14:13 
 * @version V1.0
 */
public interface IQueryAutoOfferBusiSV {
	
	/**
	 * 获取系统自动报价
	 */
	QueryAutoOfferRes queryAutoOffer(QueryAutoOfferReq req);

}
