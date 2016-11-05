package com.ai.yc.order.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.bo.OrdOdProdWithBLOBs;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
@Component
public class OrdOdProdAtomSVImpl implements IOrdOdProdAtomSV {

	@Override
	public void insertSelective(OrdOdProdWithBLOBs ordOdProdWithBLOBs) {
		MapperFactory.getOrdOdProdMapper().insertSelective(ordOdProdWithBLOBs);
	}
	
}
