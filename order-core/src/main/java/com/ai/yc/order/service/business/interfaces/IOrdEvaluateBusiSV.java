package com.ai.yc.order.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteRequest;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteResponse;
import com.ai.yc.order.api.orderevaluation.param.UpdateOrdEvaluateRequest;

public interface IOrdEvaluateBusiSV {
	
	public QueryOrdEvaluteResponse queryEvaluteByOrdId(QueryOrdEvaluteRequest request)throws BusinessException, SystemException;
	
	public BaseResponse updateEvaluate(UpdateOrdEvaluateRequest request) throws BusinessException, SystemException;

}
