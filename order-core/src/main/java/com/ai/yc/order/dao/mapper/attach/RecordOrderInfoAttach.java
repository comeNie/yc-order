package com.ai.yc.order.dao.mapper.attach;

public class RecordOrderInfoAttach {
	/**
	 * 总金额
	 */
	private long totalFeeCount;
	/**
	 * 平台费用
	 */
	private long platFeeCount;
	/**
	 * 议员费用
	 */
	private long interperFeeCount;
	/**
	 * 币种
	 */
	private String currencyUnit;

	public long getTotalFeeCount() {
		return totalFeeCount;
	}

	public void setTotalFeeCount(long totalFeeCount) {
		this.totalFeeCount = totalFeeCount;
	}

	public long getPlatFeeCount() {
		return platFeeCount;
	}

	public void setPlatFeeCount(long platFeeCount) {
		this.platFeeCount = platFeeCount;
	}

	public long getInterperFeeCount() {
		return interperFeeCount;
	}

	public void setInterperFeeCount(long interperFeeCount) {
		this.interperFeeCount = interperFeeCount;
	}

	public String getCurrencyUnit() {
		return currencyUnit;
	}

	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

}
