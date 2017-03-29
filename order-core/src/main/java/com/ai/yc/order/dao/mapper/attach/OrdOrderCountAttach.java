package com.ai.yc.order.dao.mapper.attach;

public class OrdOrderCountAttach {
	/**
	 * 总订单数
	 */
	private long orderCounts;
	/**
	 * 总优惠金额
	 */
	private long discountFeeCount;
	/**
	 * 总实收费用
	 */
	private long paidFeeCount;
	/**
	 * 总应收费用
	 */
	private long adjustFeeCount;

	public long getOrderCounts() {
		return orderCounts;
	}

	public void setOrderCounts(long orderCounts) {
		this.orderCounts = orderCounts;
	}

	public long getDiscountFeeCount() {
		return discountFeeCount;
	}

	public void setDiscountFeeCount(long discountFeeCount) {
		this.discountFeeCount = discountFeeCount;
	}

	public long getPaidFeeCount() {
		return paidFeeCount;
	}

	public void setPaidFeeCount(long paidFeeCount) {
		this.paidFeeCount = paidFeeCount;
	}

	public long getAdjustFeeCount() {
		return adjustFeeCount;
	}

	public void setAdjustFeeCount(long adjustFeeCount) {
		this.adjustFeeCount = adjustFeeCount;
	}

}
