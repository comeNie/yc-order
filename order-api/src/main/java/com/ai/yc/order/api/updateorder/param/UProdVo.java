package com.ai.yc.order.api.updateorder.param;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Description: 产品明细信息
 * @author hougang@asiainfo.com
 * @date 2016年11月4日 下午8:07:17
 * @version V1.0
 */
public class UProdVo implements Serializable {

	private static final long serialVersionUID = 8276056654189580416L;

	
	/**
	 * 翻译字数
	 */
	private Long translateSum;

	
	/**
	 * 会场数量
	 */
	private Long meetingSum;

	/**
	 * 译员性别
	 */
	private String interperGen;

	/**
	 * 会议地点
	 */
	private String meetingAddress;

	/**
	 * 译员数量
	 */
	private Long interperSum;
	
	/**
	 * 用途ID
	 */
	private String useCode;
	
	/**
	 * 领域ID
	 */
	private String fieldCode;
	
	 /**
     * 翻译级别列表
     */
    private List<UProdLevelVo> prodLevels;

	
	/**
	 * 是否排版 Y/N
	 */
	private String isSetType;

	/**
	 * 是否加急 Y/N
	 */
	private String isUrgent;
	
	
	/**
	 * 需转换格式
	 */
	private String typeDesc;
	
	/**
	 * 需翻译内容
	 */
	private String needTranslateInfo;
	
	/**
	 * 翻译内容
	 */
	private String translateInfo;

	/**
	 * 需耗天
	 */
	private String takeDay;
	
	/**
	 * 需耗小时数
	 */
	private String takeTime;
	
	/**
	 * 开始时间
	 */
	private Timestamp stateTime;

	/**
	 * 结束时间
	 */
	private Timestamp endTime;

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

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
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

	public String getTakeDay() {
		return takeDay;
	}

	public void setTakeDay(String takeDay) {
		this.takeDay = takeDay;
	}

	public String getTakeTime() {
		return takeTime;
	}

	public void setTakeTime(String takeTime) {
		this.takeTime = takeTime;
	}

	public Timestamp getStateTime() {
		return stateTime;
	}

	public void setStateTime(Timestamp stateTime) {
		this.stateTime = stateTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
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

	public List<UProdLevelVo> getProdLevels() {
		return prodLevels;
	}

	public void setProdLevels(List<UProdLevelVo> prodLevels) {
		this.prodLevels = prodLevels;
	}

    

}
