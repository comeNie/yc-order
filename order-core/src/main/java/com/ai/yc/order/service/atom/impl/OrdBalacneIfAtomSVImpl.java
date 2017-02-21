package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.yc.order.dao.mapper.bo.OrdBalacneIf;
import com.ai.yc.order.dao.mapper.bo.OrdBalacneIfCriteria;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdBalacneIfAtomSV;

@Component
public class OrdBalacneIfAtomSVImpl implements IOrdBalacneIfAtomSV {

	@Override
	public OrdBalacneIf findByOrderId(Long orderId) {
		OrdBalacneIfCriteria example = new OrdBalacneIfCriteria();
		OrdBalacneIfCriteria.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<OrdBalacneIf> ordBanlances = MapperFactory.getOrdBalacneIfMapper().selectByExample(example);
		if (CollectionUtil.isEmpty(ordBanlances)) {
			return null;
		}
		return ordBanlances.get(0);
	}

	@Override
	public void insertSelective(OrdBalacneIf ordBalacneIf) {

		MapperFactory.getOrdBalacneIfMapper().insertSelective(ordBalacneIf);
	}

}
