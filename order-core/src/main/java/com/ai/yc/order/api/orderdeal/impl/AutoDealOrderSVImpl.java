package com.ai.yc.order.api.orderdeal.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.orderdeal.interfaces.IAutoDealOrderSV;
import com.ai.yc.order.api.sesdata.interfaces.ISesDataUpdateSV;
import com.ai.yc.order.service.business.interfaces.IAutoDealOrderBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Description: 自动处理订单服务
 * @author hougang@asiainfo.com
 * @date 2016年11月18日 上午10:05:39
 * @version V1.0
 */
@Service
@Component
public class AutoDealOrderSVImpl implements IAutoDealOrderSV {

	@Autowired
	private transient IAutoDealOrderBusiSV iAutoDealOrderBusiSV;
	@Autowired
	private ISesDataUpdateSV sesDataUpdateSV;

	@Override
	public BaseResponse autoCancelOrder() throws BusinessException, SystemException {
		BaseResponse response = new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			List<String> orderIdList = iAutoDealOrderBusiSV.updateAutoCancelOrder();
			// 刷新数据到搜索引擎
			for (String orderId : orderIdList) {
				sesDataUpdateSV.updateSesData(Long.valueOf(orderId));
			}
			//
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("待支付订单自动关闭完毕");
			//
			response.setResponseHeader(responseHeader);
		} catch (BusinessException | SystemException e) {
			//
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			//
			response.setResponseHeader(responseHeader);
		} catch (Exception e) {
			//
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("待支付订单自动关闭失败");
			//
			response.setResponseHeader(responseHeader);
		}
		//
		return response;
	}

	@Override
	public BaseResponse autoConfirmOrder() throws BusinessException, SystemException {
		BaseResponse response = new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			List<String> orderIdList = iAutoDealOrderBusiSV.updateAutoConfirmOrder();
			// 刷新数据到搜索引擎
			for (String orderId : orderIdList) {
				sesDataUpdateSV.updateSesData(Long.valueOf(orderId));
			}
			//
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("待确认订单七天后自动确认完毕");
			//
			response.setResponseHeader(responseHeader);
		} catch (BusinessException | SystemException e) {
			//
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			//
			response.setResponseHeader(responseHeader);
		} catch (Exception e) {
			//
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("待确认订单七天后自动确认失败");
			//
			response.setResponseHeader(responseHeader);
		}
		//
		return response;
	}

	@Override
	public BaseResponse autoReviewOrder() throws BusinessException, SystemException {
		BaseResponse response = new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			List<String> orderIdList = iAutoDealOrderBusiSV.updateAutoReviewOrder();
			// 刷新数据到搜索引擎
			for (String orderId : orderIdList) {
				sesDataUpdateSV.updateSesData(Long.valueOf(orderId));
			}
			//
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("待审核订单自动审核完毕");
			//
			response.setResponseHeader(responseHeader);
		} catch (BusinessException | SystemException e) {
			//
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			//
			response.setResponseHeader(responseHeader);
		} catch (Exception e) {
			//
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("待审核订单自动审核失败");
			//
			response.setResponseHeader(responseHeader);
		}
		//
		return response;
	}

	@Override
	public BaseResponse autoWaitSureOrder() throws BusinessException, SystemException {
		BaseResponse response = new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			List<String> orderIdList = iAutoDealOrderBusiSV.updateAutoWaitSureOrder();
			// 刷新数据到搜索引擎
			for (String orderId : orderIdList) {
				sesDataUpdateSV.updateSesData(Long.valueOf(orderId));
			}
			//
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("口译订单翻译中超时待确认完毕");
			//
			response.setResponseHeader(responseHeader);
		} catch (BusinessException | SystemException e) {
			//
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			//
			response.setResponseHeader(responseHeader);
		} catch (Exception e) {
			//
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("口译订单翻译中超时待确认失败");
			//
			response.setResponseHeader(responseHeader);
		}
		//
		return response;
	}

}
