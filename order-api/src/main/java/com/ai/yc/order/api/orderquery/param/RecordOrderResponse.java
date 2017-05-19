package com.ai.yc.order.api.orderquery.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

public class RecordOrderResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	private PageInfo<RecordOrderVo> pageInfo;
	/**
	 * 总费用信息
	 */
	private RecoedCountInfo countInfo;

	public PageInfo<RecordOrderVo> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<RecordOrderVo> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public RecoedCountInfo getCountInfo() {
		return countInfo;
	}

	public void setCountInfo(RecoedCountInfo countInfo) {
		this.countInfo = countInfo;
	}

}
