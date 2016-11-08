package com.ai.yc.order.api.updateorder.param;

import java.io.Serializable;

/**
 * @Description: 联系人
 * @author hougang@asiainfo.com
 * @date 2016年11月4日 下午7:55:37 
 * @version V1.0
 */
public class UContactsVo implements Serializable {

	private static final long serialVersionUID = -2487034059547502640L;
	

    /**
     * 联系人名称(必填)
     */
    private String contactName;

    /**
     * 联系人电话(必填)
     */
    private String contactTel;

    /**
     * 联系人邮箱(必填)
     */
    private String contactEmail;

    /**
     * 联系人地址
     */
    private String address;

   

	

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
    

}
