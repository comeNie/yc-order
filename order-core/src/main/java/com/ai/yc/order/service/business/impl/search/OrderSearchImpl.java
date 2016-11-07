package com.ai.yc.order.service.business.impl.search;

import com.ai.opt.sdk.components.ses.SESClientFactory;
import com.ai.paas.ipaas.search.ISearchClient;
import com.ai.paas.ipaas.search.vo.Result;
import com.ai.yc.order.constants.SearchConstants;
import com.ai.yc.order.search.bo.OrderInfo;
import com.ai.yc.order.search.dto.OrderSearchCriteria;
import com.ai.yc.order.service.business.interfaces.search.IOrderSearch;

public class OrderSearchImpl implements IOrderSearch {

	@Override
	public Result search(OrderSearchCriteria criteria) {
		ISearchClient searchClient = SESClientFactory.getSearchClient(SearchConstants.SearchNameSpace);
		return searchClient.search(criteria.getSearchfieldVos(), criteria.getStartSize(), criteria.getMaxSearchSize(),
				criteria.getSortFields(), OrderInfo.class);
	}
}
