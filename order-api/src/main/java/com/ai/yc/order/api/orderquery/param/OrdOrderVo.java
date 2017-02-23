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
	 * 用户类型
	 */
	private String userType;

	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 用户昵称
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
	private String lspId;
	/**
	 * lsp名称
	 */
	private String lspName;
	/**
	 * 领取人ID
	 */
	private String interperId;
	/**
	 * 译员昵称
	 */
	private String interperName;
	/**
	 * 返工标识
	 */
	private String updateFlag;
	/**
	 * 操作工号
	 */
	private String operId;
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
	 * 报价人id（费用操作人）
	 */
	private String updateOperId;
	/**
	 * 报价人
	 */
	private String updateOperName;
	/**
	 * 报价时间（费用变更时间）
	 */
	private Timestamp updateTime;
	/**
	 * 产品变更时间
	 */
	private Timestamp prodUpdateTime;
	/**
	 * 修改剩余时间（一期未用）
	 */
	private Timestamp updateRemainingTime;
	/**
	 * 状态结束时间
	 */
	private Timestamp endChgTime;
	/**
	 * 总费用
	 */
	private long totalFee;
	/**
	 * 平台佣金
	 */
	private long platFee;
	/**
	 * 译员佣金
	 */
	private long interperFee;
	/**
	 * 币种
	 */
	private String currencyUnit;

	/**
	 * 语言信息
	 */
	private List<OrdProdExtendVo> ordProdExtendList;
	/**
	 * 翻译级别
	 */
	private List<OrdProdLevelVo> ordProdLevelList;

	/**
	 * 总优惠费用
	 */
	private Long discountFee;
	/**
	 * 评论等级
	 */
	private String evaluateSun;
	/**
	 * 服务质量
	 */
	private Long serveQuality;
	/**
	 * 服务速度
	 */
	private Long serveSpeed;
	/**
	 * 服务态度
	 */
	private Long serveManner;
	/**
	 * 评论内容
	 */
	private String evaluateContent;
	/**
	 * 评论时间
	 */
	private Timestamp evaluateTime;
	/**
	 * 译员级别
	 */
	private String interLevel;
	/**
	 * 父订单ID
	 */
	private String parentOrderId;
	/**
	 * 评价状态
	 */
	private String evaluateState;

	public Long getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(Long discountFee) {
		this.discountFee = discountFee;
	}

	public String getEvaluateSun() {
		return evaluateSun;
	}

	public void setEvaluateSun(String evaluateSun) {
		this.evaluateSun = evaluateSun;
	}

	public Long getServeQuality() {
		return serveQuality;
	}

	public void setServeQuality(Long serveQuality) {
		this.serveQuality = serveQuality;
	}

	public Long getServeSpeed() {
		return serveSpeed;
	}

	public void setServeSpeed(Long serveSpeed) {
		this.serveSpeed = serveSpeed;
	}

	public Long getServeManner() {
		return serveManner;
	}

	public void setServeManner(Long serveManner) {
		this.serveManner = serveManner;
	}

	public String getEvaluateContent() {
		return evaluateContent;
	}

	public void setEvaluateContent(String evaluateContent) {
		this.evaluateContent = evaluateContent;
	}

	public Timestamp getEvaluateTime() {
		return evaluateTime;
	}

	public void setEvaluateTime(Timestamp evaluateTime) {
		this.evaluateTime = evaluateTime;
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

	public String getLspId() {
		return lspId;
	}

	public void setLspId(String lspId) {
		this.lspId = lspId;
	}

	public long getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(long totalFee) {
		this.totalFee = totalFee;
	}

	public String getCurrencyUnit() {
		return currencyUnit;
	}

	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getUpdateOperName() {
		return updateOperName;
	}

	public void setUpdateOperName(String updateOperName) {
		this.updateOperName = updateOperName;
	}

	public List<OrdProdLevelVo> getOrdProdLevelList() {
		return ordProdLevelList;
	}

	public void setOrdProdLevelList(List<OrdProdLevelVo> ordProdLevelList) {
		this.ordProdLevelList = ordProdLevelList;
	}

	public Timestamp getEndChgTime() {
		return endChgTime;
	}

	public void setEndChgTime(Timestamp endChgTime) {
		this.endChgTime = endChgTime;
	}

	public Timestamp getProdUpdateTime() {
		return prodUpdateTime;
	}

	public void setProdUpdateTime(Timestamp prodUpdateTime) {
		this.prodUpdateTime = prodUpdateTime;
	}

	public String getInterLevel() {
		return interLevel;
	}

	public void setInterLevel(String interLevel) {
		this.interLevel = interLevel;
	}

	public String getParentOrderId() {
		return parentOrderId;
	}

	public void setParentOrderId(String parentOrderId) {
		this.parentOrderId = parentOrderId;
	}

	public String getEvaluateState() {
		return evaluateState;
	}

	public void setEvaluateState(String evaluateState) {
		this.evaluateState = evaluateState;
	}

	public long getPlatFee() {
		return platFee;
	}

	public void setPlatFee(long platFee) {
		this.platFee = platFee;
	}

	public long getInterperFee() {
		return interperFee;
	}

	public void setInterperFee(long interperFee) {
		this.interperFee = interperFee;
	}

}
