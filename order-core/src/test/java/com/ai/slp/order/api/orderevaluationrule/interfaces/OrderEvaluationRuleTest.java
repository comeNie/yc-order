package com.ai.slp.order.api.orderevaluationrule.interfaces;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.orderevaluation.rule.OrderEvaluationRuleSV;

public class OrderEvaluationRuleTest extends BaseTest {
	@Autowired
	private OrderEvaluationRuleSV orderEvaluationRuleSV;
	@Test
	public void orderEvaluationRule(){
		Integer rule = this.orderEvaluationRuleSV.orderEvaluationRule(10, 20, 30);
		log.info("评价级别："+rule);
	}
}
