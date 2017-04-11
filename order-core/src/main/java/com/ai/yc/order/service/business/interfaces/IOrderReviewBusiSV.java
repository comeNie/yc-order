package com.ai.yc.order.service.business.interfaces;

import com.ai.yc.order.api.orderreview.param.OrderLspReviewRequest;
import com.ai.yc.order.api.orderreview.param.OrderReviewRequest;

public interface IOrderReviewBusiSV {
	public void check(OrderReviewRequest request);
	
	public void lspCheck(OrderLspReviewRequest request);

}
