package com.ai.yc.order.api.orderquery.param;

import java.util.Map;

import com.ai.opt.base.vo.BaseResponse;

public class QueryOrdCountResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	

	private Map<String,Integer> countMap;


	public Map<String, Integer> getCountMap() {
		return countMap;
	}


	public void setCountMap(Map<String, Integer> countMap) {
		this.countMap = countMap;
	}


	

}
