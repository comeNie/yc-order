package com.ai.yc.order.api.updateorder.param;

import java.io.Serializable;
import java.util.List;


/**
 * @author hougang@asiainfo.com
 * @date 2016年11月7日 下午4:35:01 
 * @version V1.0
 */
public class UpdateOrderRequest implements Serializable{

	private static final long serialVersionUID = -212890110727468044L;
	
	/**
	 * 订单ID(必填)
	 */
	private Long orderId;
	
	/**
	 * 订单级别
	 */
	private String orderLevel;
	
	 /**
     * 订单费用信息
     */
    private UOrderFeeVo orderFee;
	
	 /**
     * 联系人信息
     */
    private UContactsVo contacts;
    
    /**
     * 产品明细信息
     */
    private UProdVo prod;
    
    /**
     * 文件列表
     */
    private List<UProdFileVo> prodFiles;
    
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

	public UOrderFeeVo getOrderFee() {
		return orderFee;
	}

	public void setOrderFee(UOrderFeeVo orderFee) {
		this.orderFee = orderFee;
	}

	public UContactsVo getContacts() {
		return contacts;
	}

	public void setContacts(UContactsVo contacts) {
		this.contacts = contacts;
	}

	public UProdVo getProd() {
		return prod;
	}

	public void setProd(UProdVo prod) {
		this.prod = prod;
	}

	public List<UProdFileVo> getProdFiles() {
		return prodFiles;
	}

	public void setProdFiles(List<UProdFileVo> prodFiles) {
		this.prodFiles = prodFiles;
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

	public String getOrderLevel() {
		return orderLevel;
	}

	public void setOrderLevel(String orderLevel) {
		this.orderLevel = orderLevel;
	}
    
    

}
