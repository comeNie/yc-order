package com.ai.yc.order.dao.mapper.attach;

import java.util.Map;
public class OrdInterperQuerySqlProvider {
	public String interperQueryOrdOrder(Map<String, Object> param) {
        StringBuffer seqBuffer = new StringBuffer();
        seqBuffer.append("select follow.order_id from ord_od_receive receive,ord_od_receive_follow follow  where receive.receive_follow_id=follow.receive_follow_id");
        if (param.get("interperId") != null)
        	seqBuffer.append(" and receive.interper_id = '" + param.get("interperId")+"'");
        return seqBuffer.toString();
    }
}
