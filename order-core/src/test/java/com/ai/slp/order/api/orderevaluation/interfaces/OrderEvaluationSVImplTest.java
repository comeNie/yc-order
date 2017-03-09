package com.ai.slp.order.api.orderevaluation.interfaces;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderevaluation.interfaces.IOrderEvaluationSV;
import com.ai.yc.order.api.orderevaluation.param.OrdEvaluationRuleRequest;
import com.ai.yc.order.api.orderevaluation.param.OrdEvaluationRuleResponse;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationBaseInfo;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationExtendInfo;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationRequest;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationResponse;
import com.alibaba.fastjson.JSON;

public class OrderEvaluationSVImplTest extends BaseTest{
	
	@Autowired
	private IOrderEvaluationSV orderEvaluationSV;

	@Test
	public void orderEvaluation() {
		OrderEvaluationRequest request=new OrderEvaluationRequest();
		OrderEvaluationBaseInfo baseInfo=new OrderEvaluationBaseInfo();
		baseInfo.setOrderId(123l);
		baseInfo.setState("53");//53：已评价（瞬时状态，记录轨迹）   90：完成
		baseInfo.setUserId("2017221");
		baseInfo.setOperName("小雪");
		OrderEvaluationExtendInfo extendInfo=new OrderEvaluationExtendInfo();
		extendInfo.setServeManner(30l);
		extendInfo.setServeSpeen(10l);
		extendInfo.setServeQuality(15l);
		extendInfo.setEvaluateContent("翻译很不错...");
		extendInfo.setEvaluateTime(DateUtil.getSysDate());
		extendInfo.setState("0");//0 显示,1 隐藏
		extendInfo.setRemark("评价测试");
		request.setBaseInfo(baseInfo);
		request.setExtendInfo(extendInfo);
		OrderEvaluationResponse response = orderEvaluationSV.orderEvaluation(request);
		System.out.println(JSON.toJSONString(response));
	}
	@Test
	public void orderEvaluationRule() {
		OrdEvaluationRuleRequest request=new OrdEvaluationRuleRequest();
		/*request.setServeManner(4);
		request.setServeSpeen(6);
		request.setServeQuality(30);*/
		OrdEvaluationRuleResponse response = orderEvaluationSV.orderEvaluationRule(request);
		System.out.println(JSON.toJSONString(response));
	}
}
