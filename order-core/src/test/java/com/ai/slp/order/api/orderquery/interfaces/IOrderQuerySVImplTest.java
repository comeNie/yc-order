package com.ai.slp.order.api.orderquery.interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderquery.interfaces.IOrderQuerySV;
import com.ai.yc.order.api.orderquery.param.OrdOrderCountRequest;
import com.ai.yc.order.api.orderquery.param.OrdOrderCountResponse;
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
		//request.setUserName("大海HAODEDSKLDSL");
		//request.setOrderId(2000000058874544l);
		//request.setUpdateOperName("test");
		//request.setTranslateName("翻译");
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
		Timestamp ts = Timestamp.valueOf("2017-02-14 12:47:12");
		Timestamp es = Timestamp.valueOf("2017-11-14 20:20:12");
		//request.setOrderTimeStart(ts);
		//request.setEvaluateTimeStart(ts);
		//request.setEvaluateTimeEnd(es);
		//request.setOrderId(1277777773l);
			//request.setPayTimeStart(ts);
		//request.setOrderTimeEnd(es);
		//request.setStateChgTimeEnd(es);
		request.setLspId("1");
		request.setInterperId("1");
		request.setPageSize(2);
		request.setPageNo(1);
		/*List<Object> list = new ArrayList<Object>();
		Object o1 = "13";
		Object o2 = "91";
		list.add(o1);
		list.add(o2);*/
		//request.setState("90");
		//request.setStateList(list);
		//request.setOrderByFlag("3");
		//request.setUserId("100329");
		//request.setCorporaId("00000027");
		//request.setUserId("4444914");
		QueryOrderRsponse response = this.iOrderQuerySV.queryOrder(request);
		log.info("response:"+JSON.toJSONString(response));
	}
	@Test
	public void orderQueryCount(){
		QueryOrdCountRequest request = new QueryOrdCountRequest();
		List<Object> languageIds =new ArrayList<Object>();
		request.setLspId("0");
		//request.setOrderLevel("1");
		//request.setBusiType("1");
		//request.setChlId("001");
		//request.setInterperId("1");
		//request.setInterperType("1");
		request.setState("20");
		//request.setLspId("123");
		/*request.setTranslateType("1");
		request.setSubFlag("1");
		request.setCorporaId("1");
		request.setUserType("1");*/
		//request.setUserId("1");
		QueryOrdCountResponse response = this.iOrderQuerySV.queryOrderCount(request);
		log.error("response:"+JSON.toJSONString(response));
	}
	
	@Test
	public void orderQueryCountGucl(){
		QueryOrdCountRequest request = new QueryOrdCountRequest();
		//request.setLspId("0");
		//request.setFlag("0");
		request.setInterperLevel("4");
		//request.setInterperType("0");
		//request.setTranslateName("测试1214ljq");
		request.setState("20");
		List<Object> languageIds = new ArrayList<Object>();
		//languageIds.add("2");
		//languageIds.add("1");
		request.setLanguageIds(languageIds);

		QueryOrdCountResponse response = this.iOrderQuerySV.queryOrderCount4TaskCenter(request);
		log.error("response:"+JSON.toJSONString(response));
	}
	@Test
	public void orderQueryCount4user(){
		QueryOrdCountRequest request = new QueryOrdCountRequest();
		request.setUserId("4444361");;
		//request.setFlag("0");
		//request.setInterperLevel("4");
		//request.setInterperType("0");
		//request.setTranslateName("测试1214ljq");
		//request.setState("20");
		//List<Object> languageIds = new ArrayList<Object>();
		//languageIds.add("2");
		//languageIds.add("1");
		//request.setLanguageIds(languageIds);

		QueryOrdCountResponse response = this.iOrderQuerySV.queryOrderCount(request);
		log.error("response:"+JSON.toJSONString(response));
	}
	@Test
	public void orderQueryCountinfo(){
		OrdOrderCountRequest request = new OrdOrderCountRequest();
		request.setUserId("4444361");;
		OrdOrderCountResponse response = this.iOrderQuerySV.queryOrderCountInfo(request);
		log.error("response:"+JSON.toJSONString(response));
	}
}
