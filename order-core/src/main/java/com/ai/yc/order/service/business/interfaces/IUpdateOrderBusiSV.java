package com.ai.yc.order.service.business.interfaces;

import com.ai.yc.order.api.updateorder.param.UpdateOrderRequest;
import com.ai.yc.order.api.updateorder.param.UpdateOrderResponse;

/**
 * @author hougang@asiainfo.com
 * @date 2016年11月7日 下午5:20:24 
 * @version V1.0
 */
public interface IUpdateOrderBusiSV {
	
	UpdateOrderResponse updateOrderInfo(UpdateOrderRequest req);

}
