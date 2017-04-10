package com.ai.yc.order.api.orderdetails.param;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description: 分配人员信息
 * @author hougang@asiainfo.com
 * @date 2016年11月4日 下午8:01:26
 * @version V1.0
 */
public class PersonInfoVo implements Serializable {

	private static final long serialVersionUID = -3423047025144403211L;

	/**
	 * 人员信息ID
	 */
	private Long personId;

	/**
	 * 步骤
	 */
	private String step;

	/**
	 * 译员ID
	 */
	private String interperId;

	/**
	 * 译员姓名
	 */
	private String interperName;

	/**
	 * 联系方式
	 */
	private String tel;

	/**
	 * 译员佣金
	 */
	private Long interperFee;

	/**
	 * 分配时间
	 */
	private Timestamp creartTime;
	/**
	 * 期望完成时间
	 */
	private Timestamp expectEndTime;

	/**
	 * 备注
	 */
	private String remark;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getInterperId() {
		return interperId;
	}

	public void setInterperId(String interperId) {
		this.interperId = interperId;
	}

	public String getInterperName() {
		return interperName;
	}

	public void setInterperName(String interperName) {
		this.interperName = interperName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Long getInterperFee() {
		return interperFee;
	}

	public void setInterperFee(Long interperFee) {
		this.interperFee = interperFee;
	}

	public Timestamp getCreartTime() {
		return creartTime;
	}

	public void setCreartTime(Timestamp creartTime) {
		this.creartTime = creartTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getExpectEndTime() {
		return expectEndTime;
	}

	public void setExpectEndTime(Timestamp expectEndTime) {
		this.expectEndTime = expectEndTime;
	}

}
