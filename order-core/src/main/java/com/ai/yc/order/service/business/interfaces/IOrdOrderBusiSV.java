package com.ai.yc.order.service.business.interfaces;

import java.util.Map;

import com.ai.yc.order.api.orderdeplay.param.OrderDeplayRequest;
import com.ai.yc.order.api.orderquery.param.OrdOrderCountRequest;
import com.ai.yc.order.api.orderquery.param.OrdOrderCountResponse;
import com.ai.yc.order.api.orderquery.param.QueryOrdCountRequest;
import com.ai.yc.order.api.orderrefund.param.OrderRefundCheckRequest;
import com.ai.yc.order.api.orderrefund.param.OrderRefundRequest;
import com.ai.yc.order.api.orderrefund.param.OrderRefundResponse;
import com.ai.yc.order.api.orderreprocess.param.OrderReprocessRequest;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateRequest;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateResponse;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;

public interface IOrdOrderBusiSV {
	public OrdOrder findByPrimaryKey(OrdOrder ordOrder);
	/**
	 * 查询订单数
	 */
	public Map<String,Integer> findOrderCount(QueryOrdCountRequest request);
	/**
	 * 修改订单状态 zhangzd 
	 */
	public OrderStateUpdateResponse updateState(OrderStateUpdateRequest request);
	
	/**
	 * 查询订单数(领单大厅)
	 */
	public Map<String, Integer> findOrderCount4TaskCenter(QueryOrdCountRequest request);
	/**
	 * 退款申请
	 */
	public OrderRefundResponse refundOrd(OrderRefundRequest request);
	/**
	 * 退款审核
	 */
	public OrderRefundResponse refundCheckOrd(OrderRefundCheckRequest request);
	/**
	 * 订单延时
	 */
	public void deplayOrder(OrderDeplayRequest request);
	/**
	 * 汇总信息查询
	 */
	public OrdOrderCountResponse countInfo(OrdOrderCountRequest request);
	/**
	 * 订单返工
	 */
	public void reprocessOrder(OrderReprocessRequest request);
}
