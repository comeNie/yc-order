package com.ai.yc.order.service.atom.interfaces;

import java.util.List;

import com.ai.yc.order.dao.mapper.attach.OrdOrderAttach;

public interface IOrdOrderAttachAtomSV {
	 public List<OrdOrderAttach> queryAlocationOrder(String interperId, String receiveState);

}
