package com.ai.yc.order.api.orderquery.param;

import com.ai.opt.base.vo.BaseInfo;

public class QueryOrdCountRequest extends BaseInfo  {

	private static final long serialVersionUID = 1L;
	/**
	 * 系统ID
	 */
	private String systemId;
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
	    * 订单状态(后厂)
	    * 10：提交 
		*11：待支付
		*12：已支付
		*13：待报价
		*20：待领取
		*21：已领取
		*211：已分配
		*23：翻译中
		*24：已提交
		*25：修改中
		*40：待审核
		*41：已审核
		*42：审核失败（审核不通过）
		*50：待确认
		*51：已确认
		*52：待评价
		*53：已评价
		*90：完成
		*91：关闭（取消）
		*92：已退款
	     */
	private String state;
	
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
	 * 企业ID
	 */
	private String corporaId;
	
	/**
	 * 译员类型
	 */
	private String interperType;
	/**
	 * LSP编号
	 */
	private String lspId;
	/**
	 * 领取人（译员）ID
	 */
	private String interperId;
	
	private String interperLevel;

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
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

	public String getCorporaId() {
		return corporaId;
	}

	public void setCorporaId(String corporaId) {
		this.corporaId = corporaId;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getInterperLevel() {
		return interperLevel;
	}

	public void setInterperLevel(String interperLevel) {
		this.interperLevel = interperLevel;
	}
	
	

}
