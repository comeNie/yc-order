package com.ai.yc.order.dao.mapper.attach;

import java.util.Map;

import com.ai.opt.sdk.util.StringUtil;

public class OrdorderCountSqlProvider {
	public String ordOrderCount(Map<String, Object> param) {
        StringBuffer seqBuffer = new StringBuffer();
        seqBuffer.append("select count(*) orderCounts,sum(fee.discount_fee) discountFeeCount,sum(paid_fee) paidFeeCount,sum(adjust_fee)adjustFeeCount "
        		+ " from ord_order orders,ord_od_fee_total fee  where orders.order_id=fee.order_id");
        if (param.get("chlId") != null)
        	seqBuffer.append(" and orders.chl_id = '" + param.get("chlId")+"'");
        String corparId = param.containsKey("corporaId") ? (String) param.get("corporaId") : null;
        if (!StringUtil.isBlank(corparId))
        	seqBuffer.append(" and orders.corpora_id = '" + corparId+"'");
        String userId = param.containsKey("userId") ? (String) param.get("userId") : null;
        if (!StringUtil.isBlank(userId))
        	seqBuffer.append(" and orders.user_id = '" + userId+"'");
        return seqBuffer.toString();
    }

}
