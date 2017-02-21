package com.ai.yc.order.api.autooffer.param;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseResponse;

/**
 * @author hougang@asiainfo.com
 * @date 2016年11月2日 下午2:04:30 
 * @version V1.0
 */
public class QueryAutoOfferRes extends BaseResponse {
	
	private static final long serialVersionUID = 1491453195005847515L;
	
	/**
	 * 字数计价
	 */
	public final static String VALUATION_WAY_WORD = "0";
	
	/**
	 * 份数计价 起步价
	 */
	public final static String VALUATION_WAY_BASE = "1";

	/**
	 * 计价方式 0字数计价 1份数计价
	 */
	private String valuationWay;
	
	/**
	 * 价格
	 */
	private BigDecimal price;
	
	/**
	 * 币种  1：RMB 2：$
	 */
	private String currencyUnit;
	
	/**
	 * 报价时间
	 */
	private Timestamp offerTime;

	public String getValuationWay() {
		return valuationWay;
	}

	public void setValuationWay(String valuationWay) {
		this.valuationWay = valuationWay;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurrencyUnit() {
		return currencyUnit;
	}

	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

	public Timestamp getOfferTime() {
		return offerTime;
	}

	public void setOfferTime(Timestamp offerTime) {
		this.offerTime = offerTime;
	}
	
	

}
