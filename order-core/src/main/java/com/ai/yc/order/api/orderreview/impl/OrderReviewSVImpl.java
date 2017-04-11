package com.ai.yc.order.api.orderreview.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.orderreview.interfaces.IOrderReviewSV;
import com.ai.yc.order.api.orderreview.param.OrderLspReviewRequest;
import com.ai.yc.order.api.orderreview.param.OrderReviewRequest;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.service.business.interfaces.IOrderReviewBusiSV;
import com.ai.yc.order.util.ValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class OrderReviewSVImpl implements IOrderReviewSV {
	@Autowired
	private IOrderReviewBusiSV iOrderReviewBusiSV;
	@Override
	public BaseResponse handReviewOrder(OrderReviewRequest request) throws BusinessException, SystemException {
		/* 1.参数检验*/
		request.setTenantId(OrdersConstants.TENANT_ID);
		ValidateUtils.validateReviewOrder(request);
		BaseResponse response =new BaseResponse();
		iOrderReviewBusiSV.check(request);
        ResponseHeader responseHeader = new ResponseHeader(true,
                ExceptCodeConstants.Special.SUCCESS, "成功");
        response.setResponseHeader(responseHeader);
        return response;
	}
	@Override
	public BaseResponse handLspReviewOrder(OrderLspReviewRequest request) throws BusinessException, SystemException {
		/* 1.参数检验*/
		request.setTenantId(OrdersConstants.TENANT_ID);
		ValidateUtils.validateLspReviewOrder(request);
		BaseResponse response =new BaseResponse();
		iOrderReviewBusiSV.lspCheck(request);
        ResponseHeader responseHeader = new ResponseHeader(true,
                ExceptCodeConstants.Special.SUCCESS, "lsp审核成功");
        response.setResponseHeader(responseHeader);
        return response;
	}

}
