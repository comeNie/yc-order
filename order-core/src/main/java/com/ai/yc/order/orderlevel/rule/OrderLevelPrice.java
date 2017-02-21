package com.ai.yc.order.orderlevel.rule;

public class OrderLevelPrice {
	/**
	 * 最低价格
	 */
	private Integer minPrice;
	/**
	 * 最高价格
	 */
	private Integer maxPrice;
	
	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}

	public static void main(String args[]){
		int a = 10;
		if(a<50 && a>20){
			
		}else{
			System.out.println("sssss");
		}
	}
}
