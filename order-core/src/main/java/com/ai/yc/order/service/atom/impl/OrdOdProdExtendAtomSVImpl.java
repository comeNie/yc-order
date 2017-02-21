package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.bo.OrdOdProdExtend;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdExtendCriteria;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdExtendAtomSV;

@Component
public class OrdOdProdExtendAtomSVImpl implements IOrdOdProdExtendAtomSV {

	@Override
	public void insertSelective(OrdOdProdExtend ordOdProdExtend) {
	
		MapperFactory.getOrdOdProdExtendMapper().insertSelective(ordOdProdExtend);
	}

	@Override
	public List<OrdOdProdExtend> findByOrderId(Long orderId) {
		OrdOdProdExtendCriteria example = new OrdOdProdExtendCriteria();
		OrdOdProdExtendCriteria.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<OrdOdProdExtend> ordOdProdExtends = MapperFactory.getOrdOdProdExtendMapper().selectByExample(example);
		return ordOdProdExtends;
	}
	
	

}
