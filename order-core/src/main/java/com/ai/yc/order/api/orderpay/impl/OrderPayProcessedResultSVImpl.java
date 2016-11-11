package com.ai.yc.order.api.orderpay.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.orderpay.interfaces.IOrderPayProcessedResultSV;
import com.ai.yc.order.api.orderpay.param.OrderPayProcessedResultRequest;
import com.ai.yc.order.api.orderpay.param.OrderPayProcessedResultResponse;
import com.ai.yc.order.service.business.interfaces.IOrderPayProcessedResultBusiSV;
import com.ai.yc.order.validate.OrderPayProcessedResultValidate;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class OrderPayProcessedResultSVImpl implements IOrderPayProcessedResultSV {
	@Autowired
	private OrderPayProcessedResultValidate orderPayProcessedResultValidate;
	@Autowired
	private IOrderPayProcessedResultBusiSV orderPayProcessedResultBusiSV;
	//
	@Override
	public OrderPayProcessedResultResponse orderPayProcessedResult(OrderPayProcessedResultRequest request)
			throws BusinessException, SystemException {
		OrderPayProcessedResultResponse response = new OrderPayProcessedResultResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		//
		try{
			this.orderPayProcessedResultValidate.validate(request);
			response = this.orderPayProcessedResultBusiSV.updateOrderPayProcessedResult(request);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("订单支付结果处理成功");
			response.setResponseHeader(responseHeader);
		}catch(BusinessException | SystemException e){
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			response.setResponseHeader(responseHeader);
		}catch(Exception e){
			e.printStackTrace();
		}
		//
		return response;
	}

}
