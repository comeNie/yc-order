package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.yc.order.dao.mapper.bo.OrdReceiveTask;
import com.ai.yc.order.dao.mapper.bo.OrdReceiveTaskCriteria;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdReceiveTaskAtomSV;
@Component
public class OrdReceiveTaskAtomSVImpl implements IOrdReceiveTaskAtomSV{

	@Override
	public OrdReceiveTask findByOrderId(Long orderId) {
		OrdReceiveTaskCriteria example = new OrdReceiveTaskCriteria();
		OrdReceiveTaskCriteria.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<OrdReceiveTask> ordBanlances = MapperFactory.getOrdReceiveTaskMapper().selectByExample(example);
		if (CollectionUtil.isEmpty(ordBanlances)) {
			return null;
		}
		return ordBanlances.get(0);
	}

}
