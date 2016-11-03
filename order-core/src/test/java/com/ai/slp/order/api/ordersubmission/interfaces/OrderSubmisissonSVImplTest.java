package com.ai.slp.order.api.ordersubmission.interfaces;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.ordersubmission.interfaces.IOrderSubmissionSV;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionRequest;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionResponse;
import com.alibaba.fastjson.JSON;

public class OrderSubmisissonSVImplTest extends BaseTest {
	@Autowired
	private IOrderSubmissionSV orderSubmissionSV;
	@Test
	public void orderSubmission(){
		OrderSubmissionRequest request = new OrderSubmissionRequest();
		log.info("request:"+JSON.toJSONString(request));
		OrderSubmissionResponse response = this.orderSubmissionSV.orderSubmission(request);
		log.info("response:"+JSON.toJSONString(response));
	}
}
