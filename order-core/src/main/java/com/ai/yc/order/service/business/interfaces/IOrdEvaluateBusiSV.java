package com.ai.yc.order.service.business.interfaces;

import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteRequest;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteResponse;

public interface IOrdEvaluateBusiSV {
	
	public QueryOrdEvaluteResponse queryEvaluteByOrdId(QueryOrdEvaluteRequest request);

}
