package com.ai.yc.order.api.orderquery.param;

import java.io.Serializable;

public class OrderCountVo implements Serializable{
	
	private static final long serialVersionUID = 8428615784226173082L;
	
	/**
	    * 订单状态(后厂)
		*21：已领取
		*23：翻译中
	     */
	    private String state;
	    
	    /**
	     * 客户端显示状态
	     * 11：待支付
	     *13：待报价
	     *23：翻译中
	     *50：待确认
	     *52：待评价
	     */
	    private String displayFlag;
	    
	    /**
		 * 订单条数
		 */
		private Integer orderNum; 
	

		public OrderCountVo() {
			super();
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getDisplayFlag() {
			return displayFlag;
		}

		public void setDisplayFlag(String displayFlag) {
			this.displayFlag = displayFlag;
		}



		public Integer getOrderNum() {
			return orderNum;
		}



		public void setOrderNum(Integer orderNum) {
			this.orderNum = orderNum;
		}

		

}
