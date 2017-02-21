package com.ai.yc.order.api.orderevaluation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.orderevaluation.interfaces.IOrderEvaluationSV;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationRequest;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationResponse;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteRequest;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteResponse;
import com.ai.yc.order.api.orderevaluation.param.UpdateOrdEvaluateRequest;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdEvaluateBusiSV;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class OrderEvaluationSVImpl implements IOrderEvaluationSV{
	@Autowired
	private IOrdEvaluateBusiSV ordEvaluateBusiSV;
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Override
	public OrderEvaluationResponse orderEvaluation(OrderEvaluationRequest request)
			throws BusinessException, SystemException {
		return null;
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
		return ordEvaluateBusiSV.updateEvaluate(request);
	}

}
