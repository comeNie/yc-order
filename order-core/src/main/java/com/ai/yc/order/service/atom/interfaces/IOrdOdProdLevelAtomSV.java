package com.ai.yc.order.service.atom.interfaces;

import java.util.List;

import com.ai.yc.order.dao.mapper.bo.OrdOdProdLevel;

public interface IOrdOdProdLevelAtomSV {
	public void insertSelective(OrdOdProdLevel ordOdProdLevel);
	
	List<OrdOdProdLevel> findByOrderId(Long orderId);
}
