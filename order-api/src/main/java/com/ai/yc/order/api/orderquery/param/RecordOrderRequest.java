package com.ai.yc.order.api.orderquery.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

public class RecordOrderRequest extends BaseInfo {
	private static final long serialVersionUID = 1L;
	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 译员ID
	 */
	private String interperId;
	/**
	 * 状态变化开始时间
	 */
	private Timestamp stateChgTimeStart;
	/**
	 * 状态变化结束时间
	 */
	private Timestamp stateChgTimeEnd;
	private Integer pageNo;

	private Integer pageSize;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getInterperId() {
		return interperId;
	}

	public void setInterperId(String interperId) {
		this.interperId = interperId;
	}

	public Timestamp getStateChgTimeStart() {
		return stateChgTimeStart;
	}

	public void setStateChgTimeStart(Timestamp stateChgTimeStart) {
		this.stateChgTimeStart = stateChgTimeStart;
	}

	public Timestamp getStateChgTimeEnd() {
		return stateChgTimeEnd;
	}

	public void setStateChgTimeEnd(Timestamp stateChgTimeEnd) {
		this.stateChgTimeEnd = stateChgTimeEnd;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
