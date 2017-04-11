package com.ai.yc.order.service.business.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.order.api.orderreview.param.OrderLspReviewRequest;
import com.ai.yc.order.api.orderreview.param.OrderReviewRequest;
import com.ai.yc.order.api.sesdata.interfaces.ISesDataUpdateSV;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdWithBLOBs;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdOdStateChgBusiSV;
import com.ai.yc.order.service.business.interfaces.IOrderReviewBusiSV;
import com.ai.yc.order.util.DateCycleUtil;

@Service
public class OrderReviewBusiSVImpl implements IOrderReviewBusiSV {
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Autowired
	private IOrdOdStateChgBusiSV ordOdStateChgBusiSV;
	@Autowired
	private ISesDataUpdateSV sesDataUpdateSV;
	@Autowired
	private IOrdOdProdAtomSV ordOdProdAtomSV;

	@Override
	public void check(OrderReviewRequest request) {
		List<Long> idList = request.getOrderIdList();
		for(Long id:idList){
			OrdOrder order = ordOrderAtomSV.findByPrimaryKey(id);
			if (order == null) {
				throw new BusinessException(ExceptCodeConstants.Special.NO_RESULT,
						"未能查询到相对应的订单信息[订单id:" + id + "]");
			}
			String orgState = order.getState();
			if (!OrdersConstants.OrderState.WAIT_REVIEW_STATE.equals(orgState)) {
				throw new BusinessException("", id+"此订单不处于待审核状态");
			}
			// 订单状态校验
			String state = request.getState();
			if (!OrdersConstants.OrderState.REVIEW_FAILD_STATE.equals(state)
					&& !OrdersConstants.OrderState.REVIEWED_STATE.equals(state)) {
				throw new BusinessException("", "订单审核结果入参有误");
			}
			if (OrdersConstants.OrderState.REVIEWED_STATE.equals(state)) {// 表示审核通过
				/* 1.写入订单状态变化轨迹表 */
				OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
				ordOdStateChg.setOrderId(order.getOrderId());
				ordOdStateChg.setOperId(request.getOperId());
				ordOdStateChg.setOperName(request.getOperName());
				ordOdStateChg.setOrgState(OrdersConstants.OrderState.WAIT_REVIEW_STATE);
				ordOdStateChg.setNewState(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OK);
				ordOdStateChgBusiSV.checkChgDesc(ordOdStateChg);
				/* 2.更新订单表中状态为“审核通过” */
				Timestamp sysDate = DateUtil.getSysDate();
				order.setState(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OK);
				order.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OK);
				order.setStateChgTime(sysDate);
				order.setDisplayFlagChgTime(sysDate);
				//状态结束时间
				order.setEndChgTime( new Timestamp(Long.valueOf(DateCycleUtil.getCycleDate("D", 7).get("endTime").toString())));
				ordOrderAtomSV.updateById(order);
				/* 3.修改产品表 中update_time zhangzd*/
				OrdOdProdWithBLOBs ordOdProdWithBLOBs = new OrdOdProdWithBLOBs();
				ordOdProdWithBLOBs.setUpdateTime(DateUtil.getSysDate());
				//
				this.ordOdProdAtomSV.updateByOrderIdSelective(ordOdProdWithBLOBs, order.getOrderId());
			} else {
				/* 1.写入订单状态变化轨迹表 */
				OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
				ordOdStateChg.setOrderId(order.getOrderId());
				ordOdStateChg.setOrgId(OrdersConstants.OrgID.ORG_ID_USER);
				ordOdStateChg.setOperId(request.getOperId());
				ordOdStateChg.setOperName(request.getOperName());
				ordOdStateChg.setOrgState(OrdersConstants.OrderState.WAIT_REVIEW_STATE);
				ordOdStateChg.setNewState(OrdersConstants.OrderState.STATE_TRASLATING);
				ordOdStateChgBusiSV.checkChgDesc(ordOdStateChg);
				/* 2.回退订单表中状态为“翻译中” */
				Timestamp sysDate = DateUtil.getSysDate();
				order.setState(OrdersConstants.OrderState.STATE_TRASLATING);
				order.setReasonDesc(request.getReasonDesc());
				order.setStateChgTime(sysDate);
				ordOrderAtomSV.updateById(order);
				/* 3.修改产品表 中update_time zhangzd*/
				OrdOdProdWithBLOBs ordOdProdWithBLOBs = new OrdOdProdWithBLOBs();
				ordOdProdWithBLOBs.setUpdateTime(DateUtil.getSysDate());
				//
				this.ordOdProdAtomSV.updateByOrderIdSelective(ordOdProdWithBLOBs, order.getOrderId());
			
			}
			//刷新数据到搜索引擎
			sesDataUpdateSV.updateSesData(id);
		}
	}

	@Override
	public void lspCheck(OrderLspReviewRequest request) {
		OrdOrder order = ordOrderAtomSV.findByPrimaryKey(request.getOrderId());
		if (order == null) {
			throw new BusinessException(ExceptCodeConstants.Special.NO_RESULT,
					"未能查询到相对应的订单信息[订单id:" + request.getOrderId() + "]");
		}
		// 订单状态校验
		String state = request.getState();
		if (!OrdersConstants.OrderState.REVIEW_FAILD_STATE.equals(state)
				&& !OrdersConstants.OrderState.REVIEWED_STATE.equals(state)) {
			throw new BusinessException("", "订单审核结果入参有误");
		}
		if (OrdersConstants.OrderState.REVIEWED_STATE.equals(state)) {// 表示审核通过
			/* 1.写入订单状态变化轨迹表 */
			OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
			ordOdStateChg.setOrderId(order.getOrderId());
			ordOdStateChg.setOperId(request.getOperId());
			ordOdStateChg.setOperName(request.getOperName());
			ordOdStateChg.setOrgState("93");
			ordOdStateChg.setNewState(OrdersConstants.OrderState.WAIT_REVIEW_STATE);
			ordOdStateChgBusiSV.checkChgDesc(ordOdStateChg);
			/* 2.更新订单表中状态为“待译文审核” */
			Timestamp sysDate = DateUtil.getSysDate();
			order.setState(OrdersConstants.OrderState.WAIT_REVIEW_STATE);
			order.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_TRASLATING);
			order.setStateChgTime(sysDate);
			order.setDisplayFlagChgTime(sysDate);
			ordOrderAtomSV.updateById(order);
			/* 3.修改产品表 中update_time zhangzd*/
			OrdOdProdWithBLOBs ordOdProdWithBLOBs = new OrdOdProdWithBLOBs();
			ordOdProdWithBLOBs.setUpdateTime(DateUtil.getSysDate());
			//
			this.ordOdProdAtomSV.updateByOrderIdSelective(ordOdProdWithBLOBs, order.getOrderId());
		} else {
			/* 1.写入订单状态变化轨迹表 */
			OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
			ordOdStateChg.setOrderId(order.getOrderId());
			ordOdStateChg.setOrgId(OrdersConstants.OrgID.ORG_ID_USER);
			ordOdStateChg.setOperId(request.getOperId());
			ordOdStateChg.setOperName(request.getOperName());
			ordOdStateChg.setOrgState("93");
			ordOdStateChg.setNewState(OrdersConstants.OrderState.STATE_TRASLATING);
			ordOdStateChgBusiSV.checkChgDesc(ordOdStateChg);
			/* 2.回退订单表中状态为“翻译中” */
			Timestamp sysDate = DateUtil.getSysDate();
			order.setState(OrdersConstants.OrderState.STATE_TRASLATING);
			order.setReasonDesc(request.getReasonDesc());
			order.setStateChgTime(sysDate);
			ordOrderAtomSV.updateById(order);
			/* 3.修改产品表 中update_time zhangzd*/
			OrdOdProdWithBLOBs ordOdProdWithBLOBs = new OrdOdProdWithBLOBs();
			ordOdProdWithBLOBs.setUpdateTime(DateUtil.getSysDate());
			//
			this.ordOdProdAtomSV.updateByOrderIdSelective(ordOdProdWithBLOBs, order.getOrderId());
		
		}
		//刷新数据到搜索引擎
		sesDataUpdateSV.updateSesData(request.getOrderId());
	}
}
