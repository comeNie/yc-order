package com.ai.yc.order.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
@Component
public class OrdOdFeeTotalAtomSVImpl implements IOrdOdFeeTotalAtomSV {

	@Override
	public void insertSelective(OrdOdFeeTotal ordOdFeeTotal) {
		// TODO Auto-generated method stub
		MapperFactory.getOrdOdFeeTotalMapper().insertSelective(ordOdFeeTotal);
	}

}
