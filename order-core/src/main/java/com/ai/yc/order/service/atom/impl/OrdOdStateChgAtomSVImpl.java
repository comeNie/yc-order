package com.ai.yc.order.service.atom.impl;

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
		//门户前端不需要显示org_state为11、12、13的轨迹信息
		criteria.andOrgStateNotEqualTo(OrdersConstants.OrderState.STATE_WAIT_PAY);
		criteria.andOrgStateNotEqualTo(OrdersConstants.OrderState.STATE_PAIED);
		criteria.andOrgStateNotEqualTo(OrdersConstants.OrderState.STATE_WAIT_OFFER);
		
		return MapperFactory.getOrdOdStateChgMapper().selectByExample(example);
	}

}
