package com.ai.slp.order.api.reprocess;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderreprocess.interfaces.IOrderReprocessSV;
import com.ai.yc.order.api.orderreprocess.param.OrdProductInfo;
import com.ai.yc.order.api.orderreprocess.param.OrderBaseInfo;
import com.ai.yc.order.api.orderreprocess.param.OrderReprocessRequest;
import com.ai.yc.order.api.orderreprocess.param.OrderReprocessResponse;
import com.alibaba.fastjson.JSON;

public class OrderReprocessUtilTest extends BaseTest {
	@Autowired
	private IOrderReprocessSV orderReprocessSV;
	//
	@Test
	public void orderReprocess(){
		OrderReprocessRequest req = new OrderReprocessRequest();
		OrderBaseInfo base = new OrderBaseInfo();
		base.setOperId("111");
		base.setOperName("ceshiyuan");
		base.setOrderId(123l);
		base.setReasonDesc("测试返工");
		base.setState("25");
		OrdProductInfo product = new OrdProductInfo();
		product.setTakeDay("12");
		product.setTakeTime("10");
		req.setBaseInfo(base);
		req.setProductInfo(product);
		OrderReprocessResponse response = orderReprocessSV.orderReprocess(req);
		 log.error("response:"+JSON.toJSONString(response));
	}
}
