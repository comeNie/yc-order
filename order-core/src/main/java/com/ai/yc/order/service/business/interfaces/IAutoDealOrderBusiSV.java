package com.ai.yc.order.service.business.interfaces;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

/**
 * @author hougang@asiainfo.com
 * @date 2016年11月18日 上午10:06:26 
 * @version V1.0
 */
public interface IAutoDealOrderBusiSV {
	/**
	 * 返回订单id列表,自动取消/关闭功能
	 * @author zhangzd
	 */
	List<String> updateAutoCancelOrder();
	/**
	 * 返回订单id列表,自动确认功能
	 * @author zhangzd
	 */
	List<String> updateAutoConfirmOrder();
	/**
	 * 返回订单id列表,自动审核功能
	 * @author zhangzd
	 */
	List<String> updateAutoReviewOrder() ;

}
