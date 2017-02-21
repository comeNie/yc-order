package com.ai.yc.order.api.orderreceive.param;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 订单领单基本信息
 * @author zhangzd
 *
 */
public class OrderReceiveBaseInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 订单状态
	 */
	private String state;
	/**
	 * 译员类型
	 */
	private String interperType;// INTERPER_TYPE
	/**
	 * LSP编号
	 */
	private String lspId;
	/**
	 * 领取人ID（译员）
	 */
	private String interperId;// INTERPER_ID
	/**
	 * 领取时间
	 */
	private Timestamp lockTime;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getInterperType() {
		return interperType;
	}

	public void setInterperType(String interperType) {
		this.interperType = interperType;
	}

	public String getLspId() {
		return lspId;
	}

	public void setLspId(String lspId) {
		this.lspId = lspId;
	}

	public String getInterperId() {
		return interperId;
	}

	public void setInterperId(String interperId) {
		this.interperId = interperId;
	}

	public Timestamp getLockTime() {
		return lockTime;
	}

	public void setLockTime(Timestamp lockTime) {
		this.lockTime = lockTime;
	}
}
