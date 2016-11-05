package com.ai.yc.order.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.bo.OrdOdLogistics;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdLogisticsAtomSV;
@Component
public class OrdOdLogisticsAtomSVImpl implements IOrdOdLogisticsAtomSV {

	@Override
	public void insertSelective(OrdOdLogistics ordOdLogistics) {
		// TODO Auto-generated method stub
		MapperFactory.getOrdOdLogisticsMapper().insertSelective(ordOdLogistics);
	}

}
