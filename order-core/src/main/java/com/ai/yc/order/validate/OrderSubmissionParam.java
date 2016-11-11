package com.ai.yc.order.validate;

import java.util.HashMap;
import java.util.Map;

/**
 * 初始化键值对
 * 
 * @author zhangzd
 *
 */
public class OrderSubmissionParam {
	/**
	 * 业务类型 0：国内业务；1：国际业务
	 */
	private Map<String, String> flagMap;

	/**
	 * 订单来源 0：PC-中文站 1：PC-英文站 2：百度 3：金山 4：找翻译 5：WAP-中文 6：WAP-英语 7：微信助手
	 * 
	 */
	private Map<String, String> chlIdMap;

	/**
	 * 订单类型 "订单类型： 1：个人订单 2：企业订单 "
	 */
	private Map<String, String> orderTypeMap;

	/**
	 * 业务类型 "1：正常单 2：退费单"
	 */
	private Map<String, String> busiTypeMap;

	/**
	 * 翻译类型 "0：快速翻译 1：文档翻译 2：口译翻译"
	 * 
	 */
	private Map<String, String> translateTypeMap;

	/**
	 * 订单级别
	 */
	private Map<String, String> orderLevelMap;

	/**
	 * 报价标识 "0：系统自动报价 1：人工报价"
	 * 
	 */
	private Map<String, String> subFlagMap;

	/**
	 * 用户类型 "10：个人 11：企业 12：代理人 "
	 * 
	 */
	private Map<String, String> userTypeMap;
	/**
	 * 是否加急 N:否；Y：是
	 */
	private Map<String, String> isUrgentMap;
	/**
	 * 支付方式 "YE：余额 ZFB：支付宝 YL：网银 PP：pay pal HF：后付 JF：积分 YHQ：优惠劵 HK：银行汇款/转账"
	 */
	private Map<String, String> payStyleMap;

	public Map<String, String> getPayStyleMap() {
		return payStyleMap;
	}

	public void setPayStyleMap(Map<String, String> payStyleMap) {
		this.payStyleMap = payStyleMap;
	}

	public Map<String, String> getIsUrgentMap() {
		return isUrgentMap;
	}

	public void setIsUrgentMap(Map<String, String> isUrgentMap) {
		this.isUrgentMap = isUrgentMap;
	}

	private Map<String, String> currencyUnitMap;

	public Map<String, String> getCurrencyUnitMap() {
		return currencyUnitMap;
	}

	public void setCurrencyUnitMap(Map<String, String> currencyUnitMap) {
		this.currencyUnitMap = currencyUnitMap;
	}

	public Map<String, String> getUserTypeMap() {
		return userTypeMap;
	}

	public void setUserTypeMap(Map<String, String> userTypeMap) {
		this.userTypeMap = userTypeMap;
	}

	public Map<String, String> getChlIdMap() {
		return chlIdMap;
	}

	public void setChlIdMap(Map<String, String> chlIdMap) {
		this.chlIdMap = chlIdMap;
	}

	public Map<String, String> getOrderTypeMap() {
		return orderTypeMap;
	}

	public void setOrderTypeMap(Map<String, String> orderTypeMap) {
		this.orderTypeMap = orderTypeMap;
	}

	public Map<String, String> getBusiTypeMap() {
		return busiTypeMap;
	}

	public void setBusiTypeMap(Map<String, String> busiTypeMap) {
		this.busiTypeMap = busiTypeMap;
	}

	public Map<String, String> getTranslateTypeMap() {
		return translateTypeMap;
	}

	public void setTranslateTypeMap(Map<String, String> translateTypeMap) {
		this.translateTypeMap = translateTypeMap;
	}

	public Map<String, String> getOrderLevelMap() {
		return orderLevelMap;
	}

	public void setOrderLevelMap(Map<String, String> orderLevelMap) {
		this.orderLevelMap = orderLevelMap;
	}

	public Map<String, String> getSubFlagMap() {
		return subFlagMap;
	}

	public void setSubFlagMap(Map<String, String> subFlagMap) {
		this.subFlagMap = subFlagMap;
	}

	public Map<String, String> getFlagMap() {
		return flagMap;
	}

	public void setFlagMap(Map<String, String> flagMap) {
		this.flagMap = flagMap;
	}

}
