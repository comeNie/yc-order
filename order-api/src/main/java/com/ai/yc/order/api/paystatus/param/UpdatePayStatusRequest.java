package com.ai.yc.order.api.paystatus.param;

import java.io.Serializable;

/**
 * @author hougang@asiainfo.com
 * @date 2016年11月7日 上午10:27:55 
 * @version V1.0
 */
public class UpdatePayStatusRequest implements Serializable {

	private static final long serialVersionUID = 3650566851945251701L;
	
	/**
	 * 订单ID (必填)
	 */
	private Long orderId;
    
    /**
     * 费用信息(必填)
     */
    private OrderFeeVo orderFee;
    
    /**
	 * 操作工号 (必填)
	 */
	private String operId;
	
	/**
	 * 操作人用户名
	 */
	private String operName;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	

	public OrderFeeVo getOrderFee() {
		return orderFee;
	}

	public void setOrderFee(OrderFeeVo orderFee) {
		this.orderFee = orderFee;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

    
}
