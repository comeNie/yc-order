package com.ai.yc.order.service.business.interfaces;

import com.ai.yc.order.api.orderquery.param.QueryOrdCountRequest;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateRequest;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateResponse;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;

public interface IOrdOrderBusiSV {
	public OrdOrder findByPrimaryKey(OrdOrder ordOrder);
	/**
	 * 查询订单数
	 */
	public int findOrderCount(QueryOrdCountRequest request);
	/**
	 * 修改订单状态 zhangzd 
	 */
	public OrderStateUpdateResponse updateState(OrderStateUpdateRequest request);
}
