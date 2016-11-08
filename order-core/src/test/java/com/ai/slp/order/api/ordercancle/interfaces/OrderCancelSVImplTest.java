package com.ai.slp.order.api.ordercancle.interfaces;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderclose.interfaces.IOrderCancelSV;
import com.ai.yc.order.api.orderclose.param.OrderCancelRequest;
import com.alibaba.fastjson.JSON;

public class OrderCancelSVImplTest  extends BaseTest{
	@Autowired
	private IOrderCancelSV iOrderCancelSV;
	@Test
	public void orderCancel(){
		OrderCancelRequest res = new OrderCancelRequest();
		res.setOrderId(123l);
		res.setOperId("123456");
		res.setReasonDesc("cesshi");
		res.setTenantId("yinyun");
		BaseResponse response = this.iOrderCancelSV.handCancelNoPayOrder(res);
		log.info("response:"+JSON.toJSONString(response));
	}
}
