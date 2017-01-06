package com.ai.slp.order.api.orderreceivesearch.interfaces;

import java.util.ArrayList;
import java.util.List;

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
		request.setLspId("0");
		request.setFlag("0");
		request.setInterperLevel("4");
		//request.setInterperType("0");
		//request.setTranslateName("测试1214ljq");
		request.setPageNo(1);
		
		request.setPageSize(500);
		request.setSortFlag("1");
		request.setSortField("0");
		request.setState("20");
		List<Object> languageIds = new ArrayList<Object>();
		languageIds.add("2");
		languageIds.add("1");
		//request.setLanguageIds(languageIds);
		//
		OrderWaitReceiveSearchResponse response = this.orderWaitReceiveSV.pageSearchWaitReceive(request);
		log.info("response:"+JSON.toJSONString(response));
	}
}
