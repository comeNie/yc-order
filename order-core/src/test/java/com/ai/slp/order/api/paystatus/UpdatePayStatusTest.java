package com.ai.slp.order.api.paystatus;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.slp.order.api.BaseTest;
import com.ai.yc.common.api.cache.interfaces.ICacheSV;
import com.ai.yc.common.api.sysdomain.interfaces.IQuerySysDomainSV;
import com.ai.yc.common.api.sysdomain.param.QuerySysDomainDetailsRes;
import com.ai.yc.common.api.sysdomain.param.QuerySysDomainListRes;
import com.ai.yc.order.api.paystatus.interfaces.IUpdatePayStatusSV;
import com.ai.yc.order.api.paystatus.param.OrderFeeVo;
import com.ai.yc.order.api.paystatus.param.UpdatePayStatusRequest;
import com.ai.yc.order.api.paystatus.param.UpdatePayStatusResponse;
import com.ai.yc.order.service.atom.interfaces.ISysConfigAtomSV;
import com.google.gson.Gson;

public class UpdatePayStatusTest extends BaseTest {

	@Autowired
	private IUpdatePayStatusSV iUpdatePayStatusSV;

	@Test
	public void testUpdatePayStatus() {
		UpdatePayStatusRequest req = new UpdatePayStatusRequest();
		req.setOrderId(2000000001984671l);
		req.setOperId("10000");
		req.setOperName("jack");
		OrderFeeVo orderFee = new OrderFeeVo();
		orderFee.setCurrencyUnit("1");
		orderFee.setTotalFee(999l);
		orderFee.setDiscountFee(0l);
		orderFee.setOperDiscountFee(0l);
		orderFee.setAdjustFee(999l);
		orderFee.setPaidFee(999l);
		orderFee.setPayFee(0l);
		orderFee.setRemark("用户银联转账");
		orderFee.setPayStyle("11");
		req.setOrderFee(orderFee);
		UpdatePayStatusResponse resp = iUpdatePayStatusSV.updatePayStatus(req);
		Gson gson = new Gson();
		System.out.println(gson.toJson(resp));
	}

	@Autowired
	private ISysConfigAtomSV iSysConfigAtomSV;

	@Test
	public void test() {
		Gson gson = new Gson();
	/*	QuerySysDomainListRes list = DubboConsumerFactory
				.getService(IQuerySysDomainSV.class).querySysDomainList("china");
		System.out.println(gson.toJson(list));*/
		QuerySysDomainDetailsRes domain = DubboConsumerFactory
				.getService(IQuerySysDomainSV.class).querySysDomainDetails("1");
		
		System.out.println(gson.toJson(domain));
		
	}

	@Test
	public void testAreaCode() throws Exception {
		// 测试证件号码转换
		String singleParam = DubboConsumerFactory.getService(ICacheSV.class)
				.getAreaName("21");

		System.out.println("singleParam=" + singleParam);
	}

}
