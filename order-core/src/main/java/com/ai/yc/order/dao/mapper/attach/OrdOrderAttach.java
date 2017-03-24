package com.ai.yc.order.dao.mapper.attach;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

public class OrdOrderAttach extends BaseInfo{
	private static final long serialVersionUID = 1L;
	/**
	 * 分配人员id
	 */
	private Long personId;
	/**
	 * 订单id
	 */
	private Long orderId;

	/**
	 * 译员佣金
	 */
	private Long interperFee;
	/**
	 * 步骤
	 */
	private String step;
	/**
	 * 操作类型
	 */
	private String operType;

	/**
	 * 译员id
	 */

	private String interperId;
	/**
	 * 译员名称
	 */

	private String interperName;
	/**
	 * 联系方式
	 */

	private String tel;

	/**
	 * 分配时间
	 */
	private Timestamp creartTime;
	/**
	 * 备注
	 */

	private String remark;

	/**
	 * 领取状态
	 */
	private String receiveState;
	/**
	 * 完成状态
	 */
	private String finishState;
	/**
	 * 期望完成时间
	 */
	private Timestamp expectEndTime;
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getInterperFee() {
		return interperFee;
	}
	public void setInterperFee(Long interperFee) {
		this.interperFee = interperFee;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
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
	public String getReceiveState() {
		return receiveState;
	}
	public void setReceiveState(String receiveState) {
		this.receiveState = receiveState;
	}
	public Timestamp getExpectEndTime() {
		return expectEndTime;
	}
	public void setExpectEndTime(Timestamp expectEndTime) {
		this.expectEndTime = expectEndTime;
	}
	public String getFinishState() {
		return finishState;
	}
	public void setFinishState(String finishState) {
		this.finishState = finishState;
	}
	
}
