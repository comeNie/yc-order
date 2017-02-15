package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.yc.order.dao.mapper.bo.OrdEvaluate;
import com.ai.yc.order.dao.mapper.bo.OrdEvaluateCriteria;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdEvaluateAtomSV;
@Component
public class OrdEvaluateAtomSVImpl implements IOrdEvaluateAtomSV {

	@Override
	public OrdEvaluate findByOrderId(Long orderId) {
		OrdEvaluateCriteria example = new OrdEvaluateCriteria();
		OrdEvaluateCriteria.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<OrdEvaluate> ordEvaluate = MapperFactory.getOrdEvaluateMapper().selectByExample(example);
		if (CollectionUtil.isEmpty(ordEvaluate)) {
			return null;
		}
		return ordEvaluate.get(0);
	}

}
