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
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.yc.order.api.orderallocation.interfaces.IOrderAllocationSV;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationePersonRequest;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationInfo;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationResponse;
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
	public BaseListResponse<OrdAllocationInfo> queryAllocationInfo(
			OrdAllocationePersonRequest request) throws BusinessException, SystemException {
		if (request == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtil.isBlank(request.getInterperId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "议员id不能为空");
		}
		return orderAllocationBusiSV.queryOrderAllocationPerson(request);
	}

}
