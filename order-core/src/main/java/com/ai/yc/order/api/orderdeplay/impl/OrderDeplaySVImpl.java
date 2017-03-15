package com.ai.yc.order.api.orderdeplay.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.orderdeplay.interfaces.IOrderDeplaySV;
import com.ai.yc.order.api.orderdeplay.param.OrderDeplayRequest;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.service.business.interfaces.IOrdOrderBusiSV;
import com.ai.yc.order.util.ValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class OrderDeplaySVImpl implements IOrderDeplaySV {
	@Autowired
	private IOrdOrderBusiSV ordOrderBusiSV;

	@Override
	public BaseResponse orderDeplay(OrderDeplayRequest request) throws BusinessException, SystemException {
		/* 1.参数检验 */
		request.setTenantId(OrdersConstants.TENANT_ID);
		ValidateUtils.validateOrdDeplay(request);
		BaseResponse response = new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		//
		try {
			this.ordOrderBusiSV.deplayOrder(request);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("订单延时成功");
			response.setResponseHeader(responseHeader);
		} catch (Exception e) {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("订单延时失败");
			response.setResponseHeader(responseHeader);
		}
		return response;
	}

}
