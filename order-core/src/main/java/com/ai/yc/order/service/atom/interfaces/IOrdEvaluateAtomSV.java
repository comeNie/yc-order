package com.ai.yc.order.service.atom.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdEvaluate;

public interface IOrdEvaluateAtomSV {
	OrdEvaluate findByOrderId(Long orderId);
	
	OrdEvaluate findByOrderId(Long orderId,String state);
	
	int updateEvaluateByOrdId(OrdEvaluate ordEvaluate,Long orderId);
}
