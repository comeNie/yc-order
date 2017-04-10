package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.yc.order.dao.mapper.bo.OrdOdReceive;
import com.ai.yc.order.dao.mapper.bo.OrdOdReceiveCriteria;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdReceiveAtomSV;
@Component
public class OrdOdReceiveAtomSVImpl implements IOrdOdReceiveAtomSV{

	@Override
	public int insertByPrimaryKeySelective(OrdOdReceive record) {
		return MapperFactory.getOrdOdReceiveMapper().insertSelective(record);
	}

	@Override
	public List<OrdOdReceive> findByFollowId(long followId) {
		OrdOdReceiveCriteria example = new OrdOdReceiveCriteria();
		OrdOdReceiveCriteria.Criteria criteria = example.createCriteria();
		criteria.andReceiveFollowIdEqualTo(followId);
		List<OrdOdReceive> ordOdReceives = MapperFactory.getOrdOdReceiveMapper().selectByExample(example);
		if(CollectionUtil.isEmpty(ordOdReceives)){
			return null;
		}
		return ordOdReceives;
	}

}
