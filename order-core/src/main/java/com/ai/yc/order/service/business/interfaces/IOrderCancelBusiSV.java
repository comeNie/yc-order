package com.ai.yc.order.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
/**
 * 取消订单
 * Date: 2016年11月7日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public interface IOrderCancelBusiSV {

    public void orderCancel(OrdOrder ordOrder,String operName) throws BusinessException, SystemException;
}
