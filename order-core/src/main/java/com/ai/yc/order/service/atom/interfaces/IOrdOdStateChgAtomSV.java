package com.ai.yc.order.service.atom.interfaces;

import java.util.List;

import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;

public interface IOrdOdStateChgAtomSV {
	
	List<OrdOdStateChg> findByOrderId(Long orderId);

}
