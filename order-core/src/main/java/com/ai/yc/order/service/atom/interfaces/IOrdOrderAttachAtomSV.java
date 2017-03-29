package com.ai.yc.order.service.atom.interfaces;

import java.util.List;

import com.ai.yc.order.dao.mapper.attach.OrdOrderAttach;
import com.ai.yc.order.dao.mapper.attach.OrdOrderCountAttach;
import com.ai.yc.order.dao.mapper.attach.OrdOrderInferperFeeAttach;

public interface IOrdOrderAttachAtomSV {
	 public List<OrdOrderAttach> queryAlocationOrder(String interperId, String receiveState);
	 
	 public OrdOrderInferperFeeAttach queryAlocationInterperFee(long orderId, String receiveState);
	 
	 public OrdOrderCountAttach queryOrderCountInfo(String chlId,String userId,String corporaId);

}
