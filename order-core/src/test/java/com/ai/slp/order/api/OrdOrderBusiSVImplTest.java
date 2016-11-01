package com.ai.slp.order.api;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.business.interfaces.IOrdOrderBusiSV;
import com.alibaba.fastjson.JSON;

public class OrdOrderBusiSVImplTest extends BaseTest{

	@Autowired 
	private IOrdOrderBusiSV ordOrderBusiSV;
	@Test
	public void findByPrimaryKey(){
		OrdOrder ordOrder = new OrdOrder();
		ordOrder.setOrderId(new Long(1));
		System.out.println("------start------");
		OrdOrder orderDb = this.ordOrderBusiSV.findByPrimaryKey(ordOrder);
		System.out.println("------end-------:"+JSON.toJSONString(orderDb));
	}
}
