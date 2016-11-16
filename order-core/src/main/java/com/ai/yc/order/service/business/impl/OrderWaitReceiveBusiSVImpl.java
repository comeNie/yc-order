package com.ai.yc.order.service.business.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.components.ses.SESClientFactory;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.paas.ipaas.search.ISearchClient;
import com.ai.paas.ipaas.search.vo.Result;
import com.ai.paas.ipaas.search.vo.SearchCriteria;
import com.ai.paas.ipaas.search.vo.SearchOption;
import com.ai.paas.ipaas.search.vo.Sort;
import com.ai.paas.ipaas.search.vo.Sort.SortOrder;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.yc.order.api.orderquery.param.OrdProdExtendVo;
import com.ai.yc.order.api.orderreceivesearch.param.OrderWaitReceiveSearchInfo;
import com.ai.yc.order.api.orderreceivesearch.param.OrderWaitReceiveSearchRequest;
import com.ai.yc.order.api.orderreceivesearch.param.OrderWaitReceiveSearchResponse;
import com.ai.yc.order.constants.SearchConstants;
import com.ai.yc.order.constants.SearchFieldConfConstants;
import com.ai.yc.order.search.bo.OrdProdExtend;
import com.ai.yc.order.search.bo.OrderInfo;
import com.ai.yc.order.service.business.interfaces.IOrderWaitReceiveBusiSV;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

@Service
public class OrderWaitReceiveBusiSVImpl implements IOrderWaitReceiveBusiSV {
	/**
	 * 升序
	 */
	private static final String FLAG_ASC = "0";
	/**
	 * 降序
	 */
	private static final String FLAG_DESC = "1";
	/**
	 * 发布时间
	 */
	private static final String FIELD_0 = "0";
	/**
	 * 剩余时间
	 */
	private static final String FIELD_1 = "1";
	/**
	 * 订单金额
	 */
	private static final String FIELD_2 = "2";
	@Override
	public Result<OrderInfo> search(List<SearchCriteria> searchCriterias, int from, int offset, List<Sort> sorts) {
		ISearchClient searchClient = SESClientFactory.getSearchClient(SearchConstants.SearchNameSpace);
		return searchClient.search(searchCriterias, from, offset, sorts, OrderInfo.class);
	}

	@Override
	public OrderWaitReceiveSearchResponse pageSearchWaitReceive(OrderWaitReceiveSearchRequest request) {
		// TODO Auto-generated method stub
		// request.setTenantId(OrdersConstants.TENANT_ID);
		// 有效性校验
		// ValidateUtils.validateQueryOrder(request);
		// 调用搜索引擎进行查询
		int startSize = 1;
		int maxSize = 1;
		// 最大条数设置
		int pageNo = request.getPageNo();
		int size = request.getPageSize();
		if (request.getPageNo() == 1) {
			startSize = 0;
		} else {
			startSize = (pageNo - 1) * size;
		}
		maxSize = size;
		OrderWaitReceiveSearchResponse response = new OrderWaitReceiveSearchResponse();
		//
		PageInfo<OrderWaitReceiveSearchInfo> pageinfo = new PageInfo<OrderWaitReceiveSearchInfo>();

		List<OrderWaitReceiveSearchInfo> results = new ArrayList<OrderWaitReceiveSearchInfo>();
		//

		List<SearchCriteria> orderSearchCriteria = commonConditions(request);
		List<Sort> sortList = new ArrayList<Sort>();
		// Sort sort = new Sort("ordertime", SortOrder.DESC);
		SortOrder sortFlagEn = SortOrder.ASC;
		//
		if (FLAG_ASC.equals(request.getSortFlag())) {
			sortFlagEn = SortOrder.ASC;
		}
		if (FLAG_DESC.equals(request.getSortFlag())) {
			sortFlagEn = SortOrder.DESC;
		}
		Sort sort = new Sort("starttime", SortOrder.DESC);
		// 发布时间字段
		if (FIELD_0.equals(request.getSortField())) {
			sort = new Sort("starttime", sortFlagEn);
		}
		// 剩余时间
		if (FIELD_1.equals(request.getSortField())) {
			sort = new Sort("takeday", sortFlagEn);
			Sort sortTakeTime = new Sort("taketime", sortFlagEn);
			//
			sortList.add(sortTakeTime);
		}
		// 订单金额
		if (FIELD_2.equals(request.getSortField())) {
			sort = new Sort("totalfee", sortFlagEn);
		}
		sortList.add(sort);
		//
		Result<OrderInfo> result = this.search(orderSearchCriteria, startSize, maxSize,
				sortList);
		List<OrderInfo> ordList = result.getContents();
		if (!CollectionUtil.isEmpty(ordList)) {
			for (OrderInfo ord : ordList) {
				OrderWaitReceiveSearchInfo order = new OrderWaitReceiveSearchInfo();

				// 订单id
				order.setOrderId(Long.valueOf(ord.getOrderid()));
				order.setFlag(ord.getFlag());
				order.setOrderLevel(ord.getOrderlevel());
				order.setTotalFee(ord.getTotalfee());
				order.setTranslateName(ord.getTranslatename());
				order.setTranslateType(ord.getTranslatetype());
				order.setTakeDay(ord.getTakeday());
				order.setTakeTime(ord.getTaketime());
				//
				if (ord.getOrdertime() != null) {
					order.setOrderTime(new Timestamp(ord.getOrdertime().getTime()));
				}
				if (ord.getPaytime() != null) {
					order.setPayTime(new Timestamp(ord.getPaytime().getTime()));
				}

				// 获取语言对名称
				String extendInfos = JSON.toJSONString(ord.getOrdextendes());
				List<OrdProdExtend> extendList = JSON.parseObject(extendInfos,
						new TypeReference<List<OrdProdExtend>>() {
						});
				if (!CollectionUtil.isEmpty(extendList)) {
					//
					order.setLanguagePair(extendList.get(0).getLangungeid());
					order.setLanguagePairName(extendList.get(0).getLangungechname());
					order.setLanguageNameEn(extendList.get(0).getLangungeenname());
				}

				results.add(order);
			}
		}
		pageinfo.setResult(results);
		pageinfo.setPageSize(request.getPageSize());
		pageinfo.setPageNo(request.getPageNo());
		pageinfo.setCount(new Long(result.getCount()).intValue());
		response.setPageInfo(pageinfo);
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "订单查询成功");
		response.setResponseHeader(responseHeader);
		return response;
	}

	// 搜索引擎数据公共查询条件
	public List<SearchCriteria> commonConditions(OrderWaitReceiveSearchRequest request) {
		List<SearchCriteria> searchfieldVos = new ArrayList<SearchCriteria>();
		/**
		 * 如果业务标识不为空
		 */
		if (!StringUtil.isBlank(request.getFlag())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.FLAG, request.getFlag(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));

		}
		/**
		 * 译员等级
		 */
		if (!StringUtil.isBlank(request.getInterperLevel())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.ORDER_LEVEL, request.getInterperLevel(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));

		}

		// 如果翻译类型不为空 不等于2的情况
		// if (!StringUtil.isBlank(request.getTranslateType())) {
		searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.TRANSLATE_TYPE, "2",
				new SearchOption(SearchOption.SearchLogic.must_not, SearchOption.SearchType.querystring)));
		// }
		// 如果翻译主题不为空
		if (!StringUtil.isBlank(request.getTranslateName())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.TRANSLATE_NAME, request.getTranslateName(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		
		// 如果state不为空
		if (!StringUtil.isBlank(request.getState())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.STATE, request.getState(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}

		// 如果译员类型不为空
		if (!StringUtil.isBlank(request.getInterperType())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.INTERPER_TYPE, request.getInterperType(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}

		// 如果用途id不为空
		if (!StringUtil.isBlank(request.getUseCode())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.USE_CODE, request.getUseCode(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果领域id不为空
		if (!StringUtil.isBlank(request.getFieldCode())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.FIELD_CODE, request.getFieldCode(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}

		// 产品表中开始时间字段区间查询 stateTime
		if (null != request.getStartStateTime() && null != request.getEndStateTime()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ");
			String start = sdf.format(request.getStartStateTime());
			String end = sdf.format(request.getEndStateTime());
			SearchCriteria searchCriteria = new SearchCriteria();
			searchCriteria.setOption(new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.range));
			searchCriteria.setField(SearchFieldConfConstants.STATE_TIME);
			searchCriteria.addFieldValue(start);
			searchCriteria.addFieldValue(end);
			searchfieldVos.add(searchCriteria);
		}

		return searchfieldVos;
	}
}
