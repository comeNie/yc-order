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
		QueryOrdCountResponse response = this.iOrderQuerySV.queryOrderCount(request);
		log.info("response:"+JSON.toJSONString(response));
	}
}
