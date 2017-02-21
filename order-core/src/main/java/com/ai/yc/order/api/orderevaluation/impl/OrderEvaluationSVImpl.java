package com.ai.yc.order.api.orderevaluation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.orderevaluation.interfaces.IOrderEvaluationSV;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationRequest;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationResponse;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteRequest;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteResponse;
import com.ai.yc.order.service.business.interfaces.IOrdEvaluateBusiSV;
import com.ai.yc.order.util.ValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class OrderEvaluationSVImpl implements IOrderEvaluationSV{
	@Autowired
	private IOrdEvaluateBusiSV ordEvaluateBusiSV;
	@Override
	public OrderEvaluationResponse orderEvaluation(OrderEvaluationRequest request)
			throws BusinessException, SystemException {
		//参数校验
		ValidateUtils.validateOrderEvaluation(request);
		OrderEvaluationResponse response = new OrderEvaluationResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try{
			response = this.ordEvaluateBusiSV.orderEvaluation(request);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("订单评价成功");
			response.setResponseHeader(responseHeader);
		}catch(BusinessException | SystemException e){
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			response.setResponseHeader(responseHeader);
		}catch(Exception e){
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("订单评价失败");
			response.setResponseHeader(responseHeader);
		}
		//
		return response;
	}

	@Override
	public QueryOrdEvaluteResponse queryOrderEvalute(QueryOrdEvaluteRequest request)
			throws BusinessException, SystemException {
		//id不能为空
		if(null == request){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
		}
		if(null == request.getOrderId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单ID不能为空");
		}
		return ordEvaluateBusiSV.queryEvaluteByOrdId(request);
	}

}
