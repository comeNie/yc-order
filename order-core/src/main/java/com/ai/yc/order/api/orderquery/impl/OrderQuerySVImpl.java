package com.ai.yc.order.api.orderquery.impl;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.orderquery.interfaces.IOrderQuerySV;
import com.ai.yc.order.api.orderquery.param.QueryOrderRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrderRsponse;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class OrderQuerySVImpl implements IOrderQuerySV {

	@Override
	public QueryOrderRsponse queryOrder(QueryOrderRequest queryOrderRequest) throws BusinessException, SystemException {
		QueryOrderRsponse response = new QueryOrderRsponse();
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "订单查询成功");
		response.setResponseHeader(responseHeader);
		return response;
		
	}

}
