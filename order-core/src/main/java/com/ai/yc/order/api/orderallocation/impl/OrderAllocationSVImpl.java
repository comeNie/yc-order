package com.ai.yc.order.api.orderallocation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.orderallocation.interfaces.IOrderAllocationSV;
import com.ai.yc.order.api.orderallocation.param.OrdAlloInterperFeeInfoResponse;
import com.ai.yc.order.api.orderallocation.param.OrdAlloInterperFeeRequest;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationCountRequest;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationCountResponse;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationResponse;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationSearchRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationSearchResponse;
import com.ai.yc.order.service.business.interfaces.IOrderAllocationBusiSV;
import com.ai.yc.order.util.ValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class OrderAllocationSVImpl implements IOrderAllocationSV {
	@Autowired
	private IOrderAllocationBusiSV orderAllocationBusiSV;
	@Override
	public OrderAllocationResponse orderAllocation(OrderAllocationRequest request)
			throws BusinessException, SystemException {
		OrderAllocationResponse response = new OrderAllocationResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		//
		try{
			//有效性校验
			ValidateUtils.validateAllocateOrder(request);
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
	public OrdAlloInterperFeeInfoResponse queryAlloInterperFee(OrdAlloInterperFeeRequest request)
			throws BusinessException, SystemException {
		if (request == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (null==request.getOrderId()) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单id不能为空");
		}
		return orderAllocationBusiSV.queryAllocationInterperFee(request.getOrderId());
	}
	@Override
	public OrderAllocationSearchResponse pageSearchAlloWaitReceive(OrderAllocationSearchRequest request)
			throws BusinessException, SystemException {
		OrderAllocationSearchResponse response = new OrderAllocationSearchResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			//有效性校验
		
			//response = this.orderWaitReceiveBusiSV.pageSearchWaitReceive(request);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("待领取订单查询成功");
			response.setResponseHeader(responseHeader);
		} catch (BusinessException | SystemException e) {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			response.setResponseHeader(responseHeader);
		} catch (Exception e){
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("待领取订单查询失败");
			response.setResponseHeader(responseHeader);
		}
		return response;
	}
	@Override
	public OrdAllocationCountResponse queryAlloOrderCount(OrdAllocationCountRequest request)
			throws BusinessException, SystemException {
		OrdAllocationCountResponse response = new OrdAllocationCountResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			//有效性校验
		
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("待领取订单数量查询成功");
			response.setResponseHeader(responseHeader);
		} catch (BusinessException | SystemException e) {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			response.setResponseHeader(responseHeader);
		} catch (Exception e){
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("待领取订单数量查询失败");
			response.setResponseHeader(responseHeader);
		}
		return response;
	}

}
