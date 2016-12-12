package com.ai.slp.order.api.orderdetails;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderdetails.interfaces.IQueryOrderDetailsSV;
import com.ai.yc.order.api.orderdetails.param.QueryOrderDetailsResponse;
import com.google.gson.Gson;

public class QueryOrderDetailsSVTest extends BaseTest{
	
	@Autowired
	private IQueryOrderDetailsSV iQueryOrderDetailsSV;
	
	@Test
	public void testQueryOrderDetails(){
		QueryOrderDetailsResponse resp = iQueryOrderDetailsSV.queryOrderDetails(2000000042454212l);
		Gson gson = new Gson();
		System.out.println(gson.toJson(resp));
	}

}
