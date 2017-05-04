package com.ai.yc.order.api.orderevaluation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.orderevaluation.interfaces.IOrderEvaluationSV;
import com.ai.yc.order.api.orderevaluation.param.OrdEvaluationRuleRequest;
import com.ai.yc.order.api.orderevaluation.param.OrdEvaluationRuleResponse;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationRequest;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationResponse;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteRequest;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteResponse;
import com.ai.yc.order.api.orderevaluation.param.UpdateOrdEvaluateRequest;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdEvaluateBusiSV;
import com.ai.yc.order.service.business.interfaces.search.IOrderIndexBusiSV;
import com.ai.yc.order.util.ValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class OrderEvaluationSVImpl implements IOrderEvaluationSV{
	@Autowired
	private IOrdEvaluateBusiSV ordEvaluateBusiSV;
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Autowired
	IOrderIndexBusiSV orderIndexBusiSV;
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
			orderIndexBusiSV.insertSesData(response.getOrderId());
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

	@Override
	public BaseResponse updateEvaluateByOrdId(UpdateOrdEvaluateRequest request)
			throws BusinessException, SystemException {
		if(null == request){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
		}
		if(null == request.getOrderId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单ID不能为空");
		}
		//校验orderid是否存在
		OrdOrder ordOrder = ordOrderAtomSV.findByPrimaryKey(request.getOrderId());
		if(ordOrder==null){
			throw new BusinessException(ExceptCodeConstants.Special.NO_RESULT, "该订单不存在");
		}
		BaseResponse response = ordEvaluateBusiSV.updateEvaluate(request);
		//刷新数据到搜索引擎
		orderIndexBusiSV.insertSesData(request.getOrderId());
		return response;
	}

	@Override
	public OrdEvaluationRuleResponse orderEvaluationRule(OrdEvaluationRuleRequest request)
			throws BusinessException, SystemException {
		ValidateUtils.validateEvaluteRule(request);
		OrdEvaluationRuleResponse response  =new OrdEvaluationRuleResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try{
			Integer evaluationRule = ordEvaluateBusiSV.orderEvaluateRule(request.getServeQuality(), 
					request.getServeSpeen(), request.getServeManner());
			response.setRuleLevel(evaluationRule);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("订单规则成功");
			response.setResponseHeader(responseHeader);
		}catch(Exception e){
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("订单规则失败");
			response.setResponseHeader(responseHeader);
		}
		//
		return response;
	}

}