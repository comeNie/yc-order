package com.ai.yc.order.service.atom.interfaces;

import java.util.List;

import com.ai.yc.order.dao.mapper.bo.OrdOdReceive;

public interface IOrdOdReceiveAtomSV {
	
	public int insertByPrimaryKeySelective(OrdOdReceive record);
	
	public List<OrdOdReceive> findByFollowId(long followId);
}
