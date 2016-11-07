package com.ai.yc.order.service.atom.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;

public interface IOrdOdFeeTotalAtomSV {
	public void insertSelective(OrdOdFeeTotal ordOdFeeTotal);
	
	OrdOdFeeTotal findByOrderId(String payFlag,Long orderId);
	
    void updateByOrderIdSelective(Long orderId, OrdOdFeeTotal record);
	
	OrdOdFeeTotal findByOrderId(Long orderId);
	
	
}
