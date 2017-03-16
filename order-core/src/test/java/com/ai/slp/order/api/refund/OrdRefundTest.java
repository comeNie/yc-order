package com.ai.slp.order.api.refund;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderrefund.interfaces.IOrderRefundSV;
import com.ai.yc.order.api.orderrefund.param.OrderRefundRequest;
import com.ai.yc.order.api.orderrefund.param.OrderRefundResponse;
import com.alibaba.fastjson.JSON;

public class OrdRefundTest  extends BaseTest{
	@Autowired
	private IOrderRefundSV orderRefundSV;
	@Test
	public void orderRefund(){
		OrderRefundRequest re = new OrderRefundRequest();
		re.setOrderId(2311111111232100l);
		re.setState("40");
		re.setBusiType("2");
		re.setDisplayFlag("40");
		//re.setOperId("123");
		re.setOperName("ceshi");
		re.setReasonDesc("退款测试");
		OrderRefundResponse response = this.orderRefundSV.refund(re);
		 log.error("response:"+JSON.toJSONString(response));
	}
}
