package com.ai.slp.order.api.orderfee.interfaces;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderfee.interfaces.IOrderFeeQuerySV;
import com.ai.yc.order.api.orderfee.param.OrderFeeQueryRequest;
import com.ai.yc.order.api.orderfee.param.OrderFeeQueryResponse;
import com.alibaba.fastjson.JSON;

public class OrderFeeQuerySVImplTest extends BaseTest {
	@Autowired
	private IOrderFeeQuerySV orderFeeQuerySV;
	@Test
	public void orderFeeQuery(){
		OrderFeeQueryRequest request = new OrderFeeQueryRequest();
		request.setOrderId(2000000023112336L);
		//
		log.info("request:"+JSON.toJSONString(request));
		OrderFeeQueryResponse response = this.orderFeeQuerySV.orderFeeQuery(request);
		log.info("response:"+JSON.toJSONString(response));
	}
}
