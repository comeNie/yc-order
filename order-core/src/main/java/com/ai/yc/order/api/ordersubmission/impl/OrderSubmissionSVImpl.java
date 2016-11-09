package com.ai.yc.order.api.ordersubmission.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.ai.yc.order.service.business.interfaces.search.IOrderIndexBusiSV;
import com.ai.yc.order.validate.OrderSubmissionValidate;
import com.alibaba.dubbo.config.annotation.Service;

import sun.util.logging.resources.logging;

@Service
@Component
public class OrderSubmissionSVImpl implements IOrderSubmissionSV {
	private static Logger logger = LoggerFactory.getLogger(OrderSubmissionSVImpl.class);
	@Autowired
	private IOrderSubmissionBusiSV orderSubmissionBusiSV;
	@Autowired
	private OrderSubmissionValidate orderSubmissionValidate;
	@Autowired
	private IOrderIndexBusiSV orderIndexBusiSV;//订单搜索引擎添加服务
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
			//mds提交订单
			//response = this.orderSubmissionBusiSV.saveOrderSubmissionSupperMdsSend(request);
			Long orderId = response.getOrderId();
			logger.info("订单下单返回订单编号：>>>>>>"+orderId);
			this.orderIndexBusiSV.insertSesData(response.getOrderId());
			//
			response.setResponseHeader(responseHeader);
		} catch (BusinessException |SystemException e) {
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
