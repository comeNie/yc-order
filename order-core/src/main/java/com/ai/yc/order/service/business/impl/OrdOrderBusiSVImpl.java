package com.ai.yc.order.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.yc.order.api.orderquery.param.OrderCountVo;
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
	public List<OrderCountVo> findOrderCount(QueryOrdCountRequest request) {
		OrdOrder orderRequest = new OrdOrder();
		BeanUtils.copyProperties(orderRequest, request);
		List<OrderCountVo> countVos = new ArrayList<OrderCountVo>();
		if(!StringUtil.isBlank(request.getUserId())){
			//待支付
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_PAY);
			OrderCountVo waitPayCountVo = new OrderCountVo();
			int waitPayCount = ordOrderAtomSV.findOrderCount(orderRequest);
			waitPayCountVo.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_PAY);
			waitPayCountVo.setOrderNum(waitPayCount);
			countVos.add(waitPayCountVo);
			
			//待报价
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OFFER);
			OrderCountVo waitOfferCountVo = new OrderCountVo();
			int waitofferCount = ordOrderAtomSV.findOrderCount(orderRequest);
			waitOfferCountVo.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OFFER);
			waitOfferCountVo.setOrderNum(waitofferCount);
			countVos.add(waitOfferCountVo);
			
			//翻译中
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_TRASLATING);
			OrderCountVo translatingCountVo = new OrderCountVo();
			int translatingCount = ordOrderAtomSV.findOrderCount(orderRequest);
			translatingCountVo.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_TRASLATING);
			translatingCountVo.setOrderNum(translatingCount);
			countVos.add(translatingCountVo);
			
			//待确认
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OK);
			OrderCountVo waitOkCountVo = new OrderCountVo();
			int waitOkCount = ordOrderAtomSV.findOrderCount(orderRequest);
			waitOkCountVo.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OK);
			waitOkCountVo.setOrderNum(waitOkCount);
			countVos.add(waitOkCountVo);
			
			//待评价
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_COMMENT);
			OrderCountVo waitCommentCountVo = new OrderCountVo();
			int waitCommentCount = ordOrderAtomSV.findOrderCount(orderRequest);
			waitCommentCountVo.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_COMMENT);
			waitCommentCountVo.setOrderNum(waitCommentCount);
			countVos.add(waitCommentCountVo);
			
		}else if(!StringUtil.isBlank(request.getInterperId())||!StringUtil.isBlank(request.getInterperId())){
			//待支付
			orderRequest.setState(OrdersConstants.OrderState.STATE_RECEIVED);
			OrderCountVo receivedCountVo = new OrderCountVo();
			int receivedCount = ordOrderAtomSV.findOrderCount(orderRequest);
			receivedCountVo.setState(OrdersConstants.OrderState.STATE_RECEIVED);
			receivedCountVo.setOrderNum(receivedCount);
			countVos.add(receivedCountVo);
			
			//翻译中
			orderRequest.setState(OrdersConstants.OrderState.STATE_TRASLATING);
			OrderCountVo translatingCountVo = new OrderCountVo();
			int translatingCount = ordOrderAtomSV.findOrderCount(orderRequest);
			translatingCountVo.setState(OrdersConstants.OrderState.STATE_TRASLATING);
			translatingCountVo.setOrderNum(translatingCount);
			countVos.add(translatingCountVo);
		}
		
		return countVos;
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
