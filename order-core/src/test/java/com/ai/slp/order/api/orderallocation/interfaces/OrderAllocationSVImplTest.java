package com.ai.slp.order.api.orderallocation.interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderallocation.interfaces.IOrderAllocationSV;
import com.ai.yc.order.api.orderallocation.param.OrdAlloInterperFeeInfoResponse;
import com.ai.yc.order.api.orderallocation.param.OrdAlloInterperFeeRequest;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationPersonInfo;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationBaseInfo;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationReceiveFollowInfo;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationResponse;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationSearchRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationSearchResponse;
import com.alibaba.fastjson.JSON;

public class OrderAllocationSVImplTest extends BaseTest {
	@Autowired
	private IOrderAllocationSV orderAllocationSV;
	@Test
	public void orderAllocation(){
		OrderAllocationRequest request = new OrderAllocationRequest();
		OrderAllocationBaseInfo baseInfo = new OrderAllocationBaseInfo();
		baseInfo.setOrderId(1234l);
		baseInfo.setState("22");
		baseInfo.setUserId("12345");
		baseInfo.setOperName("zhangsansan1112");
		baseInfo.setOperId("1222");
		//
		request.setOrderAllocationBaseInfo(baseInfo);
		//
		OrderAllocationReceiveFollowInfo followInfo  = new OrderAllocationReceiveFollowInfo();
		List<OrdAllocationPersonInfo> list = new ArrayList<OrdAllocationPersonInfo>();
		OrdAllocationPersonInfo person  = new OrdAllocationPersonInfo();
		OrdAllocationPersonInfo person1  = new OrdAllocationPersonInfo();
		followInfo.setOperType("11");
		followInfo.setReceiveState("0");
		followInfo.setStep("0");
		followInfo.setFinishState("0");
		//request.setOrderAllocationReceiveFollowInfo(followInfo);
		person.setInterperId("1223");
		person.setInterperName("分配测试员");
		person.setTel("13768989009");
		person.setReamrk("ceshi");
		person.setInterperFee(190l);
		/////////////////
		person1.setInterperId("122355");
		person1.setInterperName("分配测试员2222");
		person1.setTel("1376898900922");
		person1.setReamrk("ceshi111");
		person1.setInterperFee(190l);
		Timestamp t = new Timestamp(DateUtil.getCurrentTimeMillis());
		
		person.setExpectEndTime(t);
		person.setCreartTime(t);
		list.add(person);
		list.add(person1);
		//request.setOrdAllocationPersonInfoList(list);
		//
		log.info("request:"+JSON.toJSONString(request));
		OrderAllocationResponse response = this.orderAllocationSV.orderAllocation(request);
		//
		log.info("response:"+JSON.toJSONString(response));
		//
	}
	@Test
	public void orderAllocationPerson(){
		OrderAllocationSearchRequest req = new OrderAllocationSearchRequest();
		//req.setOrderId(2000000057014948l);
		//req.setReceiveState("0");
		//req.setInterperId("1223");
		req.setPageNo(1);
		req.setPageSize(111);
		OrderAllocationSearchResponse response = orderAllocationSV.pageSearchAlloWaitReceive(req);
		System.out.println("response="+JSON.toJSONString(response));
	}
	@Test
	public void orderAllocationPersonFee(){
		OrdAlloInterperFeeRequest req = new OrdAlloInterperFeeRequest();
		req.setOrderId(1234l);
		OrdAlloInterperFeeInfoResponse response = orderAllocationSV.queryAlloInterperFee(req);
		System.out.println("response="+JSON.toJSONString(response));
	}
}
