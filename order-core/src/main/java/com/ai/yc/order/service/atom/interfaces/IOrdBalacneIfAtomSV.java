package com.ai.yc.order.service.atom.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdBalacneIf;

public interface IOrdBalacneIfAtomSV {
	OrdBalacneIf findByOrderId(Long orderId);
	public void insertSelective(OrdBalacneIf ordBalacneIf);
}
