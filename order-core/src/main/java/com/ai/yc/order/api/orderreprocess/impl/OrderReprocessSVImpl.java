package com.ai.yc.order.api.orderreprocess.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.orderreprocess.interfaces.IOrderReprocessSV;
import com.ai.yc.order.api.orderreprocess.param.OrderReprocessRequest;
import com.ai.yc.order.api.orderreprocess.param.OrderReprocessResponse;
import com.ai.yc.order.api.sesdata.interfaces.ISesDataUpdateSV;
import com.ai.yc.order.service.business.interfaces.IOrdOrderBusiSV;
import com.ai.yc.order.util.ValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class OrderReprocessSVImpl implements IOrderReprocessSV {
	@Autowired
	private IOrdOrderBusiSV ordOrderBusiSV;
	@Autowired
	private ISesDataUpdateSV sesDataUpdateSV;
	@Override
	public OrderReprocessResponse orderReprocess(OrderReprocessRequest request)
			throws BusinessException, SystemException {
		//有效性校验
		ValidateUtils.validateOrdReprocess(request);
		OrderReprocessResponse response = new OrderReprocessResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		response.setOrderId(request.getBaseInfo().getOrderId());
		//
		try {
			this.ordOrderBusiSV.reprocessOrder(request);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("订单返工成功");
			response.setResponseHeader(responseHeader);
			//刷新数据到搜索引擎
			sesDataUpdateSV.updateSesData(request.getBaseInfo().getOrderId());
		} catch (Exception e) {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("订单返工失败");
			response.setResponseHeader(responseHeader);
		}
		return response;
	}

}
