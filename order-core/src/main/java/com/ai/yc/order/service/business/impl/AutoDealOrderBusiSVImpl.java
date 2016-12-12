package com.ai.yc.order.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.order.api.sesdata.interfaces.ISesDataUpdateSV;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.constants.ResultCodeConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOdStateChgAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IAutoDealOrderBusiSV;
import com.ai.yc.order.service.business.interfaces.IOrdOdStateChgBusiSV;
import com.ai.yc.order.util.DateCycleUtil;
import com.ai.yc.order.util.SequenceUtil;

@Transactional
@Service
public class AutoDealOrderBusiSVImpl implements IAutoDealOrderBusiSV {
	
	@Autowired
	private IOrdOrderAtomSV iOrdOrderAtomSV;
	
	@Autowired
	private IOrdOdStateChgBusiSV iOrdOdStateChgBusiSV;
	
	@Autowired
	private IOrdOdStateChgAtomSV ordOdStateChgAtomSV;
	@Autowired
	private ISesDataUpdateSV sesDataUpdateSV;
	
	private final static int _DAY_CANCEL = 3;
	
	private final static int _DAY_CONFIRM = 7;
	
	private final static int _MINUTE_REVIEW = 10;
	private static final Logger log = LoggerFactory.getLogger(AutoDealOrderBusiSVImpl.class);
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
    	    	int count = iOrdOrderAtomSV.updateByPrimaryKeySelective(record);
    	    	if(count>0){
    	    		//刷新数据到搜索引擎
    				sesDataUpdateSV.updateSesData(ordOrder.getOrderId());
    	    	}
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
	@Transactional
	public List<String> updateAutoConfirmOrder() {
		//start 重写待确认订单7天后自动确认功能 zhangzd 2016-12-12 11:45
		List<OrdOrder> ordOrderList = iOrdOrderAtomSV.findByStateAndStateChgTime(OrdersConstants.OrderState.WAIT_OK_STATE, DateCycleUtil.getTimestamp(DateUtil.getSysDate(), "D", -7));
		//
		log.info("系统需要待确认订单量："+ordOrderList.size());
		//
		List<String> orderIdList = new ArrayList<String>();
		//
		for(OrdOrder ordOrder : ordOrderList){
			//
			orderIdList.add(ordOrder.getOrderId().toString());
			
			//订单轨迹-（系统自动确认了订单）The system automatically confirmed the order.
	    	OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
	    	//
	    	ordOdStateChg.setStateChgId(SequenceUtil.createStateChgId());
	    	ordOdStateChg.setOrderId(ordOrder.getOrderId());
	    	ordOdStateChg.setOrgState(ordOrder.getState());
	    	ordOdStateChg.setNewState(OrdersConstants.OrderState.FLAG_FINISHED);
	    	ordOdStateChg.setOperId(OrdersConstants.SYS_OPER_ID);
	    	ordOdStateChg.setStateChgTime(DateUtil.getSysDate());
	    	ordOdStateChg.setChgDesc("系统自动确认了订单");
	    	ordOdStateChg.setChgDescEn("The system automatically confirmed the order.");
	    	//
	    	ordOdStateChgAtomSV.insertSelective(ordOdStateChg);
	    	//
	    	//修改订单状态为完成 
	    	OrdOrder record = new OrdOrder();
	    	record.setOrderId(ordOrder.getOrderId());
	    	record.setState(OrdersConstants.OrderState.FLAG_FINISHED);
	    	record.setStateChgTime(DateUtil.getSysDate());
	    	record.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_FINISHED);
	    	record.setDisplayFlagChgTime(DateUtil.getSysDate());
	    	record.setOperId(OrdersConstants.SYS_OPER_ID);
	    	//
	    	iOrdOrderAtomSV.updateByPrimaryKeySelective(record);
	    	
		}
		//end   重写待确认订单7天后自动确认功能 zhangzd 2016-12-12 11:45
		//
		return orderIdList;
	}

	@Override
	public BaseResponse autoReviewOrder() {
		List<OrdOrder> ordOrders = iOrdOrderAtomSV.findByState(OrdersConstants.OrderState.WAIT_REVIEW_STATE);
    	long now = System.currentTimeMillis();
    	for(OrdOrder ordOrder:ordOrders){
    		long start = ordOrder.getStateChgTime().getTime();
    	    if(now-start >= _MINUTE_REVIEW*60*1000l){
    	    	//修改订单状态为待确认
    	    	OrdOrder record = new OrdOrder();
    	    	record.setOrderId(ordOrder.getOrderId());
    	    	record.setState(OrdersConstants.OrderState.WAIT_OK_STATE);
    	    	record.setStateChgTime(DateUtil.getSysDate());
    	    	record.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OK);
    	    	record.setDisplayFlagChgTime(DateUtil.getSysDate());
    	    	record.setOperId(OrdersConstants.SYS_OPER_ID);
    	    	int count = iOrdOrderAtomSV.updateByPrimaryKeySelective(record);
    	    	if(count>0){
    	    		//刷新数据到搜索引擎
    				sesDataUpdateSV.updateSesData(ordOrder.getOrderId());
    	    	}
    	    	//添加订单轨迹
    	    	OrdOdStateChg chg = new OrdOdStateChg();
    	    	chg.setOrgId(OrdersConstants.OrgID.ORG_ID_SYS);
    	    	chg.setOrderId(ordOrder.getOrderId());
    	    	chg.setOrgState(ordOrder.getState());
    	    	chg.setNewState(OrdersConstants.OrderState.WAIT_OK_STATE);
    	    	chg.setOperId(OrdersConstants.SYS_OPER_ID);
    	    	iOrdOdStateChgBusiSV.checkChgDesc(chg);
    	    }
    	}
		BaseResponse resp = new BaseResponse();
    	resp.setResponseHeader(new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "处理成功"));
		return resp;
	}

}
