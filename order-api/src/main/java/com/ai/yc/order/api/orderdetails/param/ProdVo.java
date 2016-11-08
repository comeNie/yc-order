package com.ai.yc.order.api.orderdetails.param;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description: 产品明细信息
 * @author hougang@asiainfo.com
 * @date 2016年11月4日 下午8:07:17
 * @version V1.0
 */
public class ProdVo implements Serializable {

	private static final long serialVersionUID = 8276056654189580416L;

	/**
	 * 产品明细ID
	 */
	private Long prodDetalId;
	
	/**
	 * 翻译字数
	 */
	private String translateSum;

	
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
	 * 用途中文名称
	 */
	private String useCn;
	
	/**
	 * 用途英文名称
	 */
	private String useEn;

	/**
	 * 领域ID
	 */
	private String fieldCode;
	
	/**
	 * 领域中文名称
	 */
	private String fieldCn;
	
	/**
	 * 领域英文名称
	 */
	private String fieldEn;

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

	/**
	 * 产品状态
	 * 0：未处理
     * 1：翻译中
     * 2：翻译完成
     * 3：待审核
     * 4：审核完成
     * 5：审核失败（不通过）
	 */
	private String state;

	private String lookState;

	private Long interperFee;

	/**
	 * 是否允许发票 Y/N
	 */
	private String isInvoice;

	/**
	 * 译员ID
	 */
	private String interperId;
	
	/**
	 * 变更时间
	 */
	private Timestamp updateTime;

	public Long getProdDetalId() {
		return prodDetalId;
	}

	public void setProdDetalId(Long prodDetalId) {
		this.prodDetalId = prodDetalId;
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

	public String getUseCn() {
		return useCn;
	}

	public void setUseCn(String useCn) {
		this.useCn = useCn;
	}

	public String getUseEn() {
		return useEn;
	}

	public void setUseEn(String useEn) {
		this.useEn = useEn;
	}

	public String getFieldCode() {
		return fieldCode;
	}

	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}

	public String getFieldCn() {
		return fieldCn;
	}

	public void setFieldCn(String fieldCn) {
		this.fieldCn = fieldCn;
	}

	public String getFieldEn() {
		return fieldEn;
	}

	public void setFieldEn(String fieldEn) {
		this.fieldEn = fieldEn;
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



	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLookState() {
		return lookState;
	}

	public void setLookState(String lookState) {
		this.lookState = lookState;
	}

	public Long getInterperFee() {
		return interperFee;
	}

	public void setInterperFee(Long interperFee) {
		this.interperFee = interperFee;
	}

	public String getIsInvoice() {
		return isInvoice;
	}

	public void setIsInvoice(String isInvoice) {
		this.isInvoice = isInvoice;
	}

	public String getInterperId() {
		return interperId;
	}

	public void setInterperId(String interperId) {
		this.interperId = interperId;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	

	public String getTranslateSum() {
		return translateSum;
	}

	public void setTranslateSum(String translateSum) {
		this.translateSum = translateSum;
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
    
	
    

}
