package com.ai.slp.order.api.orderreceive.interfaces;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderreceive.interfaces.IOrderReceiveSV;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveBaseInfo;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveRequest;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveResponse;
import com.alibaba.fastjson.JSON;

public class OrderReceiveSVImplTest extends BaseTest {
	@Autowired
	private IOrderReceiveSV orderReceiveSV;
	@Test
	public void orderReceive(){
		OrderReceiveRequest request = new OrderReceiveRequest();
		OrderReceiveBaseInfo baseInfo = new OrderReceiveBaseInfo();
		baseInfo.setInterperId("1111");
		baseInfo.setInterperType("0");
		baseInfo.setLockTime(DateUtil.getSysDate());
		baseInfo.setState("21");
		baseInfo.setOrderId(2000000026664786l);
		//
		request.setBaseInfo(baseInfo);
		log.info("request:"+JSON.toJSONString(request));
		OrderReceiveResponse response = this.orderReceiveSV.orderReceive(request);
		log.info("response:"+JSON.toJSONString(response));
	}
}
