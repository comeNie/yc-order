package com.ai.yc.order.service.atom.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.constants.OrdersConstants;
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
	
	@Override
	public List<OrdOdStateChg> findByOrderIdAndFlag(Long orderId,String flag) {
		OrdOdStateChgCriteria example = new OrdOdStateChgCriteria();
		OrdOdStateChgCriteria.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		if(flag != null && !StringUtil.isBlank(flag)){
			criteria.andFlagEqualTo(flag);
		}
		return MapperFactory.getOrdOdStateChgMapper().selectByExample(example);
	}
	@Override
	public List<OrdOdStateChg> findByOrderIdAndFlag4Portal(Long orderId,String flag) {
		OrdOdStateChgCriteria example = new OrdOdStateChgCriteria();
		OrdOdStateChgCriteria.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		if(flag != null && !StringUtil.isBlank(flag)){
			criteria.andFlagEqualTo(flag);
		}
		//门户前端我是服务方（译员）的订单轨迹显示如下的轨迹信息
		if(StringUtil.isBlank(flag)){
			List<String> orgStateList=new ArrayList<String>();
			orgStateList.add(OrdersConstants.OrderState.STATE_COMMIT);
			orgStateList.add(OrdersConstants.OrderState.STATE_RECEIVED);
			orgStateList.add(OrdersConstants.OrderState.STATE_TRASLATING);
			orgStateList.add(OrdersConstants.OrderState.STATE_TRASLATE_FINISHED);
			orgStateList.add(OrdersConstants.OrderState.WAIT_REVIEW_STATE);
			orgStateList.add(OrdersConstants.OrderState.REVIEWED_STATE);
			orgStateList.add(OrdersConstants.OrderState.REVIEW_FAILD_STATE);
			orgStateList.add(OrdersConstants.OrderState.WAIT_OK_STATE);
			orgStateList.add(OrdersConstants.OrderState.WAIT_COMMENT_STATE);
			orgStateList.add(OrdersConstants.OrderState.FLAG_FINISHED);
			criteria.andOrgStateIn(orgStateList);
		}
		return MapperFactory.getOrdOdStateChgMapper().selectByExample(example);
	}

}
