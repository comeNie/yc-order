package com.ai.yc.order.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.bo.OrdOdProdFile;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdFileAtomSV;
@Component
public class OrdOdProdFileAtomSVImpl implements IOrdOdProdFileAtomSV {

	@Override
	public void insertSelective(OrdOdProdFile ordOdProdFile) {
		// TODO Auto-generated method stub
		MapperFactory.getOrdOdProdFileMapper().insertSelective(ordOdProdFile);
	}

}
