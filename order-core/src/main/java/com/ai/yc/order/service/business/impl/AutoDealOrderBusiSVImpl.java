package com.ai.yc.order.service.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.constants.ResultCodeConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IAutoDealOrderBusiSV;
import com.ai.yc.order.service.business.interfaces.IOrdOdStateChgBusiSV;

@Transactional
@Service
public class AutoDealOrderBusiSVImpl implements IAutoDealOrderBusiSV {
	
	@Autowired
	private transient IOrdOrderAtomSV iOrdOrderAtomSV;
	
	@Autowired
	private transient IOrdOdStateChgBusiSV iOrdOdStateChgBusiSV;
	
	private final static int _DAY_CANCEL = 3;
	
	private final static int _DAY_CONFIRM = 7;

	@Override
	public BaseResponse autoCancelOrder() {
		List<OrdOrder> ordOrders = iOrdOrderAtomSV.findByState(OrdersConstants.OrderState.STATE_WAIT_PAY);
    	long now = System.currentTimeMillis();
    	for(OrdOrder ordOrder:ordOrders){
    		long start = ordOrder.getStateChgTime()==null?ordOrder.getOrderTime().getTime():ordOrder.getStateChgTime().getTime();
    	    if(now-start >= _DAY_CANCEL*24*60*60*1000l){
    	    	//修改订单状态
    	    	OrdOrder record = new OrdOrder();
    	    	record.setOrderId(ordOrder.getOrderId());
    	    	record.setState(OrdersConstants.OrderState.CANCEL_STATE);
    	    	record.setStateChgTime(DateUtil.getSysDate());
    	    	record.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_CANCEL);
    	    	record.setDisplayFlagChgTime(DateUtil.getSysDate());
    	    	record.setOperId(OrdersConstants.SYS_OPER_ID);
    	    	iOrdOrderAtomSV.updateByPrimaryKeySelective(record);
    	    	//添加订单轨迹
    	    	OrdOdStateChg chg = new OrdOdStateChg();
    	    	chg.setOrderId(ordOrder.getOrderId());
    	    	chg.setOrgState(ordOrder.getState());
    	    	chg.setNewState(OrdersConstants.OrderState.CANCEL_STATE);
    	    	chg.setOrgId(OrdersConstants.OrgID.ORG_ID_SYS);
    	    	chg.setOperId(OrdersConstants.SYS_OPER_ID);
    	    	iOrdOdStateChgBusiSV.addAllCloseChgDesc(chg);
    	    }
    	}
    	BaseResponse resp = new BaseResponse();
    	resp.setResponseHeader(new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "处理成功"));
		return resp;
	}

	@Override
	public BaseResponse autoConfirmOrder() {
		List<OrdOrder> ordOrders = iOrdOrderAtomSV.findByState(OrdersConstants.OrderState.WAIT_OK_STATE);
    	long now = System.currentTimeMillis();
    	for(OrdOrder ordOrder:ordOrders){
    		long start = ordOrder.getStateChgTime().getTime();
    	    if(now-start >= _DAY_CONFIRM*24*60*60*1000l){
    	    	//修改订单状态为待评论
    	    	OrdOrder record = new OrdOrder();
    	    	record.setOrderId(ordOrder.getOrderId());
    	    	record.setState(OrdersConstants.OrderState.WAIT_COMMENT_STATE);
    	    	record.setStateChgTime(DateUtil.getSysDate());
    	    	record.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_COMMENT);
    	    	record.setDisplayFlagChgTime(DateUtil.getSysDate());
    	    	record.setOperId(OrdersConstants.SYS_OPER_ID);
    	    	iOrdOrderAtomSV.updateByPrimaryKeySelective(record);
    	    	//添加订单轨迹
    	    	OrdOdStateChg chg = new OrdOdStateChg();
    	    	chg.setOrderId(ordOrder.getOrderId());
    	    	chg.setOrgState(ordOrder.getState());
    	    	chg.setNewState(OrdersConstants.OrderState.WAIT_COMMENT_STATE);
    	    	iOrdOdStateChgBusiSV.addAllCloseChgDesc(chg);
    	    }
    	}
		BaseResponse resp = new BaseResponse();
    	resp.setResponseHeader(new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "处理成功"));
		return resp;
	}

}
