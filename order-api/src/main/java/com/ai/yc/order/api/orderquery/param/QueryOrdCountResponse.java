package com.ai.yc.order.api.orderquery.param;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

public class QueryOrdCountResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	

	private List<OrderCountVo> countVos;


	public List<OrderCountVo> getCountVos() {
		return countVos;
	}


	public void setCountVos(List<OrderCountVo> countVos) {
		this.countVos = countVos;
	}
	
	

}
