package com.ai.yc.order.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.bo.OrdOdProdLevel;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdLevelAtomSV;
@Component
public class OrdOdProdLevelAtomSVImpl implements IOrdOdProdLevelAtomSV {

	@Override
	public void insertSelective(OrdOdProdLevel ordOdProdLevel) {
		// TODO Auto-generated method stub
		MapperFactory.getOrdOdProdLevelMapper().insertSelective(ordOdProdLevel);
	}

}
