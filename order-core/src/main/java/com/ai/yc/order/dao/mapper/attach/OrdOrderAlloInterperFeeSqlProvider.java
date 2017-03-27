package com.ai.yc.order.dao.mapper.attach;

import java.util.Map;

public class OrdOrderAlloInterperFeeSqlProvider {
	public String allocationQueryOrdOrderFee(Map<String, Object> param) {
        StringBuffer seqBuffer = new StringBuffer();
        seqBuffer.append("select sum(receive.interper_fee) sum_interper_fee"
        		+ " from ord_od_receive receive,ord_od_receive_follow follow  where receive.receive_follow_id=follow.receive_follow_id");
        if (param.get("receiveState") != null)
        	seqBuffer.append(" and follow.receive_state = '" + param.get("receiveState")+"'");
        if (param.get("orderId") != null)
            seqBuffer.append(" and follow.order_id = " + param.get("orderId"));
        return seqBuffer.toString();
    }
}
