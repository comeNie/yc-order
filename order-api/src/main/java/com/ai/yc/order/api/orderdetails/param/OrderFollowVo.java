package com.ai.yc.order.api.orderdetails.param;

import java.io.Serializable;
import java.util.List;

public class OrderFollowVo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 任务跟踪ID
	 */
	private Long receiveFollowId;
	/**
	 * 步骤
	 */
	private String step;
	/**
	 * 完成状态
	 */
	private String finishState;
	/**
	 * 领取状态
	 */
	private String receiveState;
	/**
	 * 分配人员信息
	 */
	private List<PersonInfoVo> personInfos;
	/**
	 * 领取人信息
	 */
	private ReceiveInfoVo receiveInfos;

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getFinishState() {
		return finishState;
	}

	public void setFinishState(String finishState) {
		this.finishState = finishState;
	}

	public String getReceiveState() {
		return receiveState;
	}

	public void setReceiveState(String receiveState) {
		this.receiveState = receiveState;
	}

	public Long getReceiveFollowId() {
		return receiveFollowId;
	}

	public List<PersonInfoVo> getPersonInfos() {
		return personInfos;
	}

	public void setPersonInfos(List<PersonInfoVo> personInfos) {
		this.personInfos = personInfos;
	}

	public ReceiveInfoVo getReceiveInfos() {
		return receiveInfos;
	}

	public void setReceiveInfos(ReceiveInfoVo receiveInfos) {
		this.receiveInfos = receiveInfos;
	}

	public void setReceiveFollowId(Long receiveFollowId) {
		this.receiveFollowId = receiveFollowId;
	}

}
