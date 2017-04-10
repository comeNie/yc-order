package com.ai.yc.order.api.orderquery.param;

import com.ai.opt.base.vo.BaseResponse;

public class OrdOrderCountResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	/**
	 * 总订单数
	 */
	private long orderCounts;
	/**
	 * 后付费总订单数
	 */
	private long orderHFCounts;
	/**
	 * 后付费总费用
	 */
	private long HFtotalFees;
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

	public long getOrderHFCounts() {
		return orderHFCounts;
	}

	public void setOrderHFCounts(long orderHFCounts) {
		this.orderHFCounts = orderHFCounts;
	}

	public long getHFtotalFees() {
		return HFtotalFees;
	}

	public void setHFtotalFees(long hFtotalFees) {
		HFtotalFees = hFtotalFees;
	}

}
