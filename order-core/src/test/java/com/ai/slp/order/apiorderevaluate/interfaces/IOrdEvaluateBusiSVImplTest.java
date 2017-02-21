package com.ai.slp.order.apiorderevaluate.interfaces;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderevaluation.interfaces.IOrderEvaluationSV;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteRequest;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteResponse;
import com.alibaba.fastjson.JSON;

public class IOrdEvaluateBusiSVImplTest extends BaseTest{
	@Autowired
	private IOrderEvaluationSV orderEvaluationSV;
	@Test
	public void orderQueryOrdEvaluate(){
		QueryOrdEvaluteRequest request = new QueryOrdEvaluteRequest();
		request.setOrderId(123l);
		QueryOrdEvaluteResponse response = this.orderEvaluationSV.queryOrderEvalute(request);
		log.error("response:"+JSON.toJSONString(response));
	}
}
