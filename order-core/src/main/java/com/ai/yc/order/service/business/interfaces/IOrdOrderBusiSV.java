package com.ai.yc.order.service.business.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdOrder;

public interface IOrdOrderBusiSV {
	public OrdOrder findByPrimaryKey(OrdOrder ordOrder);
}
