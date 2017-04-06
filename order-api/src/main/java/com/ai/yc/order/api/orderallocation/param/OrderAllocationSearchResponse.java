package com.ai.yc.order.api.orderallocation.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

public class OrderAllocationSearchResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 分页数据
	 */
	private PageInfo<OrderAllocationSearchInfo> pageInfo;

	public PageInfo<OrderAllocationSearchInfo> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<OrderAllocationSearchInfo> pageInfo) {
		this.pageInfo = pageInfo;
	}

}
