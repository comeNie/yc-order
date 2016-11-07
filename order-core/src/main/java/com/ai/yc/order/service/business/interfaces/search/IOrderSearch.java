package com.ai.yc.order.service.business.interfaces.search;

import com.ai.paas.ipaas.search.vo.Result;
import com.ai.yc.order.search.dto.OrderSearchCriteria;

import java.util.Map;

public interface IOrderSearch {
    Result<Map<String, Object>> search(OrderSearchCriteria criteria);

}
