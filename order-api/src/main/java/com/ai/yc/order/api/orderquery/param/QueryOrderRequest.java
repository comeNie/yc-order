package com.ai.yc.order.api.orderquery.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

public class QueryOrderRequest extends BaseInfo {

	private static final long serialVersionUID = 1L;
	/**
	 * 用来标识业务调用方
	 */
	private String systemId;
	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 业务标识
	 */
	private String flag;

	/**
	 * 用户类型
	 */
	private String userType;
	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 报价标识
	 */
	private String subFlag;
	/**
	 * 订单来源
	 */
	private String chlId;
	/**
	 * 订单类型
	 */
	private String orderType;
	/**
	 * 订单级别
	 */
	private String orderLevel;
	/**
	 * 翻译类型
	 */
	private String translateType;
	/**
	 * 翻译主题(模糊)
	 */
	private String translateName;

	/**
	 * 企业ID
	 */
	private String corporaId;

	/**
	 * 订单后场状态
	 */
	private String state;
	/**
	 * 客户端显示状态
	 */
	private String displayFlag;
	/**
	 * 译员类型
	 */
	private String interperType;
	/**
	 * LSP编号
	 */
	private String lspId;

	/**
	 * 领取人(译员)ID
	 */
	private String interperId;
	/**
	 * 订单关键词
	 */
	private String keyWords;
	/**
	 * 返工标识
	 */
	private String updateFlag;

	/**
	 * 状态变化开始时间
	 */
	private Timestamp stateChgTimeStart;
	/**
	 * 状态变化结束时间
	 */
	private Timestamp stateChgTimeEnd;

	/**
	 * 下单查询开始时间
	 */
	private Timestamp orderTimeStart;
	/**
	 * 下单查询结束时间
	 */
	private Timestamp orderTimeEnd;

	/**
	 * 领取开始时间
	 */
	private Timestamp lockTimeStart;
	/**
	 * 领取结束时间
	 */
	private Timestamp lockTimeEnd;

	/**
	 * 语言对ID
	 */
	private String langungePaire;
	/**
	 * 用途ID
	 */
	private String useCode;
	/**
	 * 领域ID
	 */
	private String fieldCode;
	/**
	 * 用户昵称(模糊)
	 */
	private String userName;
	/**
	 * 译员昵称(模糊)
	 */
	private String interperName;

	/**
	 * LSP名称
	 */
	private String lspName;

	/**
	 * 支付方式
	 */
	private String payStyle;
	/**
	 * 支付开始时间
	 */
	private Timestamp payTimeStart;
	/**
	 * 支付结束时间
	 */
	private Timestamp payTimeEnd;

	/**
	 * 报价人
	 */
	private String updateOperId;
	/**
	 * 报价开始时间
	 */
	private Timestamp updateTimeStart;
	/**
	 * 报价结束时间
	 */
	private Timestamp updateTimeEnd;

	/**
	 * 页码，必填
	 */
	private Integer pageNo;

	/**
	 * 每页大小，必填
	 */
	private Integer pageSize;

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

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

	public String getSubFlag() {
		return subFlag;
	}

	public void setSubFlag(String subFlag) {
		this.subFlag = subFlag;
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

	public String getCorporaId() {
		return corporaId;
	}

	public void setCorporaId(String corporaId) {
		this.corporaId = corporaId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
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

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	public Timestamp getStateChgTimeStart() {
		return stateChgTimeStart;
	}

	public void setStateChgTimeStart(Timestamp stateChgTimeStart) {
		this.stateChgTimeStart = stateChgTimeStart;
	}

	public Timestamp getStateChgTimeEnd() {
		return stateChgTimeEnd;
	}

	public void setStateChgTimeEnd(Timestamp stateChgTimeEnd) {
		this.stateChgTimeEnd = stateChgTimeEnd;
	}

	public Timestamp getOrderTimeStart() {
		return orderTimeStart;
	}

	public void setOrderTimeStart(Timestamp orderTimeStart) {
		this.orderTimeStart = orderTimeStart;
	}

	public Timestamp getOrderTimeEnd() {
		return orderTimeEnd;
	}

	public void setOrderTimeEnd(Timestamp orderTimeEnd) {
		this.orderTimeEnd = orderTimeEnd;
	}

	public Timestamp getLockTimeStart() {
		return lockTimeStart;
	}

	public void setLockTimeStart(Timestamp lockTimeStart) {
		this.lockTimeStart = lockTimeStart;
	}

	public Timestamp getLockTimeEnd() {
		return lockTimeEnd;
	}

	public void setLockTimeEnd(Timestamp lockTimeEnd) {
		this.lockTimeEnd = lockTimeEnd;
	}

	public String getLangungePaire() {
		return langungePaire;
	}

	public void setLangungePaire(String langungePaire) {
		this.langungePaire = langungePaire;
	}

	public String getUseCode() {
		return useCode;
	}

	public void setUseCode(String useCode) {
		this.useCode = useCode;
	}

	public String getFieldCode() {
		return fieldCode;
	}

	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLspName() {
		return lspName;
	}

	public void setLspName(String lspName) {
		this.lspName = lspName;
	}

	public String getPayStyle() {
		return payStyle;
	}

	public void setPayStyle(String payStyle) {
		this.payStyle = payStyle;
	}

	public Timestamp getPayTimeStart() {
		return payTimeStart;
	}

	public void setPayTimeStart(Timestamp payTimeStart) {
		this.payTimeStart = payTimeStart;
	}

	public Timestamp getPayTimeEnd() {
		return payTimeEnd;
	}

	public void setPayTimeEnd(Timestamp payTimeEnd) {
		this.payTimeEnd = payTimeEnd;
	}

	public String getUpdateOperId() {
		return updateOperId;
	}

	public void setUpdateOperId(String updateOperId) {
		this.updateOperId = updateOperId;
	}

	public Timestamp getUpdateTimeStart() {
		return updateTimeStart;
	}

	public void setUpdateTimeStart(Timestamp updateTimeStart) {
		this.updateTimeStart = updateTimeStart;
	}

	public Timestamp getUpdateTimeEnd() {
		return updateTimeEnd;
	}

	public void setUpdateTimeEnd(Timestamp updateTimeEnd) {
		this.updateTimeEnd = updateTimeEnd;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getInterperName() {
		return interperName;
	}

	public void setInterperName(String interperName) {
		this.interperName = interperName;
	}

}
