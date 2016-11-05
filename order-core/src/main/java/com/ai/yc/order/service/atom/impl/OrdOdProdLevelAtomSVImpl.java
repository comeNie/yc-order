package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.bo.OrdOdProdLevel;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdLevelCriteria;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdLevelAtomSV;
@Component
public class OrdOdProdLevelAtomSVImpl implements IOrdOdProdLevelAtomSV {

	@Override
	public void insertSelective(OrdOdProdLevel ordOdProdLevel) {
		// TODO Auto-generated method stub
		MapperFactory.getOrdOdProdLevelMapper().insertSelective(ordOdProdLevel);
	}

	@Override
	public List<OrdOdProdLevel> findByOrderId(Long orderId) {
		OrdOdProdLevelCriteria example = new OrdOdProdLevelCriteria();
		OrdOdProdLevelCriteria.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		return MapperFactory.getOrdOdProdLevelMapper().selectByExample(example);
	}

}
