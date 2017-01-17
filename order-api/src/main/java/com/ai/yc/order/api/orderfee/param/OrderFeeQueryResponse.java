package com.ai.yc.order.api.orderfee.param;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

public class OrderFeeQueryResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 订单基本费用信息
	 */
	private OrderFeeInfo orderFeeInfo;
	/**
	 * 订单基本产品信息
	 */
	private OrderFeeProdInfo orderFeeProdInfo;
	/**
	 * 订单翻译级别信息
	 */
	private List<OrderFeeTranslateLevelInfo> orderFeeTranslateLevelInfoList;
	/**
	 * 下单的用户信息
	 */
	private OrderFeeUserInfo userInfo;

	public OrderFeeInfo getOrderFeeInfo() {
		return orderFeeInfo;
	}

	public void setOrderFeeInfo(OrderFeeInfo orderFeeInfo) {
		this.orderFeeInfo = orderFeeInfo;
	}

	public OrderFeeProdInfo getOrderFeeProdInfo() {
		return orderFeeProdInfo;
	}

	public void setOrderFeeProdInfo(OrderFeeProdInfo orderFeeProdInfo) {
		this.orderFeeProdInfo = orderFeeProdInfo;
	}

	public List<OrderFeeTranslateLevelInfo> getOrderFeeTranslateLevelInfoList() {
		return orderFeeTranslateLevelInfoList;
	}

	public void setOrderFeeTranslateLevelInfoList(List<OrderFeeTranslateLevelInfo> orderFeeTranslateLevelInfoList) {
		this.orderFeeTranslateLevelInfoList = orderFeeTranslateLevelInfoList;
	}

	public OrderFeeUserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(OrderFeeUserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
