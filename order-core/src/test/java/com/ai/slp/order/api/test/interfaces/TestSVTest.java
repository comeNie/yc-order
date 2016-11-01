package com.ai.slp.order.api.test.interfaces;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.test.interfaces.TestSV;
import com.ai.yc.order.api.test.param.TestRequest;
import com.ai.yc.order.api.test.param.TestResponse;
import com.alibaba.fastjson.JSON;

public class TestSVTest extends BaseTest {
	@Autowired
	private TestSV testSV;
	@Test
	public void testResponse(){
		TestRequest request = new TestRequest();
		request.setOrderId(1l);
		//
		log.info("request:"+JSON.toJSONString(request));
		TestResponse response = this.testSV.testResponse(request);
		log.info("response:"+JSON.toJSONString(response));
	}
}
