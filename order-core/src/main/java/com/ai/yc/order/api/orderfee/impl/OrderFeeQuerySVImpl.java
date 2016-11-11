package com.ai.yc.order.api.orderfee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.orderfee.interfaces.IOrderFeeQuerySV;
import com.ai.yc.order.api.orderfee.param.OrderFeeQueryRequest;
import com.ai.yc.order.api.orderfee.param.OrderFeeQueryResponse;
import com.ai.yc.order.service.business.interfaces.IOrderFeeQueryBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class OrderFeeQuerySVImpl implements IOrderFeeQuerySV {
	@Autowired
	private IOrderFeeQueryBusiSV orderFeeQueryBusiSV;

	@Override
	public OrderFeeQueryResponse orderFeeQuery(OrderFeeQueryRequest request) throws BusinessException, SystemException {
		//
		OrderFeeQueryResponse response = new OrderFeeQueryResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		//
		try {
			if (null == request) {
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
			}
			if (null == request.getOrderId()) {
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单编号不能为空");
			}
			//
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode("000000");
			responseHeader.setResultMessage("订单费用查询成功");
			response.setResponseHeader(responseHeader);
			response = this.orderFeeQueryBusiSV.orderFeeQuery(request);
		} catch (BusinessException | SystemException e) {
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			response.setResponseHeader(responseHeader);
		} catch (Exception e){
			responseHeader.setResultCode(ExceptCodeConstants.Special.NO_DATA_OR_CACAE_ERROR);
			responseHeader.setResultMessage("未查询到相关数据");
			response.setResponseHeader(responseHeader);
		}
		return response;
	}

}
