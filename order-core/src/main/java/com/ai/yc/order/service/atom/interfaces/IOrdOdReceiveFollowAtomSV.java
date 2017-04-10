package com.ai.yc.order.service.atom.interfaces;

import java.util.List;

import com.ai.yc.order.dao.mapper.bo.OrdOdReceiveFollow;

public interface IOrdOdReceiveFollowAtomSV {
	public void insertSelective(OrdOdReceiveFollow ordOdReceiveFollow);
	
	public List<OrdOdReceiveFollow> findByOrderId(long orderId);
	
	public OrdOdReceiveFollow findByRecerveState(String recerveState);
	
	public void updateSelective(OrdOdReceiveFollow ordOdReceiveFollow);
	
	public List<OrdOdReceiveFollow> findByOrderAndState(long orderId,String recerveState);
	
	public OrdOdReceiveFollow find(OrdOdReceiveFollow ordOdReceiveFollow);
	
	
}
