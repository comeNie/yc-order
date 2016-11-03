package com.ai.yc.order.service.atom.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdOrder;

public interface IOrdOrderAtomSV {
	public OrdOrder findByPrimaryKey(OrdOrder ordOrder);
}
