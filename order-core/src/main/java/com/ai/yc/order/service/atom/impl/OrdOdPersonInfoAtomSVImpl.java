package com.ai.yc.order.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.bo.OrdOdPersonInfo;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdPersonInfoAtomSV;
@Component
public class OrdOdPersonInfoAtomSVImpl implements IOrdOdPersonInfoAtomSV {

	@Override
	public void insertSelective(OrdOdPersonInfo ordOdPersonInfo) {
		MapperFactory.getOrdOdPersonInfoMapper().insertSelective(ordOdPersonInfo);
	}

}
