package com.ai.yc.order.api.paystatus.param;

import com.ai.opt.base.vo.BaseResponse;

/**
 * @author hougang@asiainfo.com
 * @date 2016年11月7日 上午10:27:16 
 * @version V1.0
 */
public class UpdatePayStatusResponse extends BaseResponse {

	private static final long serialVersionUID = 4275382707295017689L;
	
	
	private Long orderId;


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	

}
