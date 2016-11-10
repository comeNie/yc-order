package com.ai.yc.order.api.orderfee.param;

import java.io.Serializable;

public class OrderFeeProdInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 产品明细id
	 */
	private Long prodDetalId;
	/**
	 * 翻译类型
	 */
	private String translateType;
	/**
	 * 翻译主题
	 */
	private String translateName;

	public Long getProdDetalId() {
		return prodDetalId;
	}

	public void setProdDetalId(Long prodDetalId) {
		this.prodDetalId = prodDetalId;
	}

	public String getTranslateType() {
		return translateType;
	}

	public void setTranslateType(String translateType) {
		this.translateType = translateType;
	}

	public String getTranslateName() {
		return translateName;
	}

	public void setTranslateName(String translateName) {
		this.translateName = translateName;
	}

}
