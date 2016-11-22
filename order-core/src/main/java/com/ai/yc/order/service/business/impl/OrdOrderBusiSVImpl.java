package com.ai.yc.order.service.business.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.yc.order.api.orderquery.param.QueryOrdCountRequest;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateRequest;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateResponse;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOdStateChgAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdOrderBusiSV;
import com.ai.yc.order.util.SequenceUtil;
@Service
public class OrdOrderBusiSVImpl implements IOrdOrderBusiSV {

	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Autowired
	private IOrdOdStateChgAtomSV ordOdStateChgAtomSV;// 订单轨迹表
	
	@Override
	public OrdOrder findByPrimaryKey(OrdOrder ordOrder) {
		return this.ordOrderAtomSV.findByPrimaryKey(ordOrder);
	}
	@Override
	public Map<String,Integer> findOrderCount(QueryOrdCountRequest request) {
		OrdOrder orderRequest = new OrdOrder();
		BeanUtils.copyProperties(orderRequest, request);
		Map<String,Integer> countMap = new HashMap<String,Integer>();
		if(!StringUtil.isBlank(request.getUserId())){
			//待支付
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_PAY);
			int waitPayCount = ordOrderAtomSV.findOrderCount(orderRequest);
			countMap.put(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_PAY, waitPayCount);
			
			
			//待报价
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OFFER);
			int waitofferCount = ordOrderAtomSV.findOrderCount(orderRequest);
			countMap.put(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OFFER, waitofferCount);
			
			//翻译中
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_TRASLATING);
			int translatingCount = ordOrderAtomSV.findOrderCount(orderRequest);
			countMap.put(OrdersConstants.OrderDisplayFlag.FLAG_TRASLATING, translatingCount);
			
			//待确认
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OK);
			int waitOkCount = ordOrderAtomSV.findOrderCount(orderRequest);
			countMap.put(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OK, waitOkCount);
			
			//待评价
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_COMMENT);
			int waitCommentCount = ordOrderAtomSV.findOrderCount(orderRequest);
			countMap.put(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_COMMENT, waitCommentCount);
			
		}else if(!StringUtil.isBlank(request.getInterperId())||!StringUtil.isBlank(request.getInterperId())){
			//待支付
			orderRequest.setState(OrdersConstants.OrderState.STATE_RECEIVED);
			int receivedCount = ordOrderAtomSV.findOrderCount(orderRequest);
			countMap.put(OrdersConstants.OrderState.STATE_RECEIVED, receivedCount);
			
			//翻译中
			orderRequest.setState(OrdersConstants.OrderState.STATE_TRASLATING);
			int translatingCount = ordOrderAtomSV.findOrderCount(orderRequest);
			countMap.put(OrdersConstants.OrderState.STATE_TRASLATING, translatingCount);
		}
		
		return countMap;
	}
	
	
	
	@Override
	@Transactional
	public OrderStateUpdateResponse updateState(OrderStateUpdateRequest request) {
		OrderStateUpdateResponse response = new OrderStateUpdateResponse();
		//
		OrdOrder ordOrderDb = this.ordOrderAtomSV.findByPrimaryKey(request.getOrderId());
		if (null == ordOrderDb) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "此订单信息不存在");
		}
		//
		OrdOrder ordOrder = new OrdOrder();
		ordOrder.setOrderId(request.getOrderId());
		ordOrder.setState(request.getState());
		ordOrder.setStateChgTime(DateUtil.getSysDate());
		//
		if(StringUtil.isBlank(request.getDisplayFlag())){
			ordOrder.setDisplayFlag(request.getDisplayFlag());
			ordOrder.setDisplayFlagChgTime(DateUtil.getSysDate());
		}
		//
		this.ordOrderAtomSV.updateByPrimaryKeySelective(ordOrder);
		//
		String userId = ordOrderDb.getUserId();
		Long orderId = request.getOrderId();
		String translateType = ordOrderDb.getTranslateType();//数据库获取订单翻译类型
		String oldState = ordOrderDb.getState();//数据库获取订单当前状态
		String newState = request.getState();//新状态为 待领取
		//
		this.orderStateChgInfoSubmit(userId, orderId, translateType, oldState, newState);
		//
		response.setOrderId(request.getOrderId());
		//
		return response;
	}
	/**
	 * 订单提交-订单轨迹表
	 */
	public void orderStateChgInfoSubmit(String userId,Long orderId,String translateType,String oldState,String newState){
		OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
		//
		Long stateChgId = SequenceUtil.createStateChgId();
		//
		ordOdStateChg.setStateChgId(stateChgId);
		ordOdStateChg.setOrderId(orderId);
		ordOdStateChg.setOperId(userId);
		ordOdStateChg.setOrgState(oldState);
		ordOdStateChg.setNewState(newState);
		ordOdStateChg.setStateChgTime(DateUtil.getSysDate());
		this.ordOdStateChgAtomSV.insertSelective(ordOdStateChg);
	}

}
