package com.ai.yc.order.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.dao.mapper.interfaces.OrdOrderMapper;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
@Component
public class OrdOrderAtomSVImpl implements IOrdOrderAtomSV {

	@Override
	public OrdOrder findByPrimaryKey(OrdOrder ordOrder) {
		OrdOrderMapper ordOrderMapper = MapperFactory.getOrdOrderMapper();
		
		return ordOrderMapper.selectByPrimaryKey(ordOrder.getOrderId());
	}

}
