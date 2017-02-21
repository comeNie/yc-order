package com.ai.slp.order.api.orderallocation.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderallocation.interfaces.IOrderAllocationSV;
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
		baseInfo.setOrderId(2000000054587176l);
		baseInfo.setState("100");
		baseInfo.setUserId("12345");
		baseInfo.setOperName("zhangzd");
		//
		request.setOrderAllocationBaseInfo(baseInfo);
		//
		OrderAllocationExtendInfo extendInfo = new OrderAllocationExtendInfo();
		extendInfo.setCreartTime(DateUtil.getSysDate());
		extendInfo.setInterperFee(1000l);
		extendInfo.setInterperId("12333");
		extendInfo.setInterperName("zhangzd");
		extendInfo.setOperType("0");
		extendInfo.setRemark("翻译此订单,测试用。。。");
		extendInfo.setStep("1");
		extendInfo.setTel("15811169257");
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
}
