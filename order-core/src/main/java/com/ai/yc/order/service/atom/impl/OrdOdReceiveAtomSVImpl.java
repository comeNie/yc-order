package com.ai.yc.order.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.bo.OrdOdReceive;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdReceiveAtomSV;
@Component
public class OrdOdReceiveAtomSVImpl implements IOrdOdReceiveAtomSV{

	@Override
	public int updateByPrimaryKeySelective(OrdOdReceive record) {
		return MapperFactory.getOrdOdReceiveMapper().updateByPrimaryKeySelective(record);
	}

}
