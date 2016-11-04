package com.ai.yc.order.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.bo.OrdOdProdExtend;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdExtendAtomSV;

@Component
public class OrdOdProdExtendAtomSVImpl implements IOrdOdProdExtendAtomSV {

	@Override
	public void insertSelective(OrdOdProdExtend ordOdProdExtend) {
		// TODO Auto-generated method stub
		MapperFactory.getOrdOdProdExtendMapper().insertSelective(ordOdProdExtend);
	}

}
