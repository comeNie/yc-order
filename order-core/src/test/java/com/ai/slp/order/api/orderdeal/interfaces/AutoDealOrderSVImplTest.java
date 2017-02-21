package com.ai.slp.order.api.orderdeal.interfaces;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.orderdeal.interfaces.IAutoDealOrderSV;

public class AutoDealOrderSVImplTest extends BaseTest {
	@Autowired
	private IAutoDealOrderSV autoDealOrderSV;
	@Test
	public void autoConfirm(){
		this.autoDealOrderSV.autoConfirmOrder();
	}
}
