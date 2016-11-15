package com.ai.yc.order.service.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ai.opt.sdk.components.ses.SESClientFactory;
import com.ai.paas.ipaas.search.ISearchClient;
import com.ai.paas.ipaas.search.vo.Result;
import com.ai.paas.ipaas.search.vo.SearchCriteria;
import com.ai.paas.ipaas.search.vo.Sort;
import com.ai.yc.order.constants.SearchConstants;
import com.ai.yc.order.search.bo.OrderInfo;
import com.ai.yc.order.service.business.interfaces.IOrderWaitReceiveBusiSV;

@Service
public class OrderWaitReceiveBusiSVImpl implements IOrderWaitReceiveBusiSV {
	@Override
	public Result<OrderInfo> search(List<SearchCriteria> searchCriterias, int from, int offset, List<Sort> sorts) {
		ISearchClient searchClient = SESClientFactory.getSearchClient(SearchConstants.SearchNameSpace);
		return searchClient.search(searchCriterias, from, offset, sorts, OrderInfo.class);
	}
}
