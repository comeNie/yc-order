package com.ai.yc.order.api.orderquery.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.orderquery.interfaces.IOrderQuerySV;
import com.ai.yc.order.api.orderquery.param.QueryOrdCountRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrdCountResponse;
import com.ai.yc.order.api.orderquery.param.QueryOrderRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrderRsponse;
import com.ai.yc.order.service.business.interfaces.IOrdOrderBusiSV;
import com.ai.yc.order.util.ValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class OrderQuerySVImpl implements IOrderQuerySV {
	@Autowired
	IOrdOrderBusiSV iOrdOrderBusiSV;
	@Override
	public QueryOrderRsponse queryOrder(QueryOrderRequest queryOrderRequest) throws BusinessException, SystemException {
		// 调用搜索引擎进行查询
		QueryOrderRsponse response = new QueryOrderRsponse();
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "订单查询成功");
		response.setResponseHeader(responseHeader);
		return response;

	}

	@Override
	public QueryOrdCountResponse queryOrderCount(QueryOrdCountRequest request)
			throws BusinessException, SystemException {
		//有效性校验
		ValidateUtils.validateQueryOrdCount(request);
		QueryOrdCountResponse response = new QueryOrdCountResponse();
		int count = iOrdOrderBusiSV.findOrderCount(request);
		response.setCountNumber(count);
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "查询订单数成功");
		response.setResponseHeader(responseHeader);
		return response;
	}

}
