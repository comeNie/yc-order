package com.ai.yc.order.service.business.interfaces;

import com.ai.yc.order.api.orderdetails.param.QueryOrderDetailsResponse;

/**
 * @Description: 订单详情查询
 * @author hougang@asiainfo.com
 * @date 2016年11月5日 上午10:01:07 
 * @version V1.0
 */
public interface IQueryOrderDetailsBusiSV {
	
	QueryOrderDetailsResponse queryOrderDetails(Long orderId,String flag);

	QueryOrderDetailsResponse queryOrderDetails4Portal(Long orderId, String chgStateFlag);

}
