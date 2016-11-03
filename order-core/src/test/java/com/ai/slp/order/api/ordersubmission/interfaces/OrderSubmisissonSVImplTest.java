package com.ai.slp.order.api.ordersubmission.interfaces;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.ordersubmission.interfaces.IOrderSubmissionSV;
import com.ai.yc.order.api.ordersubmission.param.BaseInfo;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionRequest;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionResponse;
import com.ai.yc.order.validate.OrderSubmissionParam;
import com.ai.yc.order.validate.OrderSubmissionValidate;
import com.alibaba.fastjson.JSON;

public class OrderSubmisissonSVImplTest extends BaseTest {
	@Autowired
	private IOrderSubmissionSV orderSubmissionSV;
	
	@Autowired
	private OrderSubmissionParam orderSubmissionParam;
	@Autowired
	private OrderSubmissionValidate validate;
	@Test
	public void orderSubmission(){
		OrderSubmissionRequest request = new OrderSubmissionRequest();
		log.info("request:"+JSON.toJSONString(request));
		OrderSubmissionResponse response = this.orderSubmissionSV.orderSubmission(request);
		log.info("response:"+JSON.toJSONString(response));
	}
	@Test
	public void mapTest(){
		Map<String,String> flagMap = this.orderSubmissionParam.getFlagMap();
		log.info("flagMap:"+JSON.toJSONString(flagMap));
		log.info("orderSubmissionParam:"+JSON.toJSONString(this.orderSubmissionParam));
		//
		//OrderSubmissionValidate validate = new OrderSubmissionValidate();
		//
		OrderSubmissionRequest request = new OrderSubmissionRequest();
		//
		BaseInfo baseInfo = new BaseInfo();
		//
		baseInfo.setFlag("3");
		//
		request.setBaseInfo(baseInfo);
		//
		validate.validateNull(request);
	}
}
