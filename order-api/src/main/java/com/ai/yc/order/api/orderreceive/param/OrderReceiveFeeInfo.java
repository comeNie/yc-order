package com.ai.yc.order.api.orderreceive.param;

import java.io.Serializable;

public class OrderReceiveFeeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 平台佣金
	private Long platFee;// PLAT_FEE
	// 译员佣金
	private Long interperFee;// INTERPER_FEE

	public Long getPlatFee() {
		return platFee;
	}

	public void setPlatFee(Long platFee) {
		this.platFee = platFee;
	}

	public Long getInterperFee() {
		return interperFee;
	}

	public void setInterperFee(Long interperFee) {
		this.interperFee = interperFee;
	}

}
