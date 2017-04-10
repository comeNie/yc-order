package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.attach.OrdOrderAttachMapper;
import com.ai.yc.order.dao.mapper.attach.OrdOrderCountAttach;
import com.ai.yc.order.dao.mapper.attach.OrdOrderHFCountAttach;
import com.ai.yc.order.dao.mapper.attach.OrdOrderInferperFeeAttach;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAttachAtomSV;
@Component
public class OrdOrderAttachAtomSVImpl implements IOrdOrderAttachAtomSV {
	 @Autowired
	 private  OrdOrderAttachMapper ordOrderAttachMapper;
	@Override
	public List<Object> queryAlocationOrder(String interperId, String receiveState) {
		return ordOrderAttachMapper.getAllocationOrdOrder(interperId, receiveState);
	}
	@Override
	public OrdOrderInferperFeeAttach queryAlocationInterperFee(long orderId, String receiveState) {
		
		return ordOrderAttachMapper.getAllocationOrdOrderFee(orderId, receiveState);
	}
	@Override
	public OrdOrderCountAttach queryOrderCountInfo(String chlId, String userId, String corporaId) {
		return ordOrderAttachMapper.getOrdOrderCount(chlId, userId, corporaId);
	}
	@Override
	public OrdOrderHFCountAttach queryOrderCountHFInfo(String chlId, String userId, String corporaId) {
		return ordOrderAttachMapper.getOrdOrderHFCount(chlId, userId, corporaId);
	}

}
