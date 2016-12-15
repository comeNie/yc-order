package com.ai.yc.order.api.orderdetails.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.yc.order.api.orderdetails.interfaces.IQueryOrderDetailsSV;
import com.ai.yc.order.api.orderdetails.param.QueryOrderDetailsRequest;
import com.ai.yc.order.api.orderdetails.param.QueryOrderDetailsResponse;
import com.ai.yc.order.service.business.interfaces.IQueryOrderDetailsBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Description: 订单详情查询
 * @author hougang@asiainfo.com
 * @date 2016年11月5日 上午9:56:13 
 * @version V1.0
 */
@Service
@Component
public class QueryOrderDetailsSVImpl implements IQueryOrderDetailsSV {
	
	@Autowired
	private transient IQueryOrderDetailsBusiSV iQueryOrderDetailsBusiSV;

	@Override
	public QueryOrderDetailsResponse queryOrderDetails(QueryOrderDetailsRequest request)throws BusinessException, SystemException {
		if(null == request){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
		}
		if(null == request.getOrderId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单ID不能为空");
		}
		return iQueryOrderDetailsBusiSV.queryOrderDetails(request.getOrderId(), request.getChgStateFlag());
	}

}
