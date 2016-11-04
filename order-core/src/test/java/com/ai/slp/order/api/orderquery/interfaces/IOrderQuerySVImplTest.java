package com.ai.slp.order.api.orderquery.interfaces;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderquery.interfaces.IOrderQuerySV;
import com.ai.yc.order.api.orderquery.param.QueryOrdCountRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrdCountResponse;
import com.ai.yc.order.api.orderquery.param.QueryOrderRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrderRsponse;
import com.alibaba.fastjson.JSON;

public class IOrderQuerySVImplTest extends BaseTest{
	@Autowired
	private IOrderQuerySV iOrderQuerySV;
	@Test
	public void orderQuery(){
		QueryOrderRequest request = new QueryOrderRequest();
		request.setUserId("123");
		QueryOrderRsponse response = this.iOrderQuerySV.queryOrder(request);
		log.info("response:"+JSON.toJSONString(response));
	}
	@Test
	public void orderQueryCount(){
		QueryOrdCountRequest request = new QueryOrdCountRequest();
		//request.setOrderLevel("1");
		request.setBusiType("1");
		request.setChlId("001");
		request.setInterperId("1");
		request.setInterperType("1");
		request.setState("11");
		request.setTimeZone("a");
		request.setLspId(123L);
		request.setTranslateType("1");
		request.setSubFlag("1");
		request.setCorporaId("1");
		request.setDisplayFlag("11");
		request.setUserType("1");
		request.setUserId("1");
		QueryOrdCountResponse response = this.iOrderQuerySV.queryOrderCount(request);
		log.info("response:"+JSON.toJSONString(response));
	}
}
