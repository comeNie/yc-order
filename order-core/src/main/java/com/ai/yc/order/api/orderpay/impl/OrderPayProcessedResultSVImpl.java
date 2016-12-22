package com.ai.yc.order.api.orderpay.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.ai.yc.order.service.business.interfaces.search.IOrderIndexBusiSV;
import com.ai.yc.order.validate.OrderPayProcessedResultValidate;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class OrderPayProcessedResultSVImpl implements IOrderPayProcessedResultSV {
	private static Logger logger = LoggerFactory.getLogger(OrderPayProcessedResultSVImpl.class);
	@Autowired
	private OrderPayProcessedResultValidate orderPayProcessedResultValidate;
	@Autowired
	private IOrderPayProcessedResultBusiSV orderPayProcessedResultBusiSV;
	@Autowired
	private IOrderIndexBusiSV orderIndexBusiSV;//订单搜索引擎添加服务
	
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
			Long orderId = response.getOrderId();
			logger.info("订单支付结果处理返回订单编号：>>>>>>"+orderId);
			this.orderIndexBusiSV.insertSesData(response.getOrderId());
			
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
			//e.printStackTrace();
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("支付结果处理失败");
			response.setResponseHeader(responseHeader);
		}
		//
		return response;
	}

}
