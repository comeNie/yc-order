package com.ai.yc.order.api.orderreceive.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.orderreceive.interfaces.IOrderReceiveSV;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveRequest;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveResponse;
import com.ai.yc.order.service.business.interfaces.IOrderReceiveBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class OrderReceiveSVImpl implements IOrderReceiveSV {
	@Autowired
	private IOrderReceiveBusiSV orderReceiveBusiSV;

	@Override
	public OrderReceiveResponse orderReceive(OrderReceiveRequest request) throws BusinessException, SystemException {
		OrderReceiveResponse response = new OrderReceiveResponse();
		//
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			response = this.orderReceiveBusiSV.updateOrderReceive(request);
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

}
