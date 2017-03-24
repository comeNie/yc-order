package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.attach.OrdOrderAttach;
import com.ai.yc.order.dao.mapper.attach.OrdOrderAttachMapper;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAttachAtomSV;
@Component
public class OrdOrderAttachAtomSVImpl implements IOrdOrderAttachAtomSV {
	 @Autowired
	 private  OrdOrderAttachMapper ordOrderAttachMapper;
	@Override
	public List<OrdOrderAttach> queryAlocationOrder(String interperId, String receiveState) {
		return ordOrderAttachMapper.getAllocationOrdOrder(interperId, receiveState);
	}

}
