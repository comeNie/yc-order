package com.ai.yc.order.service.atom.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdReceiveTask;

public interface IOrdReceiveTaskAtomSV {
	OrdReceiveTask findByOrderId(Long orderId);

}
