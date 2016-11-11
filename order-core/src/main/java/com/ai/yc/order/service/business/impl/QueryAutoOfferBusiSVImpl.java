package com.ai.yc.order.service.business.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.common.api.sysduad.param.QuerySysDuadDetailsRes;
import com.ai.yc.common.api.syspurpose.param.QuerySysPurposeDetailsRes;
import com.ai.yc.order.api.autooffer.param.QueryAutoOfferReq;
import com.ai.yc.order.api.autooffer.param.QueryAutoOfferRes;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.constants.ResultCodeConstants;
import com.ai.yc.order.service.atom.interfaces.ISysConfigAtomSV;
import com.ai.yc.order.service.business.interfaces.IQueryAutoOfferBusiSV;


/**
 * @Description: TODO
 * @author hougang@asiainfo.com
 * @date 2016年11月2日 下午3:15:46 
 * @version V1.0
 */
@Service
public class QueryAutoOfferBusiSVImpl implements IQueryAutoOfferBusiSV {
	
	@Autowired
	private transient ISysConfigAtomSV iSysConfigAtomSV;

	@Override
	public QueryAutoOfferRes queryAutoOffer(QueryAutoOfferReq req) {
		QueryAutoOfferRes res = new QueryAutoOfferRes();
		QuerySysDuadDetailsRes duad = iSysConfigAtomSV.querySysDuadDetails(req.getDuadId());
		BigDecimal wordfee = new BigDecimal(0);
		if(OrdersConstants.TranslateLevel.ORDINARY.equals(req.getTranslateLevel())){
			if(req.isUrgent()){
				wordfee = (new BigDecimal(duad.getOrdinaryUrgent())).multiply(new BigDecimal(req.getWordNum()));
			}else{
				wordfee = (new BigDecimal(duad.getOrdinary())).multiply(new BigDecimal(req.getWordNum()));
			}
		}else if(OrdersConstants.TranslateLevel.PERFESSION.equals(req.getTranslateLevel())){
			if(req.isUrgent()){
				wordfee = (new BigDecimal(duad.getProfessionalUrgent())).multiply(new BigDecimal(req.getWordNum()));
			}else{
				wordfee = (new BigDecimal(duad.getProfessional())).multiply(new BigDecimal(req.getWordNum()));
			}
		}else if(OrdersConstants.TranslateLevel.PUBLISH.equals(req.getTranslateLevel())){
			if(req.isUrgent()){
				wordfee = (new BigDecimal(duad.getPublishUrgent())).multiply(new BigDecimal(req.getWordNum()));
			}else{
				wordfee = (new BigDecimal(duad.getPublish())).multiply(new BigDecimal(req.getWordNum()));
			}
		}
		res.setValuationWay(QueryAutoOfferRes.VALUATION_WAY_WORD);
		res.setCurrencyUnit(duad.getCurrency());
		QuerySysPurposeDetailsRes purpose = iSysConfigAtomSV.querySysPurposeDetails(req.getPurposeId());
		if(QuerySysPurposeDetailsRes.NAME_FLAG_YES.equals(purpose.getNamedFlag())){
			if(OrdersConstants.TranslatePrice.DOLLAR.equals(duad.getCurrency())){
				if(OrdersConstants.TranslatePrice.BASE_DOLLAR.compareTo(wordfee)>0){
					wordfee = OrdersConstants.TranslatePrice.BASE_DOLLAR;
					res.setValuationWay(QueryAutoOfferRes.VALUATION_WAY_BASE);
				}
			}else{
				if(OrdersConstants.TranslatePrice.BASE_RMB.compareTo(wordfee)>0){
					wordfee = OrdersConstants.TranslatePrice.BASE_RMB;
					res.setValuationWay(QueryAutoOfferRes.VALUATION_WAY_BASE);
				}
			}
		}
		//单位为厘
		res.setPrice(wordfee.multiply(new BigDecimal(1000)));
		res.setOfferTime(DateUtil.getSysDate());
		res.setResponseHeader(new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "查询成功"));
		return res;
	}

}
