package com.ai.slp.order.api.orderreceivesearch.interfaces;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderreceivesearch.interfaces.IOrderWaitReceiveSV;
import com.ai.yc.order.api.orderreceivesearch.param.OrderWaitReceiveSearchRequest;
import com.ai.yc.order.api.orderreceivesearch.param.OrderWaitReceiveSearchResponse;
import com.alibaba.fastjson.JSON;

public class IOrderWaitReceiveSVImplTest extends BaseTest {
	@Autowired
	private IOrderWaitReceiveSV orderWaitReceiveSV;
	@Test
	public void pageSearchWaitReceive(){
		OrderWaitReceiveSearchRequest request = new OrderWaitReceiveSearchRequest();
		//
		request.setFlag("0");
		request.setInterperLevel("2");
		//request.setInterperType("0");
		request.setPageNo(1);
		
		request.setPageSize(10);
		request.setSortFlag("1");
		request.setSortField("1");
		//request.setState("20");
		OrderWaitReceiveSearchResponse response = this.orderWaitReceiveSV.pageSearchWaitReceive(request);
		log.info("response:"+JSON.toJSONString(response));
	}
}
