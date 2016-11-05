package com.ai.yc.order.api.ordersubmission.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.ordersubmission.interfaces.IOrderSubmissionSV;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionRequest;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionResponse;
import com.ai.yc.order.service.business.interfaces.IOrderSubmissionBusiSV;
import com.ai.yc.order.validate.OrderSubmissionValidate;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class OrderSubmissionSVImpl implements IOrderSubmissionSV {
	@Autowired
	private IOrderSubmissionBusiSV orderSubmissionBusiSV;
	@Autowired
	private OrderSubmissionValidate orderSubmissionValidate;
	@Override
	public OrderSubmissionResponse orderSubmission(OrderSubmissionRequest request)
			throws BusinessException, SystemException {
		OrderSubmissionResponse response = new OrderSubmissionResponse();
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "订单提交成功");
		//校验
		
		//
		try {
			this.orderSubmissionValidate.validate(request);
			//response = this.orderSubmissionBusiSV.saveOrderSubmission(request);
			response = this.orderSubmissionBusiSV.saveOrderSubmissionSupper(request);
			response.setResponseHeader(responseHeader);
		} catch (BusinessException e) {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			response.setResponseHeader(responseHeader);
		} catch (Exception e) {
			//e.printStackTrace();
			
		}
		return response;
	}

}
