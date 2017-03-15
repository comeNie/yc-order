package com.ai.yc.order.api.orderrefund.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.orderrefund.interfaces.IOrderRefundSV;
import com.ai.yc.order.api.orderrefund.param.OrderRefundCheckRequest;
import com.ai.yc.order.api.orderrefund.param.OrderRefundRequest;
import com.ai.yc.order.api.orderrefund.param.OrderRefundResponse;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdOrderBusiSV;
import com.ai.yc.order.service.business.interfaces.search.IOrderIndexBusiSV;
import com.ai.yc.order.util.ValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class OrderRefundSVImpl implements IOrderRefundSV {
	private static Logger logger = LoggerFactory.getLogger(OrderRefundSVImpl.class);
	@Autowired
	private IOrderIndexBusiSV orderIndexBusiSV;// 订单搜索引擎添加服务

	@Autowired
	private IOrdOrderBusiSV ordOrderBusiSV;
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;

	@Override
	public OrderRefundResponse refund(OrderRefundRequest request) throws BusinessException, SystemException {
		OrderRefundResponse response = new OrderRefundResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			// 有效性校验
			ValidateUtils.validateRefundOrder(request);
			response = this.ordOrderBusiSV.refundOrd(request);
			Long orderId = response.getOrderId();
			logger.info("订单退款申请结果处理返回订单编号：>>>>>>" + orderId);
			this.orderIndexBusiSV.insertSesData(response.getOrderId());

			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("订单退款申请处理成功");
			response.setResponseHeader(responseHeader);

		} catch (BusinessException | SystemException e) {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			response.setResponseHeader(responseHeader);
		} catch (Exception e) {

		}
		return response;
	}

	@Override
	public OrderRefundResponse refundCheck(OrderRefundCheckRequest request) throws BusinessException, SystemException {
		OrderRefundResponse response = new OrderRefundResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			// 有效性校验
			ValidateUtils.validateRefundCheck(request);
			response = this.ordOrderBusiSV.refundCheckOrd(request);
			Long orderId = response.getOrderId();
			logger.info("订单退款审核结果处理返回订单编号：>>>>>>" + orderId);
			this.orderIndexBusiSV.insertSesData(response.getOrderId());

			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("订单退款审核处理成功");
			response.setResponseHeader(responseHeader);

		} catch (BusinessException | SystemException e) {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			response.setResponseHeader(responseHeader);
		} catch (Exception e) {

		}
		return response;
	}

}
