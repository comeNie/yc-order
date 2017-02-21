package com.ai.slp.order.api.ordersubmission.interfaces;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.orderlevel.rule.OrderLevelUtil;

public class OrderLevelUtilTest extends BaseTest {
	@Autowired
	private OrderLevelUtil orderLevelUtil;
	//
	@Test
	public void orderLevel(){
		Integer totalFee = 10;
		String translateLevel = "100220";
		String translateType = "0";
		String isUrgent = "Y";
		
		String orderLevel = this.orderLevelUtil.orderLevel(totalFee, translateLevel, translateType, isUrgent);
		//
		log.info("orderLevel:"+orderLevel);
	}
}
