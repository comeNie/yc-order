package com.ai.slp.order.api.orderquery.interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.yc.order.api.orderquery.interfaces.IOrderQuerySV;
import com.ai.yc.order.api.orderquery.param.QueryOrderRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrderRsponse;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class IOrderQuerySVImplTest {
	@Autowired
	private IOrderQuerySV iOrderQuerySV;
	@Test
	public void orderSubmission(){
		QueryOrderRequest request = new QueryOrderRequest();
		request.setUserId("123");
		
		QueryOrderRsponse response = this.iOrderQuerySV.queryOrder(request);
		
	}
}
