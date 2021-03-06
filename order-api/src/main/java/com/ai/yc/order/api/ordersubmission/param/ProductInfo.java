package com.ai.yc.order.api.ordersubmission.param;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 订单下单产品信息
 * 
 * @author zhangzd
 *
 */
public class ProductInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 翻译字数，前台传递过来 快速翻译时为必填
	 */
	private Long translateSum;// TRANSLATE_SUM
	/**
	 * 会场数量 口译翻译时为必填
	 */
	private Long meetingSum;// MEETING_SUM
	/**
	 * 译员性别 口译翻译时为必填
	 */
	private String interperGen;// INTERPER_GEN;
	/**
	 * 会议地点 口译翻译时为必填
	 */
	private String meetingAddress;// MEETING_ADDRESS;
	/**
	 * 译员数量 口译翻译时为必填
	 */
	private Long interperSum;// INTERPER_SUM;
	/**
	 * 用途ID 笔译翻译时为必填
	 */
	private String useCode;// USE_CODE
	/**
	 * 领域ID 笔译翻译时为必填
	 */
	private String fieldCode;// FIELD_CODE
	/**
	 * 是否排版 笔译翻译时为必填
	 */
	private String isSetType;// IS_SET_TYPE
	/**
	 * 是否加急 笔译翻译时为必填
	 */
	private String isUrgent;
	/**
	 * 需翻译内容 笔译翻译时为必填，文档翻译时记录ID
	 */
	private String needTranslateInfo;// NEED_TRANSLATE_INFO;
	/**
	 * 翻译内容 笔译翻译时为必填，文档翻译时记录ID
	 */
	private String translateInfo;// TRANSLATE_INFO;
	/**
	 * 开始时间 笔译订单取订单支付完成时间 口译订单取用户选择时间
	 */
	private Timestamp startTime;
	/**
	 * 结束时间 口译订单为必填
	 */
	private Timestamp endTime;
	/**
	 * 需转换格式
	 */
	private String typeDesc;
	/**
	 * 语言对数据集合
	 */
	private List<LanguagePairInfo> languagePairInfoList;
	/**
	 * 翻译级别数据集合
	 */
	private List<TranslateLevelInfo> translateLevelInfoList;
	/**
	 * 文档信息数据集合
	 */
	private List<FileInfo> fileInfoList;

	public List<FileInfo> getFileInfoList() {
		return fileInfoList;
	}

	public void setFileInfoList(List<FileInfo> fileInfoList) {
		this.fileInfoList = fileInfoList;
	}

	public List<LanguagePairInfo> getLanguagePairInfoList() {
		return languagePairInfoList;
	}

	public void setLanguagePairInfoList(List<LanguagePairInfo> languagePairInfoList) {
		this.languagePairInfoList = languagePairInfoList;
	}

	public List<TranslateLevelInfo> getTranslateLevelInfoList() {
		return translateLevelInfoList;
	}

	public void setTranslateLevelInfoList(List<TranslateLevelInfo> translateLevelInfoList) {
		this.translateLevelInfoList = translateLevelInfoList;
	}

	public Long getTranslateSum() {
		return translateSum;
	}

	public void setTranslateSum(Long translateSum) {
		this.translateSum = translateSum;
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

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

}
