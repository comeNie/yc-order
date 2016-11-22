package com.ai.yc.order.api.orderdeal.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.yc.order.api.orderdeal.interfaces.IAutoDealOrderSV;
import com.ai.yc.order.service.business.interfaces.IAutoDealOrderBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Description: 自动处理订单服务
 * @author hougang@asiainfo.com
 * @date 2016年11月18日 上午10:05:39 
 * @version V1.0
 */
@Service
public class AutoDealOrderSVImpl implements IAutoDealOrderSV {
	
	@Autowired
	private transient IAutoDealOrderBusiSV iAutoDealOrderBusiSV;

	@Override
	public BaseResponse autoCancelOrder() throws BusinessException,
			SystemException {
		return iAutoDealOrderBusiSV.autoCancelOrder();
	}

	@Override
	public BaseResponse autoConfirmOrder() throws BusinessException,
			SystemException {
		return iAutoDealOrderBusiSV.autoConfirmOrder();
	}

	@Override
	public BaseResponse autoReviewOrder() throws BusinessException,
			SystemException {
		return iAutoDealOrderBusiSV.autoReviewOrder();
	}

}
