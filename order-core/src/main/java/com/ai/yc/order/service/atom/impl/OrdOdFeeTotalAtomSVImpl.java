package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotalCriteria;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
@Component
public class OrdOdFeeTotalAtomSVImpl implements IOrdOdFeeTotalAtomSV {

	@Override
	public void insertSelective(OrdOdFeeTotal ordOdFeeTotal) {
		// TODO Auto-generated method stub
		MapperFactory.getOrdOdFeeTotalMapper().insertSelective(ordOdFeeTotal);
	}

	@Override
	public OrdOdFeeTotal findByOrderId(String payFlag, Long orderId) {
		OrdOdFeeTotalCriteria example = new OrdOdFeeTotalCriteria();
		OrdOdFeeTotalCriteria.Criteria  criteria = example.createCriteria();
		criteria.andPayFlagEqualTo(payFlag);
		criteria.andOrderIdEqualTo(orderId);
		List<OrdOdFeeTotal> ordOdFeeTotals = MapperFactory.getOrdOdFeeTotalMapper().selectByExample(example);
		if(CollectionUtil.isEmpty(ordOdFeeTotals)){
			return null;
		}
		return ordOdFeeTotals.get(0);
	}

	@Override
	public void updateByOrderIdSelective(Long orderId, OrdOdFeeTotal record) {
		OrdOdFeeTotalCriteria example = new OrdOdFeeTotalCriteria();
		OrdOdFeeTotalCriteria.Criteria  criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		 MapperFactory.getOrdOdFeeTotalMapper().updateByExampleSelective(record, example);
	}

	@Override
	public OrdOdFeeTotal findByOrderId(Long orderId) {
		OrdOdFeeTotalCriteria example = new OrdOdFeeTotalCriteria();
		OrdOdFeeTotalCriteria.Criteria  criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<OrdOdFeeTotal> ordOdFeeTotals = MapperFactory.getOrdOdFeeTotalMapper().selectByExample(example);
		if(CollectionUtil.isEmpty(ordOdFeeTotals)){
			return null;
		}
		return ordOdFeeTotals.get(0);
	}

}
