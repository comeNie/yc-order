package com.ai.yc.order.api.orderdetails.param;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description: 订单状态轨迹
 * @author hougang@asiainfo.com
 * @date 2016年11月5日 上午9:41:50 
 * @version V1.0
 */
public class OrderStateChgVo implements Serializable {
	
	private static final long serialVersionUID = -7147352937162509042L;

	/**
	 * 状态变更流水ID
	 */
	private Long stateChgId;

    /**
     * 原状态(后厂)
     */
    private String orgState;

    /**
     * 新状态(后厂)
     */
    private String newState;

    /**
     * 处理信息（英文）
     */
    private String chgDescEn;
    
    /**
     * 处理信息（中文）
     */
    private String chgDesc;

    /**
     * 操作机构  0：用户操作   1：系统操作
     */
    private String orgId;

    /**
     * 操作工号
     */
    private String operId;

    /**
     * 操作人姓名
     */
    private String operName;
    
    /**
     * 变更时间
     */
    private Timestamp stateChgTime;
    /**
     * 门户前端展示 英文轨迹
     */
    private String chgDescUEn;
    /**
     * 门户前端展示 中文轨迹 
     */
    private String chgDescD;

	public Long getStateChgId() {
		return stateChgId;
	}

	public void setStateChgId(Long stateChgId) {
		this.stateChgId = stateChgId;
	}

	public String getOrgState() {
		return orgState;
	}

	public void setOrgState(String orgState) {
		this.orgState = orgState;
	}

	public String getNewState() {
		return newState;
	}

	public void setNewState(String newState) {
		this.newState = newState;
	}

	public String getChgDescEn() {
		return chgDescEn;
	}

	public void setChgDescEn(String chgDescEn) {
		this.chgDescEn = chgDescEn;
	}

	public String getChgDesc() {
		return chgDesc;
	}

	public void setChgDesc(String chgDesc) {
		this.chgDesc = chgDesc;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public Timestamp getStateChgTime() {
		return stateChgTime;
	}

	public void setStateChgTime(Timestamp stateChgTime) {
		this.stateChgTime = stateChgTime;
	}

	public String getChgDescUEn() {
		return chgDescUEn;
	}

	public void setChgDescUEn(String chgDescUEn) {
		this.chgDescUEn = chgDescUEn;
	}

	public String getChgDescD() {
		return chgDescD;
	}

	public void setChgDescD(String chgDescD) {
		this.chgDescD = chgDescD;
	}
    
    

}
