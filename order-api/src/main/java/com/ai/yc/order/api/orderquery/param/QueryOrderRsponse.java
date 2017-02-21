package com.ai.yc.order.api.orderquery.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

public class QueryOrderRsponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	private PageInfo<OrdOrderVo> pageInfo;

	public PageInfo<OrdOrderVo> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<OrdOrderVo> pageInfo) {
		this.pageInfo = pageInfo;
	}

}
