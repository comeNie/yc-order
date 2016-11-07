package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChgCriteria;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdStateChgAtomSV;
@Component
public class OrdOdStateChgAtomSVImpl implements IOrdOdStateChgAtomSV {

	@Override
	public List<OrdOdStateChg> findByOrderId(Long orderId) {
		OrdOdStateChgCriteria example = new OrdOdStateChgCriteria();
		OrdOdStateChgCriteria.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		return MapperFactory.getOrdOdStateChgMapper().selectByExample(example);
	}

	@Override
	public void insertSelective(OrdOdStateChg ordOdStateChg) {
		// TODO Auto-generated method stub
		MapperFactory.getOrdOdStateChgMapper().insertSelective(ordOdStateChg);
	}

}
