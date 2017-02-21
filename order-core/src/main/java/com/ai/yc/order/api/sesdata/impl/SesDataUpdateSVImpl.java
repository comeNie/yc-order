package com.ai.yc.order.api.sesdata.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.yc.order.api.sesdata.interfaces.ISesDataUpdateSV;
import com.ai.yc.order.service.business.interfaces.search.IOrderIndexBusiSV;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class SesDataUpdateSVImpl implements ISesDataUpdateSV {
	@Autowired
	IOrderIndexBusiSV orderIndexBusiSV;
	@Override
	public BaseResponse updateSesData(Long orderId) throws BusinessException, SystemException {
		BaseResponse baseResponse = new BaseResponse();
		ResponseHeader responseHeader = null;
		//有效性校验
		if(orderId==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单id不能为空");
		}
		boolean flag = orderIndexBusiSV.insertSesData(orderId);
		if(flag){
			 responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "数据刷新成功");
		}else{
			 responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "数据刷新失败");
		}
		baseResponse.setResponseHeader(responseHeader);
		return baseResponse;
	}

}
