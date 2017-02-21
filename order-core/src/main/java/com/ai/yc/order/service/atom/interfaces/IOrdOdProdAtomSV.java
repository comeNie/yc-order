package com.ai.yc.order.service.atom.interfaces;

import java.sql.Timestamp;
import java.util.List;

import com.ai.yc.order.dao.mapper.bo.OrdOdProd;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdWithBLOBs;

public interface IOrdOdProdAtomSV {
	public void insertSelective(OrdOdProdWithBLOBs ordOdProdWithBLOBs);
	
	OrdOdProdWithBLOBs findByOrderId(Long orderId);
	
	void updateByOrderIdSelective(OrdOdProdWithBLOBs ordOdProdWithBLOBs,Long orderId);
	
	public List<OrdOdProd> findByOrdersAndEndTime(List<Long> orderIds,Timestamp endTime);
}
