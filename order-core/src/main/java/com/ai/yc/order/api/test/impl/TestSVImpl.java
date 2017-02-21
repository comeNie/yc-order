package com.ai.yc.order.api.test.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.yc.order.api.test.interfaces.TestSV;
import com.ai.yc.order.api.test.param.TestRequest;
import com.ai.yc.order.api.test.param.TestResponse;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.business.interfaces.IOrdOrderBusiSV;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
@Service
@Component
public class TestSVImpl implements TestSV {
	@Autowired
	private IOrdOrderBusiSV ordOrderBusiSV;
	@Override
	public TestResponse testResponse(TestRequest request) throws BusinessException, SystemException {
		TestResponse response = new TestResponse();
		//
		OrdOrder ordOrder = new OrdOrder();
		ordOrder.setOrderId(request.getOrderId());
		//
		OrdOrder ordDb = this.ordOrderBusiSV.findByPrimaryKey(ordOrder);
		BeanUtils.copyVO(response, ordDb);
		System.out.println("----orderInfo:"+JSON.toJSONString(ordDb));
		return response;
	}

}
