package com.ai.yc.order.dao.mapper.attach;

import java.util.Map;

import com.ai.opt.sdk.util.StringUtil;
public class OrdOrderAllocationSqlProvider {
	public String allocationQueryOrdOrder(Map<String, Object> param) {
        StringBuffer seqBuffer = new StringBuffer();
        seqBuffer.append("select  person.interper_id,person.interper_name,person.interper_fee,person.tel,person.remark,person.creart_time,"
        		+ "person.expect_end_time,person.person_id,follow.receive_state,follow.finish_state,follow.step,follow.oper_type,follow.order_id"
        		+ " from ord_od_person_info person,ord_od_receive_follow follow  where person.receive_follow_id=follow.receive_follow_id");
        if (param.get("receiveState") != null)
        	seqBuffer.append(" and follow.receive_state = '" + param.get("receiveState")+"'");
        String interperId = param.containsKey("interperId") ? (String) param.get("interperId") : null;
        if (!StringUtil.isBlank(interperId))
        	seqBuffer.append(" and person.interper_id = '" + interperId+"'");
        return seqBuffer.toString();
    }
}
