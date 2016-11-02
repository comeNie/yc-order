package com.ai.yc.order.api.ordersubmission.param;

import java.io.Serializable;
/**
 * 订单下单联系人信息
 * @author zhangzd
 *
 */
public class ContactInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 联系人姓名
	private String contactName;
	// 联系人电话
	private String contactTel;
	// 联系人邮箱
	private String contactEmail;
	// 附加信息
	private String remark;

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
