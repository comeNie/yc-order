package com.ai.yc.order.api.orderevaluation.param;

import java.io.Serializable;

import com.ai.opt.base.vo.BaseResponse;

public class OrdEvaluationRuleResponse extends BaseResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 评价等级,1-差评，2-中评，3-好评
	 */
	private Integer ruleLevel;
	public Integer getRuleLevel() {
		return ruleLevel;
	}
	public void setRuleLevel(Integer ruleLevel) {
		this.ruleLevel = ruleLevel;
	}
	
	

}
