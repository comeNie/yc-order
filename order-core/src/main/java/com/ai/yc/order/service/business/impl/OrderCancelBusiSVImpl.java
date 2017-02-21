package com.ai.yc.order.service.business.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdOdStateChgBusiSV;
import com.ai.yc.order.service.business.interfaces.IOrderCancelBusiSV;


@Service
@Transactional
public class OrderCancelBusiSVImpl implements IOrderCancelBusiSV {

    @Autowired
    private IOrdOrderAtomSV ordOrderAtomSV;
    @Autowired
    private IOrdOdStateChgBusiSV ordOdStateChgBusiSV;

    @Override
    public void orderCancel(OrdOrder ordOrder,String operName) throws BusinessException, SystemException {
    	/* 2.写入订单状态变化轨迹表 */
        OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
        ordOdStateChg.setOrderId(ordOrder.getOrderId());
        ordOdStateChg.setOperId(ordOrder.getOperId());
        ordOdStateChg.setOperName(operName);
        ordOdStateChg.setOrgState(ordOrder.getState());
        ordOdStateChg.setNewState(OrdersConstants.OrderState.CANCEL_STATE);
        ordOdStateChgBusiSV.addCloseChgDesc(ordOdStateChg);
        
    	/* 1.更新订单表中状态为“取消” */
        Timestamp sysDate = DateUtil.getSysDate();
        ordOrder.setState(OrdersConstants.OrderState.CANCEL_STATE);
        ordOrder.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_CANCEL);
        ordOrder.setStateChgTime(sysDate);
        ordOrder.setDisplayFlagChgTime(sysDate);
        ordOrder.setOperId(ordOrder.getOperId());
        ordOrderAtomSV.updateById(ordOrder);
        
    }
}
