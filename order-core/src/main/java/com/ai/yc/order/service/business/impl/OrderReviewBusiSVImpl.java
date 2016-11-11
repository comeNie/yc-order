package com.ai.yc.order.service.business.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.order.api.orderreview.param.OrderReviewRequest;
import com.ai.yc.order.api.sesdata.interfaces.ISesDataUpdateSV;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdOdStateChgBusiSV;
import com.ai.yc.order.service.business.interfaces.IOrderReviewBusiSV;

@Service
public class OrderReviewBusiSVImpl implements IOrderReviewBusiSV {
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Autowired
	private IOrdOdStateChgBusiSV ordOdStateChgBusiSV;
	@Autowired
	private ISesDataUpdateSV sesDataUpdateSV;

	@Override
	public void check(OrderReviewRequest request) {
		OrdOrder order = ordOrderAtomSV.findByPrimaryKey(request.getOrderId());
		if (order == null) {
			throw new BusinessException(ExceptCodeConstants.Special.NO_RESULT,
					"未能查询到相对应的订单信息[订单id:" + request.getOrderId() + "]");
		}
		String state = request.getState();
		// 订单状态校验
		if (!OrdersConstants.OrderState.REVIEW_FAILD_STATE.equals(state)
				&& !OrdersConstants.OrderState.REVIEWED_STATE.equals(state)) {
			throw new BusinessException("", "订单审核结果入参有误");
		}
		String orgState = order.getState();
		if (!OrdersConstants.OrderState.WAIT_REVIEW_STATE.equals(orgState)) {
			throw new BusinessException("", "此订单不处于待审核状态");
		}
		if (OrdersConstants.OrderState.REVIEWED_STATE.equals(state)) {// 表示审核通过
			/* 1.更新订单表中状态为“审核通过” */
			Timestamp sysDate = DateUtil.getSysDate();

			order.setState(request.getState());
			order.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OK);
			order.setStateChgTime(sysDate);
			order.setDisplayFlagChgTime(sysDate);
			ordOrderAtomSV.updateById(order);
			/* 2.写入订单状态变化轨迹表 */
			OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
			ordOdStateChg.setOrderId(order.getOrderId());
			ordOdStateChg.setOperId(request.getOperId());
			ordOdStateChg.setOrgState(OrdersConstants.OrderState.WAIT_REVIEW_STATE);
			ordOdStateChg.setNewState(request.getState());
			ordOdStateChgBusiSV.checkChgDesc(ordOdStateChg);
		} else {
			/* 1.更新订单表中状态为“审核失败” */
			Timestamp sysDate = DateUtil.getSysDate();
			order.setState(request.getState());
			order.setStateChgTime(sysDate);
			ordOrderAtomSV.updateById(order);
			/* 2.写入订单状态变化轨迹表 */
			OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
			ordOdStateChg.setOrderId(order.getOrderId());
			ordOdStateChg.setOperId(request.getOperId());
			ordOdStateChg.setOrgState(OrdersConstants.OrderState.WAIT_REVIEW_STATE);
			ordOdStateChg.setNewState(request.getState());
			ordOdStateChgBusiSV.checkChgDesc(ordOdStateChg);
		}
		//刷新数据到搜索引擎
		sesDataUpdateSV.updateSesData(request.getOrderId());
	}

}
