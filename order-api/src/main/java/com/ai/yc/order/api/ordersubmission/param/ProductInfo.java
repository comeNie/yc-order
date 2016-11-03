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
	 *  "0：快速翻译
		1：文档翻译
		2：口译翻译"

	 */
	private String translateType;
	/**
	 *  语言对
	 *  数据字典获取编码
	 */
	private String langungePair;
	/**
	 *  翻译主题
	 *  快速翻译：取文本前15个字    
	 *  文档翻译：取第一个文件名称
	 *  口译翻译：用户填写 
	 */
	private String translateName;
	/**
	 *  翻译级别
	 *  "100110：陪同翻译
		100120：交替传译
		100130：同声翻译
		100210：标准级
		100220：专业级
		100230：出版级"

	 */
	private String translateLevel;
	/**
	 * 翻译字数，前台传递过来
	 * 快速翻译时为必填
	 */
	private Long translateSum;//TRANSLATE_SUM
	/**
	 *  会场数量
	 *  口译翻译时为必填
	 */
	private Long meetingSum;// MEETING_SUM
	/**
	 *  译员性别
	 *  口译翻译时为必填
	 */
	private String interperGen;// INTERPER_GEN;
	/**
	 *  会议地点
	 *  口译翻译时为必填
	 */
	private String meetingAddress;// MEETING_ADDRESS;
	/**
	 *  译员数量
	 *  口译翻译时为必填
	 */
	private Long interperSum;// INTERPER_SUM;
	/**
	 *  用途ID
	 *  笔译翻译时为必填
	 */
	private String useCode;// USE_CODE
	/**
	 *  领域ID
	 *  笔译翻译时为必填
	 */
	private String fieldCode;// FIELD_CODE
	/**
	 *  库存ID
	 *  笔译翻译时为必填
	 */
	/**
	 *  是否排版
	 *  笔译翻译时为必填
	 */
	private String isSetType;// IS_SET_TYPE
	/**
	 *  是否加急
	 *  笔译翻译时为必填
	 */
	private String isUrgent;
	/**
	 *  需翻译内容
	 *  笔译翻译时为必填，文档翻译时记录ID
	 */
	private String needTranslateInfo;// NEED_TRANSLATE_INFO;
	/**
	 *  翻译内容
	 *  笔译翻译时为必填，文档翻译时记录ID
	 */
	private String translateInfo;// TRANSLATE_INFO;
	/**
	 *  开始时间
	 *  笔译订单取订单支付完成时间        
	 *  口译订单取用户选择时间
	 */
	private Timestamp startTime;
	/**
	 *  结束时间
	 *  口译订单为必填
	 */
	private Timestamp endTime;

	public Long getTranslateSum() {
		return translateSum;
	}

	public void setTranslateSum(Long translateSum) {
		this.translateSum = translateSum;
	}

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
