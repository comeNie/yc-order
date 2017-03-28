package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.yc.order.dao.mapper.bo.OrdOdReceiveFollow;
import com.ai.yc.order.dao.mapper.bo.OrdOdReceiveFollowCriteria;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdReceiveFollowAtomSV;
@Component
public class OrdOdReceiveFollowAtomSVImpl implements IOrdOdReceiveFollowAtomSV {
	@Override
	public void insertSelective(OrdOdReceiveFollow ordOdReceiveFollow) {
		MapperFactory.getOrdOdReceiveFollowMapper().insertSelective(ordOdReceiveFollow);
	}

	@Override
	public OrdOdReceiveFollow findByOrderId(long orderId) {
		OrdOdReceiveFollowCriteria example = new OrdOdReceiveFollowCriteria();
		OrdOdReceiveFollowCriteria.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<OrdOdReceiveFollow> ordOdFollows = MapperFactory.getOrdOdReceiveFollowMapper().selectByExample(example);
		if(CollectionUtil.isEmpty(ordOdFollows)){
			return null;
		}
		return ordOdFollows.get(0);
	}

	@Override
	public OrdOdReceiveFollow findByRecerveState(String recerveState) {
		OrdOdReceiveFollowCriteria example = new OrdOdReceiveFollowCriteria();
		OrdOdReceiveFollowCriteria.Criteria criteria = example.createCriteria();
		criteria.andReceiveStateEqualTo(recerveState);
		List<OrdOdReceiveFollow> ordOdFollows = MapperFactory.getOrdOdReceiveFollowMapper().selectByExample(example);
		if(CollectionUtil.isEmpty(ordOdFollows)){
			return null;
		}
		return ordOdFollows.get(0);
	}

	@Override
	public void updateSelective(OrdOdReceiveFollow ordOdReceiveFollow) {
		MapperFactory.getOrdOdReceiveFollowMapper().updateByPrimaryKeySelective(ordOdReceiveFollow);
	}

	@Override
	public OrdOdReceiveFollow findByOrderAndStep(long orderId, String step, String recerveState) {
		OrdOdReceiveFollowCriteria example = new OrdOdReceiveFollowCriteria();
		OrdOdReceiveFollowCriteria.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		criteria.andStepEqualTo(step);
		criteria.andReceiveStateEqualTo(recerveState);
		List<OrdOdReceiveFollow> ordOdFollows = MapperFactory.getOrdOdReceiveFollowMapper().selectByExample(example);
		if(CollectionUtil.isEmpty(ordOdFollows)){
			return null;
		}
		return ordOdFollows.get(0);
	}
}
