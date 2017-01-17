package com.ai.yc.order.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.opt.sdk.util.BeanUtils;
import com.ai.yc.order.api.orderfee.param.OrderFeeInfo;
import com.ai.yc.order.api.orderfee.param.OrderFeeProdInfo;
import com.ai.yc.order.api.orderfee.param.OrderFeeQueryRequest;
import com.ai.yc.order.api.orderfee.param.OrderFeeQueryResponse;
import com.ai.yc.order.api.orderfee.param.OrderFeeTranslateLevelInfo;
import com.ai.yc.order.api.orderfee.param.OrderFeeUserInfo;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.yc.order.dao.mapper.bo.OrdOdProd;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdLevel;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdWithBLOBs;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdFileAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdLevelAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdStateChgAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrderFeeQueryBusiSV;
/**
 * 
 * @author zhangzd
 *
 */
@Service
public class OrderFeeQueryBusiSVImpl implements IOrderFeeQueryBusiSV {
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Autowired
	private IOrdOdFeeTotalAtomSV ordOdFeeTotalAtomSV;//订单费用
	@Autowired
	private IOrdOdProdAtomSV ordOdProdAtomSV;//产品信息
	@Autowired
	private IOrdOdProdLevelAtomSV ordOdProdLevelAtomSV;//翻译级别
	@Autowired
	private IOrdOdStateChgAtomSV ordOdStateChgAtomSV;
	
	@Override
	public OrderFeeQueryResponse orderFeeQuery(OrderFeeQueryRequest request) {
		OrderFeeQueryResponse response = new OrderFeeQueryResponse();
		//
		Long orderId = request.getOrderId();
		//产品费用信息
		OrdOdFeeTotal ordOdFeeTotal = this.ordOdFeeTotalAtomSV.findByOrderId(orderId);
		//
		OrderFeeInfo orderFeeInfo = new OrderFeeInfo();
		
		BeanUtils.copyVO(orderFeeInfo, ordOdFeeTotal);
		response.setOrderFeeInfo(orderFeeInfo);
		//产品信息
		OrdOdProdWithBLOBs ordOdProd = this.ordOdProdAtomSV.findByOrderId(orderId);
		//
		OrderFeeProdInfo orderFeeProdInfo = new OrderFeeProdInfo();
		BeanUtils.copyVO(orderFeeProdInfo, ordOdProd);
		orderFeeProdInfo.setProdDetalId(ordOdProd.getProdDetalId());
		orderFeeProdInfo.setTranslateType(ordOdProd.getTranslateType());
		orderFeeProdInfo.setTranslateName(ordOdProd.getTranslateName());
		response.setOrderFeeProdInfo(orderFeeProdInfo);
		//
		List<OrdOdProdLevel> ordOdProdLevelList = this.ordOdProdLevelAtomSV.findByOrderId(orderId);
		//
		List<OrderFeeTranslateLevelInfo> orderFeeTranslateLevelInfoList = new ArrayList<OrderFeeTranslateLevelInfo>();
		OrderFeeTranslateLevelInfo orderFeeTranslateLevelInfo = null;
		for(OrdOdProdLevel ordOdProdLevel : ordOdProdLevelList){
			orderFeeTranslateLevelInfo = new OrderFeeTranslateLevelInfo();
			//
			BeanUtils.copyVO(orderFeeTranslateLevelInfo, ordOdProdLevel);
			orderFeeTranslateLevelInfoList.add(orderFeeTranslateLevelInfo);
		}
		response.setOrderFeeTranslateLevelInfoList(orderFeeTranslateLevelInfoList);
		//查询下单的用户信息
		OrdOdStateChg ordOdStateChg = this.ordOdStateChgAtomSV.findByOrderIdAndOrgState(orderId, OrdersConstants.OrderState.STATE_COMMIT);
		//
		OrderFeeUserInfo userInfo = new OrderFeeUserInfo();
		if(null != ordOdStateChg){
			
			userInfo.setOperId(ordOdStateChg.getOperId());

		}
		response.setUserInfo(userInfo);
		//
		return response;
	}

}
