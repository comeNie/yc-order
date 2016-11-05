package com.ai.yc.order.service.atom.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdOdLogistics;

public interface IOrdOdLogisticsAtomSV {
	public void insertSelective(OrdOdLogistics ordOdLogistics);
	
	OrdOdLogistics findByOrderId(Long orderId);
	
}
