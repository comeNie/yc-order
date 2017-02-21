package com.ai.yc.order.api.ordersubmission.param;

import java.io.Serializable;

public class OrderSubmissionRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 订单基础信息
	 */
	private BaseInfo baseInfo;
	/**
	 * 产品信息
	 */
	private ProductInfo productInfo;
	/**
	 * 费用信息
	 */
	private FeeInfo feeInfo;
	/**
	 * 联系人信息
	 */
	private ContactInfo contactInfo;
	/**
	 * 轨迹信息,目前包括operName属性，需要前台登录用户传递
	 */
	private StateChgInfo stateChgInfo;

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public BaseInfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public FeeInfo getFeeInfo() {
		return feeInfo;
	}

	public void setFeeInfo(FeeInfo feeInfo) {
		this.feeInfo = feeInfo;
	}

	public StateChgInfo getStateChgInfo() {
		return stateChgInfo;
	}

	public void setStateChgInfo(StateChgInfo stateChgInfo) {
		this.stateChgInfo = stateChgInfo;
	}

}
