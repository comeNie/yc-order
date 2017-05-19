package com.ai.yc.order.api.orderquery.param;

import java.sql.Timestamp;
import java.util.List;


public class RecordOrderVo{

	/**
	 * 订单id
	 */
	private Long orderId;

	/**
	 * 语言信息
	 */
	private List<OrdProdExtendVo> ordProdExtendList;
	/**
	 * 状态变化时间（在修改中、待确认页面为译员提交时间）
	 */
	private Timestamp stateChgTime;
	/**
	 * 总费用
	 */
	private long totalFee;
	/**
	 * 总实收费用
	 */
	private long paidFee;
	/**
	 * 平台佣金
	 */
	private long platFee;
	/**
	 * 译员佣金
	 */
	private long interperFee;
	/**
	 * 
	 * 翻译字数
	 */
	private long translateSum;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public List<OrdProdExtendVo> getOrdProdExtendList() {
		return ordProdExtendList;
	}

	public void setOrdProdExtendList(List<OrdProdExtendVo> ordProdExtendList) {
		this.ordProdExtendList = ordProdExtendList;
	}

	public Timestamp getStateChgTime() {
		return stateChgTime;
	}

	public void setStateChgTime(Timestamp stateChgTime) {
		this.stateChgTime = stateChgTime;
	}

	public long getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(long totalFee) {
		this.totalFee = totalFee;
	}

	public long getPaidFee() {
		return paidFee;
	}

	public void setPaidFee(long paidFee) {
		this.paidFee = paidFee;
	}

	public long getPlatFee() {
		return platFee;
	}

	public void setPlatFee(long platFee) {
		this.platFee = platFee;
	}

	public long getInterperFee() {
		return interperFee;
	}

	public void setInterperFee(long interperFee) {
		this.interperFee = interperFee;
	}

	public long getTranslateSum() {
		return translateSum;
	}

	public void setTranslateSum(long translateSum) {
		this.translateSum = translateSum;
	}

}
