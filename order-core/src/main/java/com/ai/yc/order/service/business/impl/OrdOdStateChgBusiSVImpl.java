package com.ai.yc.order.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.opt.sdk.util.DateUtil;
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
	
    private final static String PAY_CHG_ADMIN_DESC_CN = "管理员%s支付了订单。";
	
	private final static String PAY_CHG_ADMIN_DESC_EN = "Administrator %s pay for the order.";
	
	private final static String UPDATE_CHG_ADMIN_DESC_CN = "管理员%s修改了订单。";
		
	private final static String UPDATE_CHG_ADMIN_DESC_EN = "Administrator %s revised the order.";
	
	private final static String OFFER_CHG_ADMIN_DESC_CN = "订单已报价，等待您支付。";
	
	private final static String OFFER_CHG_ADMIN_DESC_EN = "order has been quoted, waiting for you to pay.";
	
	private final static String CLOSE_CHG_ADMIN_DESC_CN = "管理员%s关闭了订单。";
	
	private final static String CLOSE_CHG_ADMIN_DESC_EN = "Administrator %s closed the order.";
	
	
	@Autowired
	private IOrdOdStateChgAtomSV ordOdStateChgAtomSV;
	
	@Override
	public void addPayChgDesc(OrdOdStateChg chg){
		chg.setStateChgId(SequenceUtil.createStateChgId());
		String descCn = PAY_CHG_USER_DESC_CN;
		String descEn = PAY_CHG_USER_DESC_EN;
		if(OrdersConstants.OrgID.ORG_ID_SYS.equals(chg.getOrgId())){
			descCn = String.format(PAY_CHG_ADMIN_DESC_CN, chg.getOperName()==null?chg.getOperId():chg.getOperName());
			descEn = String.format(PAY_CHG_ADMIN_DESC_EN, chg.getOperName()==null?chg.getOperId():chg.getOperName());
		}
		
		chg.setChgDesc(descCn);
		chg.setChgDescEn(descEn);
		chg.setStateChgTime(DateUtil.getSysDate());
		ordOdStateChgAtomSV.insertSelective(chg);
	}

	@Override
	public void addUpdateChgDesc(OrdOdStateChg chg) {
		chg.setStateChgId(SequenceUtil.createStateChgId());
		String descCn = String.format(UPDATE_CHG_ADMIN_DESC_CN, chg.getOperName()==null?chg.getOperId():chg.getOperName());
		String descEn = String.format(UPDATE_CHG_ADMIN_DESC_EN, chg.getOperName()==null?chg.getOperId():chg.getOperName());
		chg.setOrgId(OrdersConstants.OrgID.ORG_ID_SYS);
		chg.setChgDesc(descCn);
		chg.setChgDescEn(descEn);
		chg.setStateChgTime(DateUtil.getSysDate());
		ordOdStateChgAtomSV.insertSelective(chg);
	}

	@Override
	public void addOfferChgDesc(OrdOdStateChg chg) {
		chg.setStateChgId(SequenceUtil.createStateChgId());
		String descCn = String.format(OFFER_CHG_ADMIN_DESC_CN, chg.getOperName()==null?chg.getOperId():chg.getOperName());
		String descEn = String.format(OFFER_CHG_ADMIN_DESC_EN, chg.getOperName()==null?chg.getOperId():chg.getOperName());
		chg.setOrgId(OrdersConstants.OrgID.ORG_ID_SYS);
		chg.setChgDesc(descCn);
		chg.setChgDescEn(descEn);
		chg.setStateChgTime(DateUtil.getSysDate());
		ordOdStateChgAtomSV.insertSelective(chg);
	}

	@Override
	public void addCloseChgDesc(OrdOdStateChg chg) {
		chg.setStateChgId(SequenceUtil.createStateChgId());
		String descCn = String.format(CLOSE_CHG_ADMIN_DESC_CN, chg.getOperName()==null?chg.getOperId():chg.getOperName());
		String descEn = String.format(CLOSE_CHG_ADMIN_DESC_EN, chg.getOperName()==null?chg.getOperId():chg.getOperName());
		chg.setOrgId(OrdersConstants.OrgID.ORG_ID_USER);
		chg.setChgDesc(descCn);
		chg.setChgDescEn(descEn);
		chg.setStateChgTime(DateUtil.getSysDate());
		ordOdStateChgAtomSV.insertSelective(chg);
	}

}
