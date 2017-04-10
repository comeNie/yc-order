package com.ai.yc.order.service.atom.interfaces;

import java.util.List;

import com.ai.yc.order.dao.mapper.attach.OrdOrderCountAttach;
import com.ai.yc.order.dao.mapper.attach.OrdOrderHFCountAttach;
import com.ai.yc.order.dao.mapper.attach.OrdOrderInferperFeeAttach;

public interface IOrdOrderAttachAtomSV {
	//用于查询lsp待领取订单
	 public List<Object> queryAlocationOrder(String interperId, String receiveState);
	 
	 public OrdOrderInferperFeeAttach queryAlocationInterperFee(long orderId, String receiveState);
	 
	 public OrdOrderCountAttach queryOrderCountInfo(String chlId,String userId,String corporaId);
	 
	 public OrdOrderHFCountAttach queryOrderCountHFInfo(String chlId,String userId,String corporaId);

}
