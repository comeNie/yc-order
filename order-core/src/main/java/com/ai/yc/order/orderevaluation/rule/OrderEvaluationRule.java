package com.ai.yc.order.orderevaluation.rule;

import org.springframework.stereotype.Component;

@Component
public class OrderEvaluationRule implements OrderEvaluationRuleSV {
	public Integer orderEvaluationRule(Integer serveQuality, Integer serveSpeen, Integer serveManner) {
		Integer total = serveQuality + serveSpeen + serveManner;
		//
		Integer rule = 1;
		if (total < 60) {
			rule = 1;
			return rule;
		}
		if (total >= 60 && total <= 80) {
			rule = 2;
			return rule;
		}
		if (total > 80) {
			rule = 3;
			return rule;
		}
		//
		return rule;
	}
}
