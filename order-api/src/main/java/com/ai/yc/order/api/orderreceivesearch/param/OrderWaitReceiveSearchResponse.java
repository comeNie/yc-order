package com.ai.yc.order.api.orderreceivesearch.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

public class OrderWaitReceiveSearchResponse extends BaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 分页数据
	 */
	private PageInfo<OrderWaitReceiveSearchInfo> pageInfo;

	public PageInfo<OrderWaitReceiveSearchInfo> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<OrderWaitReceiveSearchInfo> pageInfo) {
		this.pageInfo = pageInfo;
	}

}
