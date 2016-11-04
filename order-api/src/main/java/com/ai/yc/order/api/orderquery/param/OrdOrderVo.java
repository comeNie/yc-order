package com.ai.yc.order.api.orderquery.param;

import java.sql.Timestamp;
import java.util.List;

import com.ai.opt.base.vo.BaseInfo;

public class OrdOrderVo extends BaseInfo {

	private static final long serialVersionUID = 1L;
	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 业务标识
	 */

	private String flag;
	/**
	 * 时区
	 */
	private String timeZone;
	/**
	 * 用户类型
	 */
	private String userType;

	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 订单来源
	 */
	private String chlId;
	/**
	 * 订单类型
	 */
	private String orderType;
	/**
	 * 业务类型
	 */
	private String busiType;

	/**
	 * 订单级别
	 */
	private String orderLevel;

	/**
	 * 翻译类型
	 */
	private String translateType;

	/**
	 * 翻译主题
	 */
	private String translateName;

	/**
	 * 客户端显示状态
	 */
	private String displayFlag;
	/**
	 * 后场订单状态
	 */
	private String state;
	/**
	 * 译员类型
	 */
	private String interperType;
	/**
	 * lsp编号
	 */
	private Long lspId;
	/**
	 * lsp名称
	 */
	private String lspName;
	/**
	 * 领取人ID
	 */
	private String interperId;
	/**
	 * 译员名称
	 */
	private String interperName;
	/**
	 * 返工标识
	 */
	private String updateFlag;
	/**
	 * 下单时间
	 */
	private Timestamp orderTime;
	/**
	 * 状态变化时间（在修改中、待确认页面为译员提交时间）
	 */
	private Timestamp stateChgTime;
	/**
	 * 领取时间
	 */
	private Timestamp lockTime;
	/**
	 * 完成时间
	 */
	private Timestamp finishTime;

	/**
	 * 支付方式
	 */
	private String payStyle;
	/**
	 * 支付时间
	 */
	private Timestamp payTime;
	/**
	 * 翻译开始时间
	 */
	private Timestamp startTime;
	/**
	 * 翻译结束时间
	 */
	private Timestamp endTime;
	/**
	 * 确认剩余时间（翻译结束时间-当前时间）
	 */
	private Timestamp remainingTime;
	/**
	 * 报价人（费用操作人）
	 */
	private String updateOperId;
	/**
	 * 报价时间（费用变更时间）
	 */
	private Timestamp updateTime;
	/**
	 * 修改剩余时间（一期未用）
	 */
	private Timestamp updateRemainingTime;

	/**
	 * 语言信息
	 */
	private List<OrdProdExtendVo> ordProdExtendList;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getChlId() {
		return chlId;
	}

	public void setChlId(String chlId) {
		this.chlId = chlId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getOrderLevel() {
		return orderLevel;
	}

	public void setOrderLevel(String orderLevel) {
		this.orderLevel = orderLevel;
	}

	public String getTranslateType() {
		return translateType;
	}

	public void setTranslateType(String translateType) {
		this.translateType = translateType;
	}

	public String getTranslateName() {
		return translateName;
	}

	public void setTranslateName(String translateName) {
		this.translateName = translateName;
	}

	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
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

	public Long getLspId() {
		return lspId;
	}

	public void setLspId(Long lspId) {
		this.lspId = lspId;
	}

	public String getLspName() {
		return lspName;
	}

	public void setLspName(String lspName) {
		this.lspName = lspName;
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

	public String getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public Timestamp getStateChgTime() {
		return stateChgTime;
	}

	public void setStateChgTime(Timestamp stateChgTime) {
		this.stateChgTime = stateChgTime;
	}

	public Timestamp getLockTime() {
		return lockTime;
	}

	public void setLockTime(Timestamp lockTime) {
		this.lockTime = lockTime;
	}

	public Timestamp getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}

	public String getPayStyle() {
		return payStyle;
	}

	public void setPayStyle(String payStyle) {
		this.payStyle = payStyle;
	}

	public Timestamp getPayTime() {
		return payTime;
	}

	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Timestamp getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(Timestamp remainingTime) {
		this.remainingTime = remainingTime;
	}

	public String getUpdateOperId() {
		return updateOperId;
	}

	public void setUpdateOperId(String updateOperId) {
		this.updateOperId = updateOperId;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getUpdateRemainingTime() {
		return updateRemainingTime;
	}

	public void setUpdateRemainingTime(Timestamp updateRemainingTime) {
		this.updateRemainingTime = updateRemainingTime;
	}

	public List<OrdProdExtendVo> getOrdProdExtendList() {
		return ordProdExtendList;
	}

	public void setOrdProdExtendList(List<OrdProdExtendVo> ordProdExtendList) {
		this.ordProdExtendList = ordProdExtendList;
	}

}
