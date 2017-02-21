package com.ai.yc.order.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationExtendInfo;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationRequest;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationResponse;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteRequest;
import com.ai.yc.order.api.orderevaluation.param.QueryOrdEvaluteResponse;
import com.ai.yc.order.api.orderevaluation.param.UpdateOrdEvaluateRequest;
import com.ai.yc.order.constants.OrdOdStateChgConstants;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.constants.ResultCodeConstants;
import com.ai.yc.order.dao.mapper.bo.OrdEvaluate;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.orderevaluation.rule.OrderEvaluationRuleSV;
import com.ai.yc.order.service.atom.interfaces.IOrdEvaluateAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdStateChgAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdEvaluateBusiSV;
import com.ai.yc.order.util.SequenceUtil;

@Service
public class OrdEvaluateBusiSVImpl implements IOrdEvaluateBusiSV {
	@Autowired
	private IOrdEvaluateAtomSV ordEvaluateAtomSV;
	@Autowired
	private OrderEvaluationRuleSV orderEvaluationRuleSV; //订单规则
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;//订单主表
	@Autowired
	private IOrdOdStateChgAtomSV ordOdStateChgAtomSV;//订单轨迹表

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
	@Override
	public BaseResponse updateEvaluate(UpdateOrdEvaluateRequest request) throws BusinessException, SystemException {
		OrdEvaluate ordEvaluate = new OrdEvaluate();
		BeanUtils.copyProperties(ordEvaluate, request);
		int num =  ordEvaluateAtomSV.updateEvaluateByOrdId(ordEvaluate, request.getOrderId());
		BaseResponse response  = new BaseResponse();
		if(num>0){
			response.setResponseHeader(new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "修改成功"));
		}else{
			response.setResponseHeader(new ResponseHeader(false, ResultCodeConstants.FAIL_CODE, "修改失败"));
		}
		return response;
	}
	
	@Override
	public OrderEvaluationResponse orderEvaluation(OrderEvaluationRequest request) {
		OrdEvaluate evaluate = ordEvaluateAtomSV.findByOrderId(request.getBaseInfo().getOrderId());
		if(evaluate!=null) {
			throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "评价信息已存在,无法再次评价"); 
		}
		OrderEvaluationResponse response=new OrderEvaluationResponse();
		
		OrderEvaluationExtendInfo extendInfo = request.getExtendInfo();
		Long serveQuality = extendInfo.getServeQuality();
		Long serveSpeen = extendInfo.getServeSpeen();
		Long serveManner = extendInfo.getServeManner();
		// 1.根据规则计算评论等级
		Integer evaluationRule = orderEvaluationRuleSV.orderEvaluationRule(serveQuality.intValue(), 
				serveSpeen.intValue(), serveManner.intValue());
		//2.评价信息入库
		OrdEvaluate ordEvaluate=new OrdEvaluate();
		BeanUtils.copyVO(ordEvaluate, extendInfo);
		ordEvaluate.setEvaluateId(SequenceUtil.createEvaluateId()); 
		ordEvaluate.setOrderId(request.getBaseInfo().getOrderId());
		ordEvaluate.setEvaluateSun(String.valueOf(evaluationRule)); //1：差评；2：中评；3：好评；
		ordEvaluateAtomSV.insertSelective(ordEvaluate);
		
		//3.修改订单主表状态字段
		//3.1 先查询订单主表信息
		OrdOrder ordOrderDb = this.ordOrderAtomSV.findByPrimaryKey(request.getBaseInfo().getOrderId());
		if(ordOrderDb==null){
			throw new BusinessException(ExceptCodeConstants.Special.NO_RESULT, "订单不存在");
		}
		//3.2 修改订单主表状态 TODO
		OrdOrder ordOrderUpdate = new OrdOrder();
		ordOrderUpdate.setOrderId(request.getBaseInfo().getOrderId());
		ordOrderUpdate.setState(request.getBaseInfo().getState());
		this.ordOrderAtomSV.updateByPrimaryKeySelective(ordOrderUpdate);
		//4.入库订单轨迹表 53：已评价（瞬时状态，记录轨迹）90：完成
		OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
		ordOdStateChg.setStateChgId(SequenceUtil.createStateChgId());
		ordOdStateChg.setOrderId(request.getBaseInfo().getOrderId());
		ordOdStateChg.setChgDesc("订单 "+request.getBaseInfo().getOrderId()+" 已评价");
		ordOdStateChg.setChgDescEn("");
		ordOdStateChg.setChgDescD("");
		ordOdStateChg.setChgDescUEn("");
		ordOdStateChg.setFlag(OrdOdStateChgConstants.FLAG_USER);
		ordOdStateChg.setOrgId("1");
		ordOdStateChg.setOperId(request.getBaseInfo().getUserId());
		ordOdStateChg.setOperName(request.getBaseInfo().getOperName());
		ordOdStateChg.setOrgState(ordOrderDb.getState());
		ordOdStateChg.setNewState(request.getBaseInfo().getState());
		ordOdStateChg.setStateChgTime(DateUtil.getSysDate());
		//
		this.ordOdStateChgAtomSV.insertSelective(ordOdStateChg);
		//
		response.setOrderId(request.getBaseInfo().getOrderId());
		//
		return response;
	}
}