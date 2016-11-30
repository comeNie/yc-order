package com.ai.yc.order.api.orderclose.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.yc.order.api.orderclose.interfaces.IOrderCancelSV;
import com.ai.yc.order.api.orderclose.param.OrderCancelRequest;
import com.ai.yc.order.api.sesdata.interfaces.ISesDataUpdateSV;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrderCancelBusiSV;
import com.ai.yc.order.util.ValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class OrderCancelSVImpl implements IOrderCancelSV {
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Autowired
	private IOrderCancelBusiSV orderCancelBusiSV;
	@Autowired
	private ISesDataUpdateSV sesDataUpdateSV;
	
	@Override
	public BaseResponse handCancelNoPayOrder(OrderCancelRequest request) throws BusinessException, SystemException {
		/* 1.参数检验*/
		request.setTenantId(OrdersConstants.TENANT_ID);
		ValidateUtils.validateCancleOrdOrder(request);
		BaseResponse response=new BaseResponse();
		List<OrdOrder> noPayOrders=null;
		List<OrdOrder> noPriceOrders=null;
		 //2.获取未支付的订单
		try {
			noPayOrders = ordOrderAtomSV.findNoPayOrdList(request.getOrderId());
		} catch (Exception e) {
			throw new SystemException(e);
		}
		//3、获取待报价订单
		try {
			noPriceOrders = ordOrderAtomSV.findNoPriceOrdList(request.getOrderId());
		} catch (Exception e) {
			throw new SystemException(e);
		}
		 //4.判断订单是否存在
		if(CollectionUtil.isEmpty(noPayOrders) && CollectionUtil.isEmpty(noPriceOrders)) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, 
					"待取消订单为空[orderId:"+request.getOrderId()+"]");
		}
		OrdOrder ordOrder = new OrdOrder();
		ordOrder.setOrderId(request.getOrderId());
		ordOrder.setOperId(request.getOperId());
		ordOrder.setReasonDesc(request.getReasonDesc());
		if(!CollectionUtil.isEmpty(noPayOrders)){
			ordOrder.setState(noPayOrders.get(0).getState());
		}else if(!CollectionUtil.isEmpty(noPriceOrders)){
			ordOrder.setState(noPriceOrders.get(0).getState());
		}
		 //4.取消订单
		orderCancelBusiSV.orderCancel(ordOrder);
		ResponseHeader header=new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "关闭订单成功");
		response.setResponseHeader(header);
		//刷新数据到搜索引擎
		sesDataUpdateSV.updateSesData(request.getOrderId());
		return response;
	}
	
}
