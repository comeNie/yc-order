package com.ai.slp.order.api.orderquery.interfaces;

import java.sql.Timestamp;

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
		//request.setFlag("12io");
		//request.setOrderType("1ololp");
		Long ss= 2000000015L;
		//request.setOrderId(123L);
		//request.setOperId("10001");
		System.out.println("========="+ss.toString());
		//request.setFieldCode("3333");
		//request.setDisplayFlag("11lolo");
		/*request.setCorporaId("1");
		//request.setKeyWords(keyWords);
		//request.setLspId("1236");
		request.setInterperName("test");
		request.setOrderLevel("1");
		request.setInterperId("1");
		request.setLangungePaire("1");
		request.setTranslateType("1");
		
		request.setChlId("001");
		request.setState("11");
		request.setSubFlag("1");*/
		//request.setTranslateName("翻译");
		Timestamp ts = Timestamp.valueOf("2016-11-08 10:20:12");
		Timestamp es = Timestamp.valueOf("2018-11-11 12:20:12");
		request.setPayTimeStart(ts);
		//request.setOrderTimeStart(ts);
		//request.setStateChgTimeEnd(es);
		//request.setTranslateName("TEST");
		request.setPageSize(10);
		request.setPageNo(1);
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
		request.setLspId("123");
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
