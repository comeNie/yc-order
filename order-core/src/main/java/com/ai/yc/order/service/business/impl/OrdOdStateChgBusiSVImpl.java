package com.ai.yc.order.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.orderreceive.param.OrderReceiveRequest;
import com.ai.yc.order.constants.OrdOdStateChgConstants;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.service.atom.interfaces.IOrdOdStateChgAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdOdStateChgBusiSV;
import com.ai.yc.order.util.SequenceUtil;

@Service
public class OrdOdStateChgBusiSVImpl implements IOrdOdStateChgBusiSV {

	/*
	 * 支付处理信息
	 */
	private final static String PAY_CHG_USER_DESC_CN = "客户支付了订单。";

	private final static String PAY_CHG_USER_DESC_EN = "Client pay the order.";

	private final static String PAY_CHG_ADMIN_DESC_CN = "订单已支付成功，进入任务中心等待译员领取。";

	private final static String PAY_CHG_ADMIN_DESC_EN = "Your order has been paid and released to the task center.  A translator will be assigned to deal with the task.";

	private final static String UPDATE_CHG_ADMIN_DESC_CN = "管理员%s修改了订单。";

	private final static String UPDATE_CHG_ADMIN_DESC_EN = "Administrator %s revised the order.";

	private final static String OFFER_CHG_ADMIN_DESC_CN = "订单已报价，等待您支付。";

	private final static String OFFER_CHG_ADMIN_DESC_EN = "Your order has been quoted, please finish the payment.";

	private final static String CLOSE_CHG_ADMIN_DESC_CN = "客户关闭了订单。";

	private final static String CLOSE_CHG_ADMIN_DESC_EN = "Client closed the order.";
	
	private final static String CLOSE_CHG_DESC_CN = "订单 %s 已取消。";

	private final static String CLOSE_CHG_DESC_EN = "Order %s has been closed.";

	private final static String CHECK_CHG_ADMIN_DESC_CN = "订单审核通过。";

	private final static String CHECK_CHG_ADMIN_DESC_EN = "Order review passed.";
	
	private final static String REFUSE_CHECK_CHG_ADMIN_DESC_CN = "订单未通过审核。";
	
	private final static String REFUSE_CHECK_CHG_ADMIN_DESC_EN = "Order review failed.";
	
	/**
	 * 译员xxxxxx领取了订单	Translator XXX  claimed the order
	 */
	private final static String ORDER_RECEIVE_DESC_CN_INTERPER = "译员%s领取了订单";
	private final static String ORDER_RECEIVE_DESC_EN_INTERPER = "Translator %s claimed the order";
	/**
	 * 管理员xxxxx领取订单	Administrator XXX claimed the order
	 */
	private final static String ORDER_RECEIVE_DESC_CN_LSP = "管理员%s领取订单";
	private final static String ORDER_RECEIVE_DESC_EN_LSP = "Administrator %s claimed the order";
	
	private final static String ORDER_CONFIRME_DESC_CN_SYS = "系统确认了订单";
	private final static String ORDER_CONFIRME_DESC_EN_SYS = "System confirmed the order";
	
	@Autowired
	private IOrdOdStateChgAtomSV ordOdStateChgAtomSV;

	@Override
	public void addPayChgDesc(OrdOdStateChg chg) {
		chg.setStateChgId(SequenceUtil.createStateChgId());
		String descCn = PAY_CHG_USER_DESC_CN;
		String descEn = PAY_CHG_USER_DESC_EN;
		if (OrdersConstants.OrgID.ORG_ID_SYS.equals(chg.getOrgId())) {
			descCn = PAY_CHG_ADMIN_DESC_CN;
			descEn = PAY_CHG_ADMIN_DESC_EN;
		}
		chg.setChgDesc(descCn);
		chg.setChgDescEn(descEn);
		chg.setStateChgTime(DateUtil.getSysDate());
		chg.setChgDescD("订单已支付成功，进入任务中心等待译员领取");
		chg.setChgDescUEn("Your order has been paid and released to the task center.  A translator will be assigned to deal with the task.");
		chg.setFlag(OrdOdStateChgConstants.FLAG_USER);
		ordOdStateChgAtomSV.insertSelective(chg);
	}

	@Override
	public void addUpdateChgDesc(OrdOdStateChg chg) {
		chg.setStateChgId(SequenceUtil.createStateChgId());
		String descCn = String.format(UPDATE_CHG_ADMIN_DESC_CN,
				chg.getOperName() == null ? chg.getOperId() : chg.getOperName());
		String descEn = String.format(UPDATE_CHG_ADMIN_DESC_EN,
				chg.getOperName() == null ? chg.getOperId() : chg.getOperName());
		chg.setOrgId(OrdersConstants.OrgID.ORG_ID_SYS);
		chg.setChgDesc(descCn);
		chg.setChgDescEn(descEn);
		chg.setStateChgTime(DateUtil.getSysDate());
		ordOdStateChgAtomSV.insertSelective(chg);
	}

	@Override
	public void addOfferChgDesc(OrdOdStateChg chg) {
		chg.setStateChgId(SequenceUtil.createStateChgId());
		String descCn = String.format(OFFER_CHG_ADMIN_DESC_CN,
				chg.getOperName() == null ? chg.getOperId() : chg.getOperName());
		String descEn = String.format(OFFER_CHG_ADMIN_DESC_EN,
				chg.getOperName() == null ? chg.getOperId() : chg.getOperName());
		chg.setOrgId(OrdersConstants.OrgID.ORG_ID_SYS);
		chg.setChgDesc(descCn);
		chg.setChgDescEn(descEn);
		chg.setChgDescD(descCn);
		chg.setChgDescUEn(descEn);
		chg.setFlag(OrdOdStateChgConstants.FLAG_USER);
		
		chg.setStateChgTime(DateUtil.getSysDate());
		ordOdStateChgAtomSV.insertSelective(chg);
	}

	@Override
	public void addCloseChgDesc(OrdOdStateChg chg) {
		chg.setStateChgId(SequenceUtil.createStateChgId());
		String descCn = String.format(CLOSE_CHG_ADMIN_DESC_CN,
				chg.getOperName() == null ? chg.getOperId() : chg.getOperName());
		String descEn = String.format(CLOSE_CHG_ADMIN_DESC_EN,
				chg.getOperName() == null ? chg.getOperId() : chg.getOperName());
		chg.setOrgId(OrdersConstants.OrgID.ORG_ID_USER);
		chg.setChgDesc(descCn);
		chg.setChgDescEn(descEn);
		chg.setChgDescD("订单 "+chg.getOrderId()+" 已取消");
		chg.setChgDescUEn("Order "+chg.getOrderId()+" has been closed.");
		chg.setFlag(OrdOdStateChgConstants.FLAG_USER);
		chg.setStateChgTime(DateUtil.getSysDate());
		ordOdStateChgAtomSV.insertSelective(chg);
	}
	
	public void addAllCloseChgDesc(OrdOdStateChg chg) {
		chg.setStateChgId(SequenceUtil.createStateChgId());
		String descCn = String.format(CLOSE_CHG_DESC_CN,String.valueOf(chg.getOrderId()));
		String descEn = String.format(CLOSE_CHG_DESC_EN,String.valueOf(chg.getOrderId()));
		chg.setChgDesc(descCn);
		chg.setChgDescEn(descEn);
		chg.setChgDescD(descCn);
		chg.setChgDescUEn(descEn);
		chg.setFlag(OrdOdStateChgConstants.FLAG_USER);
		
		chg.setStateChgTime(DateUtil.getSysDate());
		ordOdStateChgAtomSV.insertSelective(chg);
	}

	@Override
	public void checkChgDesc(OrdOdStateChg chg) {
		chg.setStateChgId(SequenceUtil.createStateChgId());
		if(OrdersConstants.OrderState.WAIT_OK_STATE.equals(chg.getNewState())){
			chg.setChgDesc(CHECK_CHG_ADMIN_DESC_CN);
			chg.setChgDescEn(CHECK_CHG_ADMIN_DESC_EN);
			chg.setChgDescD("您的订单已翻译完成，请确认翻译结果");
			chg.setChgDescUEn("Your order has been translated, please confirm the translation results");
			chg.setFlag(OrdOdStateChgConstants.FLAG_USER);
			
		}else{
			chg.setChgDesc(REFUSE_CHECK_CHG_ADMIN_DESC_CN);
			chg.setChgDescEn(REFUSE_CHECK_CHG_ADMIN_DESC_EN);
		}
		chg.setStateChgTime(DateUtil.getSysDate());
		ordOdStateChgAtomSV.insertSelective(chg);
	}

	@Override
	public void orderReceiveChgDesc(OrderReceiveRequest request, String interperId, String interperType, String lspId,String orgState) {
		//普通译员领取订单，需要插入两条订单流转信息，即：原始state->已领取，已领取->翻译中
		if ("0".equals(interperType)) {
			//== start===原始state->已领取========
			OrdOdStateChg ordOdStateChg2Receive = new OrdOdStateChg();
			//
			String operName = "";
			if(null == request.getStateChgInfo()){
				operName = "";
			}else{
				if(!StringUtil.isBlank(request.getStateChgInfo().getOperName())){
					operName = request.getStateChgInfo().getOperName();
				}
			}
			//
			ordOdStateChg2Receive.setStateChgId(SequenceUtil.createStateChgId());
			ordOdStateChg2Receive.setNewState(OrdersConstants.OrderState.STATE_RECEIVED);
			ordOdStateChg2Receive.setOrgState(orgState);
			ordOdStateChg2Receive.setOrderId(request.getBaseInfo().getOrderId());
			String descCn = "";
			String descEn = "";
			
			descCn = String.format(ORDER_RECEIVE_DESC_CN_INTERPER,operName);
			descEn = String.format(ORDER_RECEIVE_DESC_EN_INTERPER,operName);
			ordOdStateChg2Receive.setOperId(interperId);
			
			ordOdStateChg2Receive.setOperName(operName);
			ordOdStateChg2Receive.setChgDesc(descCn);
			ordOdStateChg2Receive.setChgDescEn(descEn);
			ordOdStateChg2Receive.setStateChgTime(DateUtil.getSysDate());
			
			ordOdStateChg2Receive.setChgDescD("订单已被译员领取，正在翻译中，请耐心等待");
			ordOdStateChg2Receive.setChgDescUEn("Your order has been claimed by a translator and is being translated, please wait patiently");
			ordOdStateChg2Receive.setFlag(OrdOdStateChgConstants.FLAG_USER);
			
			ordOdStateChgAtomSV.insertSelective(ordOdStateChg2Receive);
			//== end===原始state->已领取========
			
			//== start===已领取->翻译中========
			OrdOdStateChg ordOdStateChg2Translating = new OrdOdStateChg();
			ordOdStateChg2Translating.setStateChgId(SequenceUtil.createStateChgId());
			ordOdStateChg2Translating.setNewState(OrdersConstants.OrderState.STATE_TRASLATING);
			ordOdStateChg2Translating.setOrgState(OrdersConstants.OrderState.STATE_RECEIVED);
			ordOdStateChg2Translating.setOrderId(request.getBaseInfo().getOrderId());
			ordOdStateChg2Translating.setOperId(interperId);
			
			ordOdStateChg2Translating.setOperName(operName);
			ordOdStateChg2Translating.setChgDesc("订单翻译中");
			ordOdStateChg2Translating.setChgDescEn("Is translation orders");
			ordOdStateChg2Translating.setStateChgTime(DateUtil.getSysDate());
			
			ordOdStateChgAtomSV.insertSelective(ordOdStateChg2Translating);
			//== end===已领取->翻译中========
		}
		//LSP译员领取订单，流程和之前一样，插入一条订单流转信息
		else if ("1".equals(interperType)) {
			OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
			//
			String operName = "";
			if(null == request.getStateChgInfo()){
				operName = "";
			}else{
				if(!StringUtil.isBlank(request.getStateChgInfo().getOperName())){
					operName = request.getStateChgInfo().getOperName();
				}
			}
			//
			ordOdStateChg.setStateChgId(SequenceUtil.createStateChgId());
			ordOdStateChg.setNewState(request.getBaseInfo().getState());
			ordOdStateChg.setOrgState(orgState);
			ordOdStateChg.setOrderId(request.getBaseInfo().getOrderId());
			String descCn = "";
			String descEn = "";
			
			descCn = String.format(ORDER_RECEIVE_DESC_CN_LSP,operName);
			descEn = String.format(ORDER_RECEIVE_DESC_EN_LSP,operName);
			ordOdStateChg.setOperId(lspId);
			
			ordOdStateChg.setOperName(operName);
			ordOdStateChg.setChgDesc(descCn);
			ordOdStateChg.setChgDescEn(descEn);
			ordOdStateChg.setStateChgTime(DateUtil.getSysDate());
			
			ordOdStateChg.setChgDescD("订单已被译员领取，正在翻译中，请耐心等待");
			ordOdStateChg.setChgDescUEn("Your order has been claimed by a translator and is being translated, please wait patiently");
			ordOdStateChg.setFlag(OrdOdStateChgConstants.FLAG_USER);
			
			ordOdStateChgAtomSV.insertSelective(ordOdStateChg);
		}
		
		
	}

	@Override
	public void addSysConfirmeChgDesc(OrdOdStateChg chg) {
		chg.setStateChgId(SequenceUtil.createStateChgId());
		chg.setChgDesc(ORDER_CONFIRME_DESC_CN_SYS);
		chg.setChgDescEn(ORDER_CONFIRME_DESC_EN_SYS);
		chg.setOrgId(OrdersConstants.OrgID.ORG_ID_SYS);
    	chg.setOperId(OrdersConstants.SYS_OPER_ID);
		chg.setStateChgTime(DateUtil.getSysDate());
		ordOdStateChgAtomSV.insertSelective(chg);
	}

}
