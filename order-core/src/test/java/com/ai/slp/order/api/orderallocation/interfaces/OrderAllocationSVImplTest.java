package com.ai.slp.order.api.orderallocation.interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.base.vo.BaseListResponse;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderallocation.interfaces.IOrderAllocationSV;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationePersonRequest;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationePersones;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationBaseInfo;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationExtendInfo;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationResponse;
import com.alibaba.fastjson.JSON;

public class OrderAllocationSVImplTest extends BaseTest {
	@Autowired
	private IOrderAllocationSV orderAllocationSV;
	@Test
	public void orderAllocation(){
		OrderAllocationRequest request = new OrderAllocationRequest();
		OrderAllocationBaseInfo baseInfo = new OrderAllocationBaseInfo();
		baseInfo.setOrderId(123l);
		baseInfo.setState("211");
		baseInfo.setUserId("12345");
		baseInfo.setOperName("zhangsansan");
		baseInfo.setOperId("1222");
		//
		request.setOrderAllocationBaseInfo(baseInfo);
		//
		OrderAllocationExtendInfo extendInfo = new OrderAllocationExtendInfo();
		extendInfo.setCreartTime(DateUtil.getSysDate());
		extendInfo.setInterperFee(1000l);
		extendInfo.setInterperId("12333");
		extendInfo.setInterperName("zhangsansan");
		extendInfo.setOperType("1");
		extendInfo.setRemark("审校此订单,测试用。。。");
		extendInfo.setStep("2");
		extendInfo.setTel("13311169257");
		Timestamp t = new Timestamp(DateUtil.getCurrentTimeMillis());
		extendInfo.setExpectEndTime(t);
		
		//
		List<OrderAllocationExtendInfo> extendInfoList = new ArrayList<OrderAllocationExtendInfo>();
		//
		extendInfoList.add(extendInfo);
		//
		request.setOrderAllocationExtendInfoList(extendInfoList);
		//
		log.info("request:"+JSON.toJSONString(request));
		OrderAllocationResponse response = this.orderAllocationSV.orderAllocation(request);
		//
		log.info("response:"+JSON.toJSONString(response));
		//
	}
	@Test
	public void orderAllocationPerson(){
		OrdAllocationePersonRequest req = new OrdAllocationePersonRequest();
		//req.setOrderId(2000000057014948l);
		//req.setReceiveState("0");
		req.setInterperId("23");
		BaseListResponse<OrdAllocationePersones> response = orderAllocationSV.queryAllocationPersonInfo(req);
		System.out.println("response="+JSON.toJSONString(response));
	}
}
