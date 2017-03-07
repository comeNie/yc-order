package com.ai.slp.order.api.orderevaluationrule.interfaces;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderevaluation.interfaces.IOrderEvaluationSV;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteRequest;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteResponse;
import com.ai.yc.order.api.orderevaluation.param.UpdateOrdEvaluateRequest;
import com.ai.yc.order.orderevaluation.rule.OrderEvaluationRuleSV;
import com.alibaba.fastjson.JSON;

public class OrderEvaluationRuleTest extends BaseTest {
	@Autowired
	private OrderEvaluationRuleSV orderEvaluationRuleSV;
	@Autowired
	private IOrderEvaluationSV orderEvaluationSV;
	@Test
	public void orderEvaluationRule(){
		Integer rule = this.orderEvaluationRuleSV.orderEvaluationRule(10, 20, 30);
		log.info("评价级别---："+rule);
	}
	
	@Test
	public void orderEvaluation(){
		QueryOrdEvaluteRequest re = new QueryOrdEvaluteRequest();
		re.setOrderId(123l);
		QueryOrdEvaluteResponse response = this.orderEvaluationSV.queryOrderEvalute(re);
		 log.error("response:"+JSON.toJSONString(response));
	}
	@Test
	public void orderEvaluationUpdate(){
		UpdateOrdEvaluateRequest re = new UpdateOrdEvaluateRequest();
		re.setOrderId(123l);
		re.setState("0");
		re.setRemark("niaho测试123");
		BaseResponse response = this.orderEvaluationSV.updateEvaluateByOrdId(re);
		 log.error("response:"+JSON.toJSONString(response));
	}
}
