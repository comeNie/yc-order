package com.ai.yc.order.dao.mapper.attach;

import java.sql.Timestamp;
import java.util.Map;

public class RecordOrderInfoSqlProvider {
	public String recordOrderCount(Map<String, Object> param) {
		StringBuffer seqBuffer = new StringBuffer();
		seqBuffer
				.append("select fee.currency_unit currencyUnit,sum(fee.plat_fee) platFeeCount,sum(interper_fee) interperFeeCount,sum(total_fee)totalFeeCount "
						+ "from ord_order orders,ord_od_fee_total fee  where orders.order_id=fee.order_id");
		if (param.get("orderId") != null)
			seqBuffer.append(" and orders.order_id = '" + param.get("orderId") + "'");
		Timestamp stateChgTimeStart = param.containsKey("stateChgTimeStart")
				? (Timestamp) param.get("stateChgTimeStart") : null;
		Timestamp stateChgTimeEnd = param.containsKey("stateChgTimeEnd") ? (Timestamp) param.get("stateChgTimeEnd")
				: null;

		if (null != stateChgTimeStart && null != stateChgTimeEnd)
			seqBuffer.append(" and orders.state_chg_time >= '" + stateChgTimeStart + "'");
		seqBuffer.append(" and orders.state_chg_time <= '" + stateChgTimeEnd + "'");
		if (null != stateChgTimeStart && null == stateChgTimeEnd) {
			seqBuffer.append(" and orders.state_chg_time >= '" + stateChgTimeStart + "'");
		}
		if (null == stateChgTimeStart && null != stateChgTimeEnd) {
			seqBuffer.append(" and orders.state_chg_time <= '" + stateChgTimeEnd + "'");
		}
		if (param.get("state") != null)
			seqBuffer.append(" and orders.state = '" + param.get("state") + "'");
		
		if (param.get("interperId") != null)
			seqBuffer.append(" and orders.interper_id = '" + param.get("interperId") + "'");
		
		if (param.get("lspId") != null)
			seqBuffer.append(" and orders.lsp_id = '" + param.get("lspId") + "'");
		
		return seqBuffer.toString();
	}
}
