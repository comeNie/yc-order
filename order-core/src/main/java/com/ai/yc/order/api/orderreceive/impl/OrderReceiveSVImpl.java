package com.ai.yc.order.api.orderreceive.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.orderreceive.interfaces.IOrderReceiveSV;
import com.ai.yc.order.api.orderreceive.param.OrderAlloReceiveRequest;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveRequest;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveResponse;
import com.ai.yc.order.service.business.interfaces.IOrderReceiveBusiSV;
import com.ai.yc.order.service.business.interfaces.search.IOrderIndexBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class OrderReceiveSVImpl implements IOrderReceiveSV {
	@Autowired
	private IOrderReceiveBusiSV orderReceiveBusiSV;
	@Autowired
	private IOrderIndexBusiSV orderIndexBusiSV;//订单搜索引擎添加服务

	@Override
	public OrderReceiveResponse orderReceive(OrderReceiveRequest request) throws BusinessException, SystemException {
		OrderReceiveResponse response = new OrderReceiveResponse();
		//
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			response = this.orderReceiveBusiSV.updateOrderReceive(request);
			//
			this.orderIndexBusiSV.insertSesData(response.getOrderId());
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("订单领取成功");
			response.setResponseHeader(responseHeader);
		} catch (BusinessException | SystemException e) {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			response.setResponseHeader(responseHeader);
		}
		//
		return response;
	}

	@Override
	public OrderReceiveResponse orderAlloReceive(OrderAlloReceiveRequest request)
			throws BusinessException, SystemException {
		return null;
	}

}
