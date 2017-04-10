package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
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
	public List<OrdOdReceiveFollow> findByOrderId(long orderId) {
		OrdOdReceiveFollowCriteria example = new OrdOdReceiveFollowCriteria();
		OrdOdReceiveFollowCriteria.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<OrdOdReceiveFollow> ordOdFollows = MapperFactory.getOrdOdReceiveFollowMapper().selectByExample(example);
		if(CollectionUtil.isEmpty(ordOdFollows)){
			return null;
		}
		return ordOdFollows;
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
	public List<OrdOdReceiveFollow> findByOrderAndState(long orderId, String recerveState) {
		OrdOdReceiveFollowCriteria example = new OrdOdReceiveFollowCriteria();
		OrdOdReceiveFollowCriteria.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		criteria.andReceiveStateEqualTo(recerveState);
		List<OrdOdReceiveFollow> ordOdFollows = MapperFactory.getOrdOdReceiveFollowMapper().selectByExample(example);
		if(CollectionUtil.isEmpty(ordOdFollows)){
			return null;
		}
		return ordOdFollows;
	}

	@Override
	public OrdOdReceiveFollow find(OrdOdReceiveFollow ordOdReceiveFollow) {
		OrdOdReceiveFollowCriteria example = new OrdOdReceiveFollowCriteria();
		OrdOdReceiveFollowCriteria.Criteria criteria = example.createCriteria();
		if(null!=ordOdReceiveFollow.getOrderId()){
			criteria.andOrderIdEqualTo(ordOdReceiveFollow.getOrderId());
		}
		if(!StringUtil.isBlank(ordOdReceiveFollow.getReceiveState())){
			criteria.andReceiveStateEqualTo(ordOdReceiveFollow.getReceiveState());
		}
		if(!StringUtil.isBlank(ordOdReceiveFollow.getStep())){
			criteria.andStepEqualTo(ordOdReceiveFollow.getStep());
		}
		if(!StringUtil.isBlank(ordOdReceiveFollow.getOperType())){
			criteria.andOperTypeEqualTo(ordOdReceiveFollow.getOperType());
		}
		if(!StringUtil.isBlank(ordOdReceiveFollow.getFinishState())){
			criteria.andFinishStateEqualTo(ordOdReceiveFollow.getFinishState());
		}
		List<OrdOdReceiveFollow> ordOdFollows = MapperFactory.getOrdOdReceiveFollowMapper().selectByExample(example);
		if(CollectionUtil.isEmpty(ordOdFollows)){
			return null;
		}
		return ordOdFollows.get(0);
	}
}
