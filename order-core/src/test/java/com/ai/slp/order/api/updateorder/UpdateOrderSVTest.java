package com.ai.slp.order.api.updateorder;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.updateorder.interfaces.IUpdateOrderSV;
import com.ai.yc.order.api.updateorder.param.UProdVo;
import com.ai.yc.order.api.updateorder.param.UpdateOrderRequest;

public class UpdateOrderSVTest extends BaseTest{
	
	@Autowired
	private IUpdateOrderSV iUpdateOrderSV;
	
	@Test
	public void testUpdateOrderInfo(){
		UpdateOrderRequest req = new UpdateOrderRequest();
		req.setOrderId(2000000026089247l);
		req.setOperId("10000");
		req.setOperName("ray");
		UProdVo prod = new UProdVo();
		prod.setTranslateInfo("翻译内容。");
		req.setProd(prod);
		iUpdateOrderSV.updateOrderInfo(req);
	}

}
