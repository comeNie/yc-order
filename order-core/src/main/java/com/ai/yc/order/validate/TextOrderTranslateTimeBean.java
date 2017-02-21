package com.ai.yc.order.validate;
/**
 * 文本翻译规则包装类
 * @author zhangzd
 *
 */
public class TextOrderTranslateTimeBean {
	/**
	 * 翻译级别
	 */
	private String translateLevel;//
	/**
	 * 递增量
	 */
	private Integer increases;//
	/**
	 * 加急时间 按小时为单位
	 */
	private Integer urgentTime;//
	/**
	 * 非加急时间 按小时为单位
	 */
	private Integer nonUrgentTime;//

	public String getTranslateLevel() {
		return translateLevel;
	}

	public void setTranslateLevel(String translateLevel) {
		this.translateLevel = translateLevel;
	}

	public Integer getIncreases() {
		return increases;
	}

	public void setIncreases(Integer increases) {
		this.increases = increases;
	}

	public Integer getUrgentTime() {
		return urgentTime;
	}

	public void setUrgentTime(Integer urgentTime) {
		this.urgentTime = urgentTime;
	}

	public Integer getNonUrgentTime() {
		return nonUrgentTime;
	}

	public void setNonUrgentTime(Integer nonUrgentTime) {
		this.nonUrgentTime = nonUrgentTime;
	}
}
