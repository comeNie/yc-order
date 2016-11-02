package com.ai.yc.order.api.ordersubmission.param;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 订单下单产品信息
 * @author zhangzd
 *
 */
public class ProductInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  翻译类型
	 */
	private String translateType;
	/**
	 *  语言对
	 */
	private String langungePair;
	/**
	 *  翻译主题
	 */
	private String translateName;
	/**
	 *  翻译级别
	 */
	private String translateLevel;
	/**
	 *  会场数量
	 */
	private Long meetingSum;// MEETING_SUM
	/**
	 *  译员性别
	 */
	private String interperGen;// INTERPER_GEN;
	/**
	 *  会议地点
	 */
	private String meetingAddress;// MEETING_ADDRESS;
	/**
	 *  译员数量
	 */
	private Long interperSum;// INTERPER_SUM;
	/**
	 *  用途ID
	 */
	private String useCode;// USE_CODE
	/**
	 *  领域ID
	 */
	private String fieldCode;// FIELD_CODE
	/**
	 *  库存ID
	 */
	/**
	 *  是否排版
	 */
	private String isSetType;// IS_SET_TYPE
	/**
	 *  是否加急
	 */
	private String isUrgent;
	/**
	 *  需翻译内容
	 */
	private String needTranslateInfo;// NEED_TRANSLATE_INFO;
	/**
	 *  翻译内容
	 */
	private String translateInfo;// TRANSLATE_INFO;
	/**
	 *  开始时间
	 */
	private Timestamp startTime;
	/**
	 *  结束时间
	 */
	private Timestamp endTime;

	public String getTranslateType() {
		return translateType;
	}

	public void setTranslateType(String translateType) {
		this.translateType = translateType;
	}

	public String getLangungePair() {
		return langungePair;
	}

	public void setLangungePair(String langungePair) {
		this.langungePair = langungePair;
	}

	public String getTranslateName() {
		return translateName;
	}

	public void setTranslateName(String translateName) {
		this.translateName = translateName;
	}

	public String getTranslateLevel() {
		return translateLevel;
	}

	public void setTranslateLevel(String translateLevel) {
		this.translateLevel = translateLevel;
	}

	public Long getMeetingSum() {
		return meetingSum;
	}

	public void setMeetingSum(Long meetingSum) {
		this.meetingSum = meetingSum;
	}

	public String getInterperGen() {
		return interperGen;
	}

	public void setInterperGen(String interperGen) {
		this.interperGen = interperGen;
	}

	public String getMeetingAddress() {
		return meetingAddress;
	}

	public void setMeetingAddress(String meetingAddress) {
		this.meetingAddress = meetingAddress;
	}

	public Long getInterperSum() {
		return interperSum;
	}

	public void setInterperSum(Long interperSum) {
		this.interperSum = interperSum;
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

	public String getIsSetType() {
		return isSetType;
	}

	public void setIsSetType(String isSetType) {
		this.isSetType = isSetType;
	}

	public String getIsUrgent() {
		return isUrgent;
	}

	public void setIsUrgent(String isUrgent) {
		this.isUrgent = isUrgent;
	}

	public String getNeedTranslateInfo() {
		return needTranslateInfo;
	}

	public void setNeedTranslateInfo(String needTranslateInfo) {
		this.needTranslateInfo = needTranslateInfo;
	}

	public String getTranslateInfo() {
		return translateInfo;
	}

	public void setTranslateInfo(String translateInfo) {
		this.translateInfo = translateInfo;
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

}
