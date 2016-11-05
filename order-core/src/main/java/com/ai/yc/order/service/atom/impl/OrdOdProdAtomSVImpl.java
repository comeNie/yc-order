package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdCriteria;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdWithBLOBs;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
@Component
public class OrdOdProdAtomSVImpl implements IOrdOdProdAtomSV {

	@Override
	public void insertSelective(OrdOdProdWithBLOBs ordOdProdWithBLOBs) {
		MapperFactory.getOrdOdProdMapper().insertSelective(ordOdProdWithBLOBs);
	}

	@Override
	public OrdOdProdWithBLOBs findByOrderId(Long orderId) {
		OrdOdProdCriteria example = new OrdOdProdCriteria();
		OrdOdProdCriteria.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<OrdOdProdWithBLOBs> ordOdProds = MapperFactory.getOrdOdProdMapper().selectByExampleWithBLOBs(example);
		if(CollectionUtil.isEmpty(ordOdProds)){
			return null;
		}
		return ordOdProds.get(0);
	}
	
}
