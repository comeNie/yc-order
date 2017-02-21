package com.ai.yc.order.service.business.interfaces;

import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionRequest;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionResponse;
import com.ai.yc.order.dao.mapper.bo.OrdOdLogistics;

public interface IOrderSubmissionBusiSV {
	public OrderSubmissionResponse saveOrderSubmission(OrderSubmissionRequest request);
	public OrderSubmissionResponse saveOrderSubmissionSupper(OrderSubmissionRequest request);
	public OrderSubmissionResponse saveOrderSubmissionSupperMds(Long orderId,OrderSubmissionRequest request);
	public OrderSubmissionResponse saveOrderSubmissionSupperMdsSend(OrderSubmissionRequest request);
	public void saveContact(OrdOdLogistics ordOdLogistics);
	
}
