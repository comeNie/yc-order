package com.ai.yc.order.service.business.interfaces;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

/**
 * @author hougang@asiainfo.com
 * @date 2016年11月18日 上午10:06:26 
 * @version V1.0
 */
public interface IAutoDealOrderBusiSV {
	
	BaseResponse autoCancelOrder();
	/**
	 * 返回订单id列表
	 * @author zhangzd
	 */
	List<String> updateAutoConfirmOrder();
	
	BaseResponse autoReviewOrder() ;

}
