package com.ai.yc.order.service.business.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.order.api.sesdata.interfaces.ISesDataUpdateSV;
import com.ai.yc.order.constants.OrdOdStateChgConstants;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.constants.ResultCodeConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOdProd;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdWithBLOBs;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdStateChgAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IAutoDealOrderBusiSV;
import com.ai.yc.order.service.business.interfaces.IOrdOdStateChgBusiSV;
import com.ai.yc.order.util.DateCycleUtil;
import com.ai.yc.order.util.SequenceUtil;

@Transactional
@Service
public class AutoDealOrderBusiSVImpl implements IAutoDealOrderBusiSV {

	@Autowired
	private IOrdOrderAtomSV iOrdOrderAtomSV;

	@Autowired
	private IOrdOdStateChgBusiSV iOrdOdStateChgBusiSV;

	@Autowired
	private IOrdOdStateChgAtomSV ordOdStateChgAtomSV;
	@Autowired
	private ISesDataUpdateSV sesDataUpdateSV;
	
	@Autowired
	private IOrdOdProdAtomSV ordOdProdAtomSV;

	private final static int _DAY_CANCEL = 3;

	private final static int _DAY_CONFIRM = 7;

	private final static int _MINUTE_REVIEW = 10;
	private static final Logger log = LoggerFactory.getLogger(AutoDealOrderBusiSVImpl.class);

	@Override
	@Transactional
	public List<String> updateAutoCancelOrder() {
		// start 重写未支付订单3天后自动关闭功能 zhangzd 2016-12-12 11:45
		List<OrdOrder> ordOrderList = iOrdOrderAtomSV.findByStateAndStateChgTime(
				OrdersConstants.OrderState.STATE_WAIT_PAY, DateCycleUtil.getTimestamp(DateUtil.getSysDate(), "D", -3));
		//
		log.info("系统需要取消/关闭订单量：" + ordOrderList.size());
		//
		List<String> orderIdList = new ArrayList<String>();
		//
		for (OrdOrder ordOrder : ordOrderList) {
			//
			orderIdList.add(ordOrder.getOrderId().toString());

			// 订单轨迹-
			OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
			//
			ordOdStateChg.setStateChgId(SequenceUtil.createStateChgId());
			ordOdStateChg.setOrderId(ordOrder.getOrderId());
			ordOdStateChg.setOrgState(ordOrder.getState());
			ordOdStateChg.setNewState(OrdersConstants.OrderState.CANCEL_STATE);
			ordOdStateChg.setOperId(OrdersConstants.SYS_OPER_ID);
			ordOdStateChg.setStateChgTime(DateUtil.getSysDate());
			ordOdStateChg.setChgDesc("订单 " + ordOrder.getOrderId() + " 已关闭");
			ordOdStateChg.setChgDescEn("Order " + ordOrder.getOrderId() + " has been closed.");
			//
			ordOdStateChgAtomSV.insertSelective(ordOdStateChg);
			//
			// 修改订单状态为取消/关闭
			OrdOrder record = new OrdOrder();
			record.setOrderId(ordOrder.getOrderId());
			record.setState(OrdersConstants.OrderState.CANCEL_STATE);
			record.setStateChgTime(DateUtil.getSysDate());
			record.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_CANCEL);
			record.setDisplayFlagChgTime(DateUtil.getSysDate());
			record.setOperId(OrdersConstants.SYS_OPER_ID);
			//
			iOrdOrderAtomSV.updateByPrimaryKeySelective(record);

		}
		// end 重写未支付订单3天后自动关闭功能 zhangzd 2016-12-12 11:45
		//
		return orderIdList;

	}

	@Override
	@Transactional
	public List<String> updateAutoConfirmOrder() {
		// start 重写待确认订单7天后自动确认功能 zhangzd 2016-12-12 11:45
		List<OrdOrder> ordOrderList = iOrdOrderAtomSV.findByStateAndStateChgTime(
				OrdersConstants.OrderState.WAIT_OK_STATE, DateCycleUtil.getTimestamp(DateUtil.getSysDate(), "D", -7));
		//
		log.info("系统需要待确认订单量：" + ordOrderList.size());
		//
		List<String> orderIdList = new ArrayList<String>();
		//
		for (OrdOrder ordOrder : ordOrderList) {
			//
			orderIdList.add(ordOrder.getOrderId().toString());

			// 订单轨迹-（系统自动确认了订单）The system automatically confirmed the order.
			OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
			//
			ordOdStateChg.setStateChgId(SequenceUtil.createStateChgId());
			ordOdStateChg.setOrderId(ordOrder.getOrderId());
			ordOdStateChg.setOrgState(ordOrder.getState());
			ordOdStateChg.setNewState(OrdersConstants.OrderState.FLAG_FINISHED);
			ordOdStateChg.setOperId(OrdersConstants.SYS_OPER_ID);
			ordOdStateChg.setStateChgTime(DateUtil.getSysDate());
			ordOdStateChg.setChgDesc("系统自动确认了订单");
			ordOdStateChg.setChgDescEn("The system automatically confirmed the order.");
			ordOdStateChg.setChgDescD("系统自动确认了订单");
			ordOdStateChg.setChgDescUEn("The system automatically confirmed the order.");
			ordOdStateChg.setFlag(OrdOdStateChgConstants.FLAG_USER);
			//
			ordOdStateChgAtomSV.insertSelective(ordOdStateChg);
			//
			// 修改订单状态为完成
			OrdOrder record = new OrdOrder();
			record.setOrderId(ordOrder.getOrderId());
			record.setState(OrdersConstants.OrderState.FLAG_FINISHED);
			record.setStateChgTime(DateUtil.getSysDate());
			record.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_FINISHED);
			record.setDisplayFlagChgTime(DateUtil.getSysDate());
			record.setOperId(OrdersConstants.SYS_OPER_ID);
			//
			iOrdOrderAtomSV.updateByPrimaryKeySelective(record);

		}
		// end 重写待确认订单7天后自动确认功能 zhangzd 2016-12-12 11:45
		//
		return orderIdList;
	}

	@Override
	@Transactional
	public List<String> updateAutoReviewOrder() {
		// start 重写待审核订单10分钟自动审核功能 zhangzd 2016-12-12 11:45
		List<OrdOrder> ordOrderList = iOrdOrderAtomSV.findByStateAndStateChgTime(
				OrdersConstants.OrderState.WAIT_REVIEW_STATE,
				DateCycleUtil.getTimestamp(DateUtil.getSysDate(), "MIN", -10));
		//
		log.info("系统需要待审核订单量：" + ordOrderList.size());
		//
		List<String> orderIdList = new ArrayList<String>();
		//
		for (OrdOrder ordOrder : ordOrderList) {
			//
			orderIdList.add(ordOrder.getOrderId().toString());

			// 订单轨迹-（系统自动审核了订单）The system automatically reviewed the order.
			OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
			//
			ordOdStateChg.setStateChgId(SequenceUtil.createStateChgId());
			ordOdStateChg.setOrderId(ordOrder.getOrderId());
			ordOdStateChg.setOrgState(ordOrder.getState());
			ordOdStateChg.setNewState(OrdersConstants.OrderState.WAIT_OK_STATE);
			ordOdStateChg.setOperId(OrdersConstants.SYS_OPER_ID);
			ordOdStateChg.setStateChgTime(DateUtil.getSysDate());
			ordOdStateChg.setChgDesc("系统自动审核了订单");
			ordOdStateChg.setChgDescEn("The system automatically reviewed the order.");
			ordOdStateChg.setChgDescD("您的订单已翻译完成，请确认翻译结果");
			ordOdStateChg.setChgDescUEn("Your order has been translated, please confirm the translation results");
			ordOdStateChg.setFlag(OrdOdStateChgConstants.FLAG_USER);
			//
			ordOdStateChgAtomSV.insertSelective(ordOdStateChg);
			//
			// 修改订单状态为待确认
			OrdOrder record = new OrdOrder();
			record.setOrderId(ordOrder.getOrderId());
			record.setState(OrdersConstants.OrderState.WAIT_OK_STATE);
			record.setStateChgTime(DateUtil.getSysDate());
			record.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OK);
			record.setDisplayFlagChgTime(DateUtil.getSysDate());
			record.setOperId(OrdersConstants.SYS_OPER_ID);
			//自动审核后 设置七天待确认时间
			record.setEndChgTime( new Timestamp(Long.valueOf(DateCycleUtil.getCycleDate("D", 7).get("endTime").toString())));
			//
			iOrdOrderAtomSV.updateByPrimaryKeySelective(record);
			//系统自动审核完毕，需要修改updateTime字段 zhangzd 20161216
			OrdOdProdWithBLOBs ordOdProdWithBLOBs = new OrdOdProdWithBLOBs();
			ordOdProdWithBLOBs.setUpdateTime(DateUtil.getSysDate());
			this.ordOdProdAtomSV.updateByOrderIdSelective(ordOdProdWithBLOBs, ordOrder.getOrderId());

		}
		// end 重写待审核订单10分钟自动审核功能 zhangzd 2016-12-12 11:45
		//
		return orderIdList;
	}
	
	@Override
	@Transactional
	public List<String> updateAutoWaitSureOrder() {
		// start 口译订单翻译中订单超时待确认 zhangzd 2016-12-28 11:05
		List<OrdOrder> ordOrderList = iOrdOrderAtomSV.findByStateAndTranslateType(OrdersConstants.OrderState.STATE_TRASLATING,OrdersConstants.TranslateType.ORDER_TYPE_ORAL);
		List<Long> orderIds = new ArrayList<Long>();
		for(OrdOrder ordOrder : ordOrderList){
			orderIds.add(ordOrder.getOrderId());
		}
		//
		List<OrdOdProd> ordOdProdList = this.ordOdProdAtomSV.findByOrdersAndEndTime(orderIds, DateUtil.getSysDate());
		//
		log.info("查询出小于当前时间点的口译订单信息：" + ordOdProdList.size());
		//
		List<String> orderIdList = new ArrayList<String>();
		//
		for (OrdOdProd ordOdProd : ordOdProdList) {
			//
			orderIdList.add(ordOdProd.getOrderId().toString());

			// 订单轨迹-（系统自动审核了订单）The system automatically reviewed the order.
			OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
			//
			ordOdStateChg.setStateChgId(SequenceUtil.createStateChgId());
			ordOdStateChg.setOrderId(ordOdProd.getOrderId());
			ordOdStateChg.setOrgState(OrdersConstants.OrderState.STATE_TRASLATING);
			ordOdStateChg.setNewState(OrdersConstants.OrderState.WAIT_OK_STATE);
			ordOdStateChg.setOperId(OrdersConstants.SYS_OPER_ID);
			ordOdStateChg.setStateChgTime(DateUtil.getSysDate());
			ordOdStateChg.setChgDesc("您的订单已翻译完成，请确认翻译结果");
			ordOdStateChg.setChgDescEn("Your order has been translated, please confirm the translation results");
			ordOdStateChg.setChgDescD("您的订单已翻译完成，请确认翻译结果");
			ordOdStateChg.setChgDescUEn("Your order has been translated, please confirm the translation results");
			ordOdStateChg.setFlag(OrdOdStateChgConstants.FLAG_USER);
			//
			ordOdStateChgAtomSV.insertSelective(ordOdStateChg);
			//
			// 修改订单状态为待确认
			OrdOrder record = new OrdOrder();
			record.setOrderId(ordOdProd.getOrderId());
			record.setState(OrdersConstants.OrderState.WAIT_OK_STATE);
			record.setStateChgTime(DateUtil.getSysDate());
			record.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OK);
			record.setDisplayFlagChgTime(DateUtil.getSysDate());
			record.setOperId(OrdersConstants.SYS_OPER_ID);
			// 设置七天待确认时间
			record.setEndChgTime( new Timestamp(Long.valueOf(DateCycleUtil.getCycleDate("D", 7).get("endTime").toString())));
			//
			iOrdOrderAtomSV.updateByPrimaryKeySelective(record);
//			//系统自动审核完毕，需要修改updateTime字段 zhangzd 20161216
//			OrdOdProdWithBLOBs ordOdProdWithBLOBs = new OrdOdProdWithBLOBs();
//			ordOdProdWithBLOBs.setUpdateTime(DateUtil.getSysDate());
//			this.ordOdProdAtomSV.updateByOrderIdSelective(ordOdProdWithBLOBs, ordOrder.getOrderId());

		}
		// end 口译订单翻译中订单超时待确认 zhangzd 2016-12-28 11:05
		//
		return orderIdList;
	}
}
