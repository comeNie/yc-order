package com.ai.yc.order.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.dao.mapper.bo.OrdOrderCriteria;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.dao.mapper.interfaces.OrdOrderMapper;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;

@Component
public class OrdOrderAtomSVImpl implements IOrdOrderAtomSV {

	@Override
	public OrdOrder findByPrimaryKey(OrdOrder ordOrder) {
		OrdOrderMapper ordOrderMapper = MapperFactory.getOrdOrderMapper();

		return ordOrderMapper.selectByPrimaryKey(ordOrder.getOrderId());
	}

	@Override
	public int findOrderCount(OrdOrder ordOrder) {
		OrdOrderMapper ordOrderMapper = MapperFactory.getOrdOrderMapper();
		OrdOrderCriteria example = new OrdOrderCriteria();
		OrdOrderCriteria.Criteria param = example.createCriteria();
		if (!StringUtil.isBlank(ordOrder.getFlag())) {
			param.andFlagEqualTo(ordOrder.getFlag());
		}
		if (!StringUtil.isBlank(ordOrder.getTimeZone())) {
			param.andTimeZoneEqualTo(ordOrder.getTimeZone());
		}
		if (!StringUtil.isBlank(ordOrder.getUserType())) {
			param.andUserTypeEqualTo(ordOrder.getUserType());
		}
		if (!StringUtil.isBlank(ordOrder.getUserId())) {
			param.andUserIdEqualTo(ordOrder.getUserId());
		}
		if (!StringUtil.isBlank(ordOrder.getSubFlag())) {
			param.andSubFlagEqualTo(ordOrder.getSubFlag());
		}

		if (!StringUtil.isBlank(ordOrder.getChlId())) {
			param.andChlIdEqualTo(ordOrder.getChlId());
		}

		if (!StringUtil.isBlank(ordOrder.getOrderType())) {
			param.andOrderTypeEqualTo(ordOrder.getOrderType());
		}
		if (!StringUtil.isBlank(ordOrder.getOrderLevel())) {
			param.andOrderLevelEqualTo(ordOrder.getOrderLevel());
		}

		if (!StringUtil.isBlank(ordOrder.getTranslateType())) {
			param.andTranslateTypeEqualTo(ordOrder.getTranslateType());
		}
		if (!StringUtil.isBlank(ordOrder.getCorporaId())) {
			param.andCorporaIdEqualTo(ordOrder.getCorporaId());
		}

		if (!StringUtil.isBlank(ordOrder.getState())) {
			param.andStateEqualTo(ordOrder.getState());
		}

		if (!StringUtil.isBlank(ordOrder.getDisplayFlag())) {
			param.andDisplayFlagEqualTo(ordOrder.getDisplayFlag());
		}
		if (!StringUtil.isBlank(ordOrder.getInterperId())) {
			param.andInterperIdEqualTo(ordOrder.getInterperId());
		}
		if (!StringUtil.isBlank(ordOrder.getInterperType())) {
			param.andInterperTypeEqualTo(ordOrder.getInterperType());
		}

		if (ordOrder.getLspId() != null) {
			param.andLspIdEqualTo(ordOrder.getLspId());
		}
		return ordOrderMapper.countByExample(example);
	}

}
