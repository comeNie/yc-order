package com.ai.yc.order.dao.mapper.attach;

public class OrdOrderHFCountAttach {
	/**
	 * 总订单数
	 */
	private long orderCounts;
	/**
	 * 总费用
	 */
	private long totalFeeCount;
	public long getOrderCounts() {
		return orderCounts;
	}
	public void setOrderCounts(long orderCounts) {
		this.orderCounts = orderCounts;
	}
	public long getTotalFeeCount() {
		return totalFeeCount;
	}
	public void setTotalFeeCount(long totalFeeCount) {
		this.totalFeeCount = totalFeeCount;
	}
	
}
