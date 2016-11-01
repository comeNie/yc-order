package com.ai.yc.order.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdOrderBusiSV;
@Service
public class OrdOrderBusiSVImpl implements IOrdOrderBusiSV {

	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Override
	public OrdOrder findByPrimaryKey(OrdOrder ordOrder) {
		return this.ordOrderAtomSV.findByPrimaryKey(ordOrder);
	}

}
