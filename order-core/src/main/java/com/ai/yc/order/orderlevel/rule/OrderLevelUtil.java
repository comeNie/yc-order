package com.ai.yc.order.orderlevel.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.yc.order.constants.OrdersConstants;
@Service
public class OrderLevelUtil {
	@Autowired
	private OrderLevelMap orderLevelMap;

	public String orderLevel(Integer totalFee, String translateLevel, String translateType, String isUrgent) {
		//
		String orderLever = "";
		String keyPrefix = "";
		// 出版级别或者翻译类型为口译 那么就返回V4级别
		if (OrdersConstants.TranslateLevel.PUBLISH.equals(translateLevel)
				|| OrdersConstants.TranslateType.ORDER_TYPE_ORAL.equals(translateType)) {
			return "4";
		}
		
		//如果费用小于99元
		if(totalFee > 0 && totalFee <= 99000){
			//
			keyPrefix = "0_99_";
			
		}
		//100~499
		if(totalFee > 99000 && totalFee <= 499000){
			keyPrefix = "100_499_";
		}
		//500~1999
		if(totalFee > 499000 && totalFee <= 1999000){
			keyPrefix = "500_1999_";
		}
		//大于2000
		if(totalFee > 1999000){
			keyPrefix = "2000_";
		}
		//
		orderLever = this.orderLevelMap.getOrderLevelMap().get(keyPrefix+translateLevel+"_"+isUrgent);
		//
		return orderLever;
	}
	
}
