package com.ai.slp.order.api.orderlevel.interfaces;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderlevel.interfaces.IOrderLevelSV;
import com.ai.yc.order.api.orderlevel.param.OrderLevelRequest;
import com.ai.yc.order.api.orderlevel.param.OrderLevelResponse;
import com.alibaba.fastjson.JSON;

public class OrderLevelSVImplTest extends BaseTest {
	@Autowired
	private IOrderLevelSV orderLevelSV;
	@Test
	public void getOrderLevel(){
		OrderLevelRequest request = new OrderLevelRequest();
		request.setIsUrgent("N");
		request.setTotalFee(1000);
		request.setTranslateLevel("100210");
		request.setTranslateType("1");
		log.info("request:"+JSON.toJSONString(request));
		OrderLevelResponse response = this.orderLevelSV.getOrderLevel(request);
		log.info("response:"+JSON.toJSONString(response));
	}
}
