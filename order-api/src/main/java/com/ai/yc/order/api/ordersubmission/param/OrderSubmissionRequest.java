package com.ai.yc.order.api.ordersubmission.param;

import java.io.Serializable;

public class OrderSubmissionRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BaseInfo baseInfo;
	private ProductInfo productInfo;
	private FeeInfo feeInfo;
	private ContactInfo contactInfo;

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

}
