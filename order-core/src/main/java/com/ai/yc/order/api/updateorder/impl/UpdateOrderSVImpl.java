package com.ai.yc.order.api.updateorder.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.updateorder.interfaces.IUpdateOrderSV;
import com.ai.yc.order.api.updateorder.param.UpdateOrderRequest;
import com.ai.yc.order.api.updateorder.param.UpdateOrderResponse;
import com.ai.yc.order.service.business.interfaces.IUpdateOrderBusiSV;
import com.ai.yc.order.validate.UpdateOrderValidate;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Description: 订单信息修改
 * @author hougang@asiainfo.com
 * @date 2016年11月7日 下午5:04:01 
 * @version V1.0
 */
@Service
@Component
public class UpdateOrderSVImpl implements IUpdateOrderSV {
	
	@Autowired
	private IUpdateOrderBusiSV iUpdateOrderBusiSV;
	
	@Autowired
	private UpdateOrderValidate updateOrderValidate;

	@Override
	public UpdateOrderResponse updateOrderInfo(UpdateOrderRequest req)
			throws BusinessException, SystemException {
		updateOrderValidate.validate(req);
		return iUpdateOrderBusiSV.updateOrderInfo(req);
	}

}
