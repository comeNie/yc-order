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
	
	@Autowired
	private IOrdOdStateChgAtomSV ordOdStateChgAtomSV;
	
	@Override
	public void addPayChgDesc(OrdOdStateChg chg){
		chg.setStateChgId(SequenceUtil.createStateChgId());
		String descCn = PAY_CHG_USER_DESC_CN;
		String descEn = PAY_CHG_USER_DESC_EN;
		if(OrdersConstants.OrgID.ORG_ID_SYS.equals(chg.getOrgId())){
			descCn = String.format(PAY_CHG_ADMIN_DESC_CN, chg.getOperName());
			descEn = String.format(PAY_CHG_ADMIN_DESC_EN, chg.getOperName());
		}
		chg.setChgDesc(descCn);
		chg.setChgDescEn(descEn);
		chg.setStateChgTime(DateUtil.getSysDate());
		ordOdStateChgAtomSV.insertSelective(chg);
	}

}
