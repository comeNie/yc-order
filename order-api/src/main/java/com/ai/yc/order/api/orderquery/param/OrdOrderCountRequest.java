package com.ai.yc.order.api.orderquery.param;

import com.ai.opt.base.vo.BaseInfo;

public class OrdOrderCountRequest extends BaseInfo {

	private static final long serialVersionUID = 1L;
	/**
	 * 订单来源
	 */
	private String chlId;
	/**
	 * 企业id
	 */
	private String corporaId;
	/**
	 * 用户Id
	 */
	private String userId;

	public String getChlId() {
		return chlId;
	}

	public void setChlId(String chlId) {
		this.chlId = chlId;
	}

	public String getCorporaId() {
		return corporaId;
	}

	public void setCorporaId(String corporaId) {
		this.corporaId = corporaId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
