package com.ai.slp.order.api.updateorder;

import java.sql.Timestamp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderdeplay.interfaces.IOrderDeplaySV;
import com.ai.yc.order.api.orderdeplay.param.OrderDeplayRequest;
import com.ai.yc.order.api.updateorder.interfaces.IUpdateOrderSV;
import com.ai.yc.order.api.updateorder.param.UProdVo;
import com.ai.yc.order.api.updateorder.param.UpdateOrderRequest;
import com.ai.yc.order.api.updateorder.param.UpdateProdFileRequest;
import com.alibaba.fastjson.JSON;

public class UpdateOrderSVTest extends BaseTest{
	
	@Autowired
	private IUpdateOrderSV iUpdateOrderSV;
	@Autowired
	private IOrderDeplaySV iOrderDeplaySV;
	
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
	@Test
	public void testDEplayOrderInfo(){
		OrderDeplayRequest req = new OrderDeplayRequest();
		req.setOrderId(123l);
		req.setOperId("10000");
		req.setOperName("ray");
		DateUtil.getCurrentTimeMillis();
		Timestamp t = new Timestamp(DateUtil.getCurrentTimeMillis());
		req.setEndChgTime(t);
		BaseResponse reesapose = iOrderDeplaySV.orderDeplay(req);
		System.out.println("RESULT="+JSON.toJSONString(reesapose));
	}
	@Test
	public void testOrderFlie(){
		UpdateProdFileRequest req = new UpdateProdFileRequest();
		req.setOrderId(123l);
		req.setOperName("10000");
		req.setFileName("ceshi");
		req.setFileTranslateName("cehsi");
		req.setFileSaveId("11");
		req.setTaskCreation("1");
		BaseResponse reesapose = iUpdateOrderSV.updateOrderFile(req);
		System.out.println("RESULT="+JSON.toJSONString(reesapose));
	}

}
