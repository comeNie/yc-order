package com.ai.yc.order.service.atom.interfaces;

import java.util.List;

import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;

public interface IOrdOdStateChgAtomSV {
	
	List<OrdOdStateChg> findByOrderId(Long orderId);
	
	public void insertSelective(OrdOdStateChg ordOdStateChg);
	
	public List<OrdOdStateChg> findByOrderIdAndFlag(Long orderId,String flag);

	List<OrdOdStateChg> findByOrderIdAndFlag4Portal(Long orderId, String flag);
	public OrdOdStateChg findByOrderIdAndOrgState(Long orderId,String orgState);
}
