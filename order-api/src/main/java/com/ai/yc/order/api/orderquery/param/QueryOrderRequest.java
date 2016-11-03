package com.ai.yc.order.api.orderquery.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

public class QueryOrderRequest extends BaseInfo {

	private static final long serialVersionUID = 1L;
	/**
	 * 用户ID，必填
	 */
	private String userId;
	/**
	 * 客户端显示状态，必填
	 */
	private String displayFlag;
	/**
	 * 订单类型（个人、企业）
	 */
	private String orderType;

	/**
	 * 翻译类型
	 */
	private String translateType;
	/**
	 * 翻译主题
	 */
	private String translateName;
	/**
	 * 下单查询开始时间
	 */
	private Timestamp orderTimeStart;
	/**
	 * 下单查询结束时间
	 */
	private Timestamp orderTimeEnd;
	/**
	 * 页码，必填
	 */
	private Integer pageNo;

	/**
	 * 每页大小，必填
	 */
	private Integer pageSize;

	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTranslateType() {
		return translateType;
	}

	public void setTranslateType(String translateType) {
		this.translateType = translateType;
	}

	public String getTranslateName() {
		return translateName;
	}

	public void setTranslateName(String translateName) {
		this.translateName = translateName;
	}

	public Timestamp getOrderTimeStart() {
		return orderTimeStart;
	}

	public void setOrderTimeStart(Timestamp orderTimeStart) {
		this.orderTimeStart = orderTimeStart;
	}

	public Timestamp getOrderTimeEnd() {
		return orderTimeEnd;
	}

	public void setOrderTimeEnd(Timestamp orderTimeEnd) {
		this.orderTimeEnd = orderTimeEnd;
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
