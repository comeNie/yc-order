package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.yc.order.dao.mapper.bo.OrdOdLogistics;
import com.ai.yc.order.dao.mapper.bo.OrdOdLogisticsCriteria;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdLogisticsAtomSV;
@Component
public class OrdOdLogisticsAtomSVImpl implements IOrdOdLogisticsAtomSV {

	@Override
	public void insertSelective(OrdOdLogistics ordOdLogistics) {
		MapperFactory.getOrdOdLogisticsMapper().insertSelective(ordOdLogistics);
	}

	@Override
	public OrdOdLogistics findByOrderId(Long orderId) {
		OrdOdLogisticsCriteria example = new OrdOdLogisticsCriteria();
		OrdOdLogisticsCriteria.Criteria  criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<OrdOdLogistics>  logistics = MapperFactory.getOrdOdLogisticsMapper().selectByExample(example);
		if(CollectionUtil.isEmpty(logistics)){
			return null;
		}else{
			return logistics.get(0);
		}
	}

}
