package com.ai.yc.order.service.business.interfaces;

import java.util.List;

import com.ai.paas.ipaas.search.vo.Result;
import com.ai.paas.ipaas.search.vo.SearchCriteria;
import com.ai.paas.ipaas.search.vo.Sort;
import com.ai.yc.order.api.orderreceivesearch.param.OrderWaitReceiveSearchRequest;
import com.ai.yc.order.api.orderreceivesearch.param.OrderWaitReceiveSearchResponse;
import com.ai.yc.order.search.bo.OrderInfo;

public interface IOrderWaitReceiveBusiSV {
	public Result<OrderInfo> search(List<SearchCriteria> searchCriterias, int from, int offset, List<Sort> sorts);
	public OrderWaitReceiveSearchResponse pageSearchWaitReceive(OrderWaitReceiveSearchRequest request);
}
