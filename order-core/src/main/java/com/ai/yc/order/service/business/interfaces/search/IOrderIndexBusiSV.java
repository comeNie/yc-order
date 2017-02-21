package com.ai.yc.order.service.business.interfaces.search;

import java.util.List;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.search.bo.OrderInfo;

public interface IOrderIndexBusiSV {
	 public List<OrderInfo> orderFillQuery(List<OrdOrder> ordList) throws BusinessException, SystemException;
	 //新增订单信息
	 public boolean insertSesData(long orderId) throws BusinessException, SystemException; 
	 

}
