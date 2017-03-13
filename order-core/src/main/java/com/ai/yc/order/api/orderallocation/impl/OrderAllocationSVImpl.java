package com.ai.yc.order.api.orderallocation.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseListResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.orderallocation.interfaces.IOrderAllocationSV;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationePersonRequest;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationePersones;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationResponse;
import com.ai.yc.order.service.business.interfaces.IOrderAllocationBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class OrderAllocationSVImpl implements IOrderAllocationSV {
	private static Logger logger = LoggerFactory.getLogger(OrderAllocationSVImpl.class);
	@Autowired
	private IOrderAllocationBusiSV orderAllocationBusiSV;
	@Override
	public OrderAllocationResponse orderAllocation(OrderAllocationRequest request)
			throws BusinessException, SystemException {
		OrderAllocationResponse response = new OrderAllocationResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		//
		try{
			response = this.orderAllocationBusiSV.saveOrderAllocation(request);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("订单分配成功");
			response.setResponseHeader(responseHeader);
		}catch(BusinessException | SystemException e){
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			response.setResponseHeader(responseHeader);
		}catch(Exception e){
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("订单分配失败");
			response.setResponseHeader(responseHeader);
		}
		//
		return response;
	}
	@Override
	public BaseListResponse<OrdAllocationePersones> queryAllocationPersonInfoByOrdId(
			OrdAllocationePersonRequest request) throws BusinessException, SystemException {
		if (request == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if(null == request.getOrderId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"订单编号不能为空");
		}
		return orderAllocationBusiSV.queryOrderAllocationPerson(request.getOrderId());
	}

}
