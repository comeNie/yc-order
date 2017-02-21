package com.ai.yc.order.service.atom.interfaces;

import java.util.List;

import com.ai.yc.order.dao.mapper.bo.OrdOdProdExtend;

public interface IOrdOdProdExtendAtomSV {
	
	public void insertSelective(OrdOdProdExtend ordOdProdExtend);
	
	List<OrdOdProdExtend> findByOrderId(Long orderId);
}
