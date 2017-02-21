package com.ai.slp.order.api.orderstate.interfaces;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderstate.interfaces.IOrderStateUpdateSV;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateRequest;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateResponse;
import com.alibaba.fastjson.JSON;

public class OrderStateUpdateSVImplTest extends BaseTest {
	@Autowired
	private IOrderStateUpdateSV orderStateUpdateSV;
	@Test
	public void updateState(){
		OrderStateUpdateRequest request = new OrderStateUpdateRequest();
		//
		request.setOrderId(2000000025858962l);
		request.setState("23");
		log.info("request:"+JSON.toJSONString(request));
		OrderStateUpdateResponse response = this.orderStateUpdateSV.updateState(request);
		log.info("response:"+JSON.toJSONString(response));
	}
}
