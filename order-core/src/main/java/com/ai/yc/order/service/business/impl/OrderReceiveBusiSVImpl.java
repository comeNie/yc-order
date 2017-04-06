package com.ai.yc.order.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.order.api.orderreceive.param.OrderAlloReceiveRequest;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveRequest;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveResponse;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.constants.OrdersConstants.OrderState;
import com.ai.yc.order.dao.mapper.bo.OrdOdReceive;
import com.ai.yc.order.dao.mapper.bo.OrdOdReceiveFollow;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdReceiveAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdReceiveFollowAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdOdStateChgBusiSV;
import com.ai.yc.order.service.business.interfaces.IOrderReceiveBusiSV;
import com.ai.yc.order.util.SequenceUtil;

@Service
public class OrderReceiveBusiSVImpl implements IOrderReceiveBusiSV {

	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Autowired
	private IOrdOdFeeTotalAtomSV ordOdFeeTotalAtomSV;
	@Autowired
	private IOrdOdStateChgBusiSV ordOdStateChgBusiSV;
	@Autowired
	private IOrdOdReceiveAtomSV ordOdReceiveAtomSV;

	@Autowired
	private IOrdOdReceiveFollowAtomSV ordOdReceiveFollowAtomSV;

	@Override
	@Transactional
	public OrderReceiveResponse updateOrderReceive(OrderReceiveRequest request) {
		// TODO Auto-generated method stub
		OrderReceiveResponse response = new OrderReceiveResponse();
		//
		OrdOrder ordOrderDb = this.ordOrderAtomSV.findByPrimaryKey(request.getBaseInfo().getOrderId());
		if (null == ordOrderDb) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "此订单信息不存在");
		}

		OrdOrder ordOrder = new OrdOrder();
		BeanUtils.copyVO(ordOrder, request.getBaseInfo());
		//
		this.ordOrderAtomSV.updateByPrimaryKeySelective(ordOrder);
		// 二期开发 跟平台佣金相关 保留 zhangzd
		// OrdOdFeeTotal ordOdFeeTotal = new OrdOdFeeTotal();
		// BeanUtils.copyVO(ordOdFeeTotal, request.getFeeInfo());
		// this.ordOdFeeTotalAtomSV.updateByOrderIdSelective(request.getBaseInfo().getOrderId(),ordOdFeeTotal
		// );
		//
		this.ordOdStateChgBusiSV.orderReceiveChgDesc(request, request.getBaseInfo().getInterperId(),
				request.getBaseInfo().getInterperType(), request.getBaseInfo().getLspId(), ordOrderDb.getState());
		//
		response.setOrderId(request.getBaseInfo().getOrderId());
		return response;
	}

	@Override
	public OrderReceiveResponse updateOrderAlloReceive(OrderAlloReceiveRequest request) {
		OrderReceiveResponse response = new OrderReceiveResponse();
		//
		OrdOrder ordOrderDb = this.ordOrderAtomSV.findByPrimaryKey(request.getOrderId());
		if (null == ordOrderDb) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "此订单信息不存在");
		}
		// 1、修改任务跟踪信息
		OrdOdReceiveFollow ordOrderDbFollow = ordOdReceiveFollowAtomSV.findByOrderAndState(request.getOrderId(), OrdersConstants.RECEIVE_STATE);
		if(null==ordOrderDbFollow){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "未领取任务跟踪信息不存在");
		}
		BeanUtils.copyVO(ordOrderDbFollow, request);
		ordOrderDbFollow.setReceiveState(OrdersConstants.RECEIVE_ALREADY_STATE);
		ordOrderDbFollow.setFinishState(OrdersConstants.FINISH_STATE);
		ordOdReceiveFollowAtomSV.updateSelective(ordOrderDbFollow);
		OrdOdReceive ordOrderTask = new OrdOdReceive();
		// 2、领取任务信息入库
		long Id = SequenceUtil.createOrdReceiveId();
		BeanUtils.copyVO(ordOrderTask, request);
		ordOrderTask.setId(Id);
		ordOrderTask.setReceiveFollowId(ordOrderDbFollow.getReceiveFollowId());
		ordOrderTask.setReceiveTime(DateUtil.getSysDate());
		this.ordOdReceiveAtomSV.insertByPrimaryKeySelective(ordOrderTask);
		// 3、 修改订单主表状态
		OrdOrder ordOrderUpdate = new OrdOrder();
		ordOrderUpdate.setOrderId(request.getOrderId());
		ordOrderUpdate.setState(OrderState.STATE_RECEIVED);
		ordOrderUpdate.setStateChgTime(DateUtil.getSysDate());
		this.ordOrderAtomSV.updateByPrimaryKeySelective(ordOrderUpdate);
		// 4、添加轨迹信息
		this.ordOdStateChgBusiSV.orderAlloReceiveChgDesc(request, ordOrderDb.getState());
		response.setOrderId(request.getOrderId());
		return response;
	}

}
