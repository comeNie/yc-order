package com.ai.yc.order.service.atom.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.yc.order.dao.mapper.bo.OrdOdProd;
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

	@Override
	public void updateByOrderIdSelective(OrdOdProdWithBLOBs ordOdProdWithBLOBs,
			Long orderId) {
		OrdOdProdCriteria example = new OrdOdProdCriteria();
		OrdOdProdCriteria.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		MapperFactory.getOrdOdProdMapper().updateByExampleSelective(ordOdProdWithBLOBs, example);
		
	}

	@Override
	public List<OrdOdProd> findByOrdersAndEndTime(List<Long> orderIds,Timestamp endTime) {
		// TODO Auto-generated method stub
		OrdOdProdCriteria example = new OrdOdProdCriteria();
		OrdOdProdCriteria.Criteria criteria = example.createCriteria();
		criteria.andOrderIdIn(orderIds);
		criteria.andEndTimeLessThanOrEqualTo(endTime);
		//
		return MapperFactory.getOrdOdProdMapper().selectByExample(example);
		
	}
	
}
