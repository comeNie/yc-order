package com.ai.yc.order.api.updateorder.param;

import com.ai.opt.base.vo.BaseResponse;

/**
 * @author hougang@asiainfo.com
 * @date 2016年11月7日 下午4:33:32 
 * @version V1.0
 */
public class UpdateOrderResponse extends BaseResponse {

	private static final long serialVersionUID = 3552898637617164641L;
	
	/**
	 * 订单ID
	 */
	private Long orderId;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	

}
