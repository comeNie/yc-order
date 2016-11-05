package com.ai.yc.order.service.atom.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdOdProdWithBLOBs;

public interface IOrdOdProdAtomSV {
	public void insertSelective(OrdOdProdWithBLOBs ordOdProdWithBLOBs);
	
	OrdOdProdWithBLOBs findByOrderId(Long orderId);
}
