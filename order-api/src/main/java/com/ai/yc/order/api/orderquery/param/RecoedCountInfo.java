package com.ai.yc.order.api.orderquery.param;

public class RecoedCountInfo {
	/**
	 * 订单总费用
	 */
	private long sumTotalFee;
	/**
	 * 平台总费用
	 */
	private long sumPlatFee;
	/**
	 * 议员总费
	 */
	private long sumInterperFee;

	public long getSumTotalFee() {
		return sumTotalFee;
	}

	public void setSumTotalFee(long sumTotalFee) {
		this.sumTotalFee = sumTotalFee;
	}

	public long getSumPlatFee() {
		return sumPlatFee;
	}

	public void setSumPlatFee(long sumPlatFee) {
		this.sumPlatFee = sumPlatFee;
	}

	public long getSumInterperFee() {
		return sumInterperFee;
	}

	public void setSumInterperFee(long sumInterperFee) {
		this.sumInterperFee = sumInterperFee;
	}

}
