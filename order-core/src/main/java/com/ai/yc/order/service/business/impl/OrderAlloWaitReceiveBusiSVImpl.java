package com.ai.yc.order.service.business.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.paas.ipaas.search.vo.Result;
import com.ai.paas.ipaas.search.vo.SearchCriteria;
import com.ai.paas.ipaas.search.vo.SearchOption;
import com.ai.paas.ipaas.search.vo.Sort;
import com.ai.paas.ipaas.search.vo.Sort.SortOrder;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationSearchInfo;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationSearchRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationSearchResponse;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.constants.SearchFieldConfConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOdReceiveFollow;
import com.ai.yc.order.search.bo.OrdProdExtend;
import com.ai.yc.order.search.bo.OrderInfo;
import com.ai.yc.order.service.atom.interfaces.IOrdOdReceiveFollowAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAttachAtomSV;
import com.ai.yc.order.service.business.impl.search.OrderSearchImpl;
import com.ai.yc.order.service.business.interfaces.IOrderAlloWaitReceiveBusiSV;
import com.ai.yc.order.service.business.interfaces.search.IOrderSearch;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
@Service
@Transactional
public class OrderAlloWaitReceiveBusiSVImpl implements IOrderAlloWaitReceiveBusiSV {
	
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
	@Autowired
	private IOrdOrderAttachAtomSV ordOrderAttachAtomSV;
	@Autowired
	private IOrdOdReceiveFollowAtomSV ordOdReceiveFollowAtomSV;
	@Override
	public OrderAllocationSearchResponse pageSearchAlloWaitReceive(OrderAllocationSearchRequest request) {
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
		OrderAllocationSearchResponse response = new OrderAllocationSearchResponse();
		IOrderSearch orderSearch = new OrderSearchImpl();
		PageInfo<OrderAllocationSearchInfo> pageinfo = new PageInfo<OrderAllocationSearchInfo>();

		List<OrderAllocationSearchInfo> results = new ArrayList<OrderAllocationSearchInfo>();
		//获取分配订单id
		List<Object> orderIdlist = ordOrderAttachAtomSV.queryAlocationOrder(request.getInterperId(), OrdersConstants.RECEIVE_STATE);
		if(CollectionUtil.isEmpty(orderIdlist)){
			return response;
		}
		List<SearchCriteria> orderSearchCriteria = commonConditions(request,orderIdlist);
		List<Sort> sortList = new ArrayList<Sort>();
		SortOrder sortFlagEn = SortOrder.ASC;
		//
		if (FLAG_ASC.equals(request.getSortFlag())) {
			sortFlagEn = SortOrder.ASC;
		}
		if (FLAG_DESC.equals(request.getSortFlag())) {
			sortFlagEn = SortOrder.DESC;
		}
		Sort sort = new Sort("ordertime", SortOrder.DESC);
		// 发布时间字段
		if (FIELD_0.equals(request.getSortField())) {
			sort = new Sort("ordertime", sortFlagEn);
		}
		// 剩余时间
		if (FIELD_1.equals(request.getSortField())) {
			sort = new Sort("esendtime", sortFlagEn);
		}
		// 订单金额
		if (FIELD_2.equals(request.getSortField())) {
			sort = new Sort("totalfee", sortFlagEn);
		}
		sortList.add(sort);
		Result<OrderInfo> result = orderSearch.search(orderSearchCriteria, startSize, maxSize, sortList);
		List<OrderInfo> ordList = result.getContents();
		if (!CollectionUtil.isEmpty(ordList)) {
			for (OrderInfo ord : ordList) {
				OrderAllocationSearchInfo order = new OrderAllocationSearchInfo();
				// 订单id
				order.setOrderId(Long.valueOf(ord.getOrderid()));
				order.setTotalFee(ord.getTotalfee());
				order.setTranslateName(ord.getTranslatename());
				//查询任务跟踪信息获取操作类型
				OrdOdReceiveFollow ordOdReceiveFollow = ordOdReceiveFollowAtomSV.findByOrderAndState(Long.valueOf(ord.getOrderid()), OrdersConstants.RECEIVE_STATE);
				if(null!=ordOdReceiveFollow){
					order.setOperType(ordOdReceiveFollow.getOperType());
				}
				if (null != ord.getEsendtime()) {
					order.setEsEndTime(new Timestamp(ord.getEsendtime().getTime()));
				}
				if (ord.getOrdertime() != null) {
					order.setOrderTime(new Timestamp(ord.getOrdertime().getTime()));
				}
				// 获取语言对名称
				String extendInfos = JSON.toJSONString(ord.getOrdextendes());
				List<OrdProdExtend> extendList = JSON.parseObject(extendInfos,
						new TypeReference<List<OrdProdExtend>>() {
						});
				if (!CollectionUtil.isEmpty(extendList)) {
					order.setLanguagePair(extendList.get(0).getLangungeid());
					order.setLanguagePairName(extendList.get(0).getLangungechname());
					order.setLanguageNameEn(extendList.get(0).getLangungeenname());
				}
				// 获取币种
				order.setCurrencyUnit(ord.getCurrencyunit());
				//
				results.add(order);
			}
		}
		pageinfo.setResult(results);
		pageinfo.setPageSize(request.getPageSize());
		pageinfo.setPageNo(request.getPageNo());
		pageinfo.setCount(Long.valueOf(result.getCount()).intValue());
		response.setPageInfo(pageinfo);
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "订单查询成功");
		response.setResponseHeader(responseHeader);
		return response;
	}
	// 搜索引擎数据公共查询条件
		public List<SearchCriteria> commonConditions(OrderAllocationSearchRequest request,List<Object> orderIdlist) {
			List<SearchCriteria> searchfieldVos = new ArrayList<SearchCriteria>();

			// 如果翻译主题不为空
			if (!StringUtil.isBlank(request.getTranslateName())) {
				searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.TRANSLATE_NAME, request.getTranslateName(),
						new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
			}
			// 如果译员id不为空
			if (!StringUtil.isBlank(request.getInterperId())) {
				searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.INTERPER_ID, request.getInterperId(),
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
				searchCriteria.setField(SearchFieldConfConstants.ESEND_TIME);
				searchCriteria.addFieldValue(start);
				searchCriteria.addFieldValue(end);
				searchfieldVos.add(searchCriteria);
			}
			//
			if(!CollectionUtil.isEmpty(orderIdlist)){
				SearchCriteria searchCriteria = new SearchCriteria();
				SearchOption option = new SearchOption();
				option.setSearchLogic(SearchOption.SearchLogic.must);
				option.setSearchType(SearchOption.SearchType.term);
				searchCriteria.setFieldValue(orderIdlist);
				searchCriteria.setField(SearchFieldConfConstants.ORDER_ID);
				searchCriteria.setOption(option);
				searchfieldVos.add(searchCriteria);
			}
			return searchfieldVos;
		}
}
