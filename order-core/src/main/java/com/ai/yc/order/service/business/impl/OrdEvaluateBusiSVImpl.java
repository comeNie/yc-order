package com.ai.yc.order.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.opt.base.vo.ResponseHeader;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteRequest;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteResponse;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.constants.ResultCodeConstants;
import com.ai.yc.order.dao.mapper.bo.OrdEvaluate;
import com.ai.yc.order.service.atom.interfaces.IOrdEvaluateAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdEvaluateBusiSV;

@Service
public class OrdEvaluateBusiSVImpl implements IOrdEvaluateBusiSV {
	@Autowired
	private IOrdEvaluateAtomSV ordEvaluateAtomSV;
	@Override
	public QueryOrdEvaluteResponse queryEvaluteByOrdId(QueryOrdEvaluteRequest request) {
		QueryOrdEvaluteResponse respponse = new QueryOrdEvaluteResponse();
		OrdEvaluate evalute = ordEvaluateAtomSV.findByOrderId(request.getOrderId(),OrdersConstants.EVALUTE_SHOW_STATE);
		if(evalute!=null){
			respponse.setEvaluateContent(evalute.getEvaluateContent());
			respponse.setEvaluateSun(evalute.getEvaluateSun());
			respponse.setEvaluateTime(evalute.getEvaluateTime());
			respponse.setServeManner(evalute.getServeManner().toString());
			respponse.setServeQuality(evalute.getServeQuality().toString());
			respponse.setServeSpeed(evalute.getServeSpeen().toString());
			respponse.setOrderId(evalute.getOrderId());
			respponse.setState(evalute.getState());
			respponse.setRemark(evalute.getRemark());
		}
		respponse.setResponseHeader(new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "查询成功"));
		return respponse;
	}

}
