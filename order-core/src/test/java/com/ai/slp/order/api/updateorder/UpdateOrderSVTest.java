package com.ai.slp.order.api.updateorder;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.updateorder.interfaces.IUpdateOrderSV;
import com.ai.yc.order.api.updateorder.param.UOrderFeeVo;
import com.ai.yc.order.api.updateorder.param.UpdateOrderRequest;

public class UpdateOrderSVTest extends BaseTest{
	
	@Autowired
	private IUpdateOrderSV iUpdateOrderSV;
	
	@Test
	public void testUpdateOrderInfo(){
		UpdateOrderRequest req = new UpdateOrderRequest();
		req.setOrderId(2000000001822168l);
		req.setOperId("10000");
		req.setOperName("ray");
		UOrderFeeVo orderFee = new UOrderFeeVo();
		orderFee.setCurrencyUnit("1");
		orderFee.setTotalFee(888l);
		orderFee.setDiscountFee(0l);
		orderFee.setOperDiscountFee(0l);
		orderFee.setAdjustFee(888l);
		orderFee.setPaidFee(888l);
		orderFee.setPayFee(0l);
		orderFee.setUpdateOperId("10000");
		orderFee.setRemark("管理员报价");
		req.setOrderFee(orderFee);
		iUpdateOrderSV.updateOrderInfo(req);
	}

}
