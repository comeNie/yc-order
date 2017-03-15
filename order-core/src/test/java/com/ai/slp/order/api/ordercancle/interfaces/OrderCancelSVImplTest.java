package com.ai.slp.order.api.ordercancle.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderclose.interfaces.IOrderCancelSV;
import com.ai.yc.order.api.orderclose.param.OrderCancelRequest;
import com.ai.yc.order.api.orderreview.interfaces.IOrderReviewSV;
import com.ai.yc.order.api.orderreview.param.OrderReviewRequest;
import com.alibaba.fastjson.JSON;

public class OrderCancelSVImplTest  extends BaseTest{
	@Autowired
	private IOrderCancelSV iOrderCancelSV;
	@Autowired
	private IOrderReviewSV iOrderReviewSV;
	@Test
	public void orderCancel(){
		OrderCancelRequest res = new OrderCancelRequest();
		res.setOrderId(31233123123232l);
		res.setOperId("123456");
		res.setReasonDesc("cesshi");
		res.setTenantId("yinyun");
		BaseResponse response = this.iOrderCancelSV.handCancelNoPayOrder(res);
		log.info("response:"+JSON.toJSONString(response));
	}
	@Test
	public void ordercheck(){
		OrderReviewRequest res = new OrderReviewRequest();
		List<Long> idList = new ArrayList<Long>();
		idList.add(123l);
		idList.add(435l);
		res.setOrderIdList(idList);
		/*res.setOperId("123456");
		res.setReasonDesc("cesshi");
		res.setTenantId("yinyun");*/
		res.setState("42");
		res.setOperId("123456");
		BaseResponse response = this.iOrderReviewSV.handReviewOrder(res);
		log.info("response:"+JSON.toJSONString(response));
	}
}
