package com.ai.yc.order.service.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.paas.ipaas.search.vo.SearchCriteria;
import com.ai.paas.ipaas.search.vo.SearchOption;
import com.ai.paas.ipaas.search.vo.SearchOption.SearchLogic;
import com.ai.paas.ipaas.search.vo.SearchOption.SearchType;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.yc.order.api.orderdeplay.param.OrderDeplayRequest;
import com.ai.yc.order.api.orderquery.param.OrdOrderCountRequest;
import com.ai.yc.order.api.orderquery.param.OrdOrderCountResponse;
import com.ai.yc.order.api.orderquery.param.OrdProdExtendVo;
import com.ai.yc.order.api.orderquery.param.QueryOrdCountRequest;
import com.ai.yc.order.api.orderquery.param.RecoedCountInfo;
import com.ai.yc.order.api.orderquery.param.RecordOrderRequest;
import com.ai.yc.order.api.orderquery.param.RecordOrderResponse;
import com.ai.yc.order.api.orderquery.param.RecordOrderVo;
import com.ai.yc.order.api.orderrefund.param.OrderRefundCheckRequest;
import com.ai.yc.order.api.orderrefund.param.OrderRefundRequest;
import com.ai.yc.order.api.orderrefund.param.OrderRefundResponse;
import com.ai.yc.order.api.orderreprocess.param.OrdProductInfo;
import com.ai.yc.order.api.orderreprocess.param.OrderBaseInfo;
import com.ai.yc.order.api.orderreprocess.param.OrderReprocessRequest;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateRequest;
import com.ai.yc.order.api.orderstate.param.OrderStateUpdateResponse;
import com.ai.yc.order.api.orderstate.param.UpdateStateChgInfo;
import com.ai.yc.order.constants.OrdOdStateChgConstants;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.constants.OrdersConstants.OrderState;
import com.ai.yc.order.constants.SearchFieldConfConstants;
import com.ai.yc.order.dao.mapper.attach.OrdOrderCountAttach;
import com.ai.yc.order.dao.mapper.attach.OrdOrderHFCountAttach;
import com.ai.yc.order.dao.mapper.attach.RecordOrderInfoAttach;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.yc.order.dao.mapper.bo.OrdOdProd;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdExtend;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.interperlevel.rule.InterperLevelMap;
import com.ai.yc.order.interperlevel.rule.OrderLevelRange;
import com.ai.yc.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdExtendAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdStateChgAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAttachAtomSV;
import com.ai.yc.order.service.business.impl.search.OrderSearchImpl;
import com.ai.yc.order.service.business.interfaces.IOrdOrderBusiSV;
import com.ai.yc.order.service.business.interfaces.search.IOrderSearch;
import com.ai.yc.order.util.SequenceUtil;

@Service
public class OrdOrderBusiSVImpl implements IOrdOrderBusiSV {

	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Autowired
	private IOrdOdStateChgAtomSV ordOdStateChgAtomSV;// 订单轨迹表

	@Autowired
	private InterperLevelMap interperLevelMap;// 译员级别判定订单查询级别

	@Autowired
	private IOrdOrderAttachAtomSV ordOrderAttachAtomSV;

	@Autowired
	private IOrdOdProdAtomSV ordOdProdAtomSV;
	
	@Autowired
	private IOrdOdProdExtendAtomSV ordOdProdExtendAtomSV;
	
	@Autowired
	private IOrdOdFeeTotalAtomSV ordOdFeeTotalAtomSV;

	/**
	 * 订单延时
	 */
	private final static String ORDER_DEPLAY_CN = "客户申请延时确定译文";
	private final static String ORDER_DEPLAY_UCN = "您已申请延时确定译文";
	private final static String ORDER_DEPLAY_EN = "You have applied to postpone the confirmation";

	@Override
	public OrdOrder findByPrimaryKey(OrdOrder ordOrder) {
		return this.ordOrderAtomSV.findByPrimaryKey(ordOrder);
	}

	@Override
	public Map<String, Integer> findOrderCount(QueryOrdCountRequest request) {
		OrdOrder orderRequest = new OrdOrder();
		copyProperties(orderRequest, request);
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		if (!StringUtil.isBlank(request.getState())) {
			int stateCount = countAllOrders(orderRequest, request.getInterperLevel(), request.getLanguageIds());
			countMap.put(request.getState(), stateCount);
			return countMap;
		}
		if (!StringUtil.isBlank(request.getUserId())) {
			// 待支付
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_PAY);
			int waitPayCount = countAllOrders(orderRequest, request.getInterperLevel(), request.getLanguageIds());
			countMap.put(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_PAY, waitPayCount);

			// 待报价
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OFFER);
			int waitofferCount = countAllOrders(orderRequest, request.getInterperLevel(), request.getLanguageIds());
			countMap.put(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OFFER, waitofferCount);

			// 翻译中
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_TRASLATING);
			int translatingCount = countAllOrders(orderRequest, request.getInterperLevel(), request.getLanguageIds());
			countMap.put(OrdersConstants.OrderDisplayFlag.FLAG_TRASLATING, translatingCount);

			// 待确认
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OK);
			int waitOkCount = countAllOrders(orderRequest, request.getInterperLevel(), request.getLanguageIds());
			countMap.put(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OK, waitOkCount);

			// 待评价
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_COMMENT);
			int waitCommentCount = countAllOrders(orderRequest, request.getInterperLevel(), request.getLanguageIds());
			countMap.put(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_COMMENT, waitCommentCount);

		} else if (!StringUtil.isBlank(request.getInterperId()) || !StringUtil.isBlank(request.getLspId())) {
			// 待支付
			orderRequest.setState(OrdersConstants.OrderState.STATE_RECEIVED);
			int receivedCount = countAllOrders(orderRequest, request.getInterperLevel(), request.getLanguageIds());
			countMap.put(OrdersConstants.OrderState.STATE_RECEIVED, receivedCount);

			// 翻译中
			orderRequest.setState(OrdersConstants.OrderState.STATE_TRASLATING);
			int translatingCount = countAllOrders(orderRequest, request.getInterperLevel(), request.getLanguageIds());
			countMap.put(OrdersConstants.OrderState.STATE_TRASLATING, translatingCount);
		}

		return countMap;
	}

	private void copyProperties(OrdOrder orderRequest, QueryOrdCountRequest request) {
		orderRequest.setBusiType(request.getBusiType());
		orderRequest.setChlId(request.getChlId());
		orderRequest.setFlag(request.getFlag());
		orderRequest.setUserType(request.getUserType());
		orderRequest.setUserId(request.getUserId());
		orderRequest.setSubFlag(request.getSubFlag());
		orderRequest.setOrderType(request.getOrderType());
		orderRequest.setBusiType(request.getBusiType());
		orderRequest.setOrderLevel(request.getOrderLevel());
		orderRequest.setTranslateType(request.getTranslateType());
		orderRequest.setCorporaId(request.getCorporaId());
		orderRequest.setInterperType(request.getInterperType());
		orderRequest.setInterperId(request.getInterperId());
		orderRequest.setState(request.getState());
		orderRequest.setLspId(request.getLspId());
	}

	@Override
	@Transactional
	public OrderStateUpdateResponse updateState(OrderStateUpdateRequest request) {
		OrderStateUpdateResponse response = new OrderStateUpdateResponse();
		//
		OrdOrder ordOrderDb = this.ordOrderAtomSV.findByPrimaryKey(request.getOrderId());
		if (null == ordOrderDb) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "此订单信息不存在");
		}
		//
		OrdOrder ordOrder = new OrdOrder();
		ordOrder.setOrderId(request.getOrderId());
		ordOrder.setState(request.getState());
		ordOrder.setStateChgTime(DateUtil.getSysDate());
		if (OrdersConstants.OrderState.FLAG_FINISHED.equals(request.getState())) {
			ordOrder.setFinishTime(DateUtil.getSysDate());
			// 如果前端传90状态为待评价，轨迹状态不变仍为90
			ordOrder.setState(OrdersConstants.OrderState.WAIT_JUDGE_STATE);
		}
		//
		if (!StringUtil.isBlank(request.getDisplayFlag())) {
			ordOrder.setDisplayFlag(request.getDisplayFlag());
			ordOrder.setDisplayFlagChgTime(DateUtil.getSysDate());
		}
		if (!StringUtil.isBlank(request.getDisplayFlag())
				&& OrdersConstants.OrderState.FLAG_FINISHED.equals(request.getDisplayFlag())) {
			// 如果前端传90状态为待评价，轨迹状态不变仍为90
			ordOrder.setDisplayFlag(OrdersConstants.OrderState.WAIT_JUDGE_STATE);
		}
		//
		this.ordOrderAtomSV.updateByPrimaryKeySelective(ordOrder);
		//
		String userId = request.getUserId();
		Long orderId = request.getOrderId();
		String translateType = ordOrderDb.getTranslateType();// 数据库获取订单翻译类型
		String oldState = ordOrderDb.getState();// 数据库获取订单当前状态
		String newState = request.getState();// 新状态为 待领取
		// return operName 2017-01-10 10:39 zhangzd
		String operName = this.returnOperName(request.getStateChgInfo());
		//
		this.orderStateChgInfoSubmit(userId, orderId, translateType, oldState, newState, operName);
		//
		response.setOrderId(request.getOrderId());
		//
		return response;
	}

	/**
	 * return operName
	 * 
	 * @author zhangzd
	 */
	public String returnOperName(UpdateStateChgInfo stateChgInfo) {
		//
		String operName = "";
		if (null == stateChgInfo) {
			operName = "";
		} else {
			if (!StringUtil.isBlank(stateChgInfo.getOperName())) {
				operName = stateChgInfo.getOperName();
			}
		}
		//
		return operName;
	}

	/**
	 * 订单提交-订单轨迹表
	 */
	public void orderStateChgInfoSubmit(String userId, Long orderId, String translateType, String oldState,
			String newState, String operName) {
		OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
		//
		Long stateChgId = SequenceUtil.createStateChgId();
		//
		ordOdStateChg.setStateChgId(stateChgId);
		ordOdStateChg.setOrderId(orderId);
		ordOdStateChg.setOperId(userId);
		ordOdStateChg.setOperName(operName);// 2017-01-13 15:01 zhangzd
		ordOdStateChg.setOrgState(oldState);
		ordOdStateChg.setNewState(newState);

		// 翻译中状态
		if (OrdersConstants.OrderState.STATE_TRASLATING.equals(newState)) {
			ordOdStateChg.setChgDesc("订单翻译中");
			ordOdStateChg.setChgDescEn("Is translation orders");

		}
		// 待审核状态
		if (OrdersConstants.OrderState.WAIT_REVIEW_STATE.equals(newState)) {
			ordOdStateChg.setChgDesc("译员 " + operName + " 提交了译文");
			ordOdStateChg.setChgDescEn("Translator " + operName + " submitted the order translated text");

		}
		// 完成状态
		if (OrdersConstants.OrderState.FLAG_FINISHED.equals(newState)) {
			ordOdStateChg.setChgDesc("客户确认了订单");
			ordOdStateChg.setChgDescEn("Client confirmed the order");
			ordOdStateChg.setChgDescD("确认了订单");
			ordOdStateChg.setChgDescUEn("Confirmed the order");
			ordOdStateChg.setFlag(OrdOdStateChgConstants.FLAG_USER);
		}
		ordOdStateChg.setStateChgTime(DateUtil.getSysDate());
		this.ordOdStateChgAtomSV.insertSelective(ordOdStateChg);
	}

	// 客户我的订单及译员我的订单统计
	private int countAllOrders(OrdOrder request, String interperLevel, List<Object> languageIds) {
		IOrderSearch orderSearch = new OrderSearchImpl();
		List<SearchCriteria> searchCriterias = installConditions(request, interperLevel, languageIds);
		return orderSearch.countAll(searchCriterias);
	}

	// 订单大厅统计
	private int countAllOrders4TaskCenter(OrdOrder request, String interperLevel, List<Object> languageIds) {
		IOrderSearch orderSearch = new OrderSearchImpl();
		List<SearchCriteria> searchCriterias = installConditions4TaskCenter(request, interperLevel, languageIds);
		return orderSearch.countAll(searchCriterias);
	}

	/**
	 * 搜索引擎数据公共查询条件
	 * 
	 * @param request
	 *            请求
	 * @param interperLevel
	 *            译员级别
	 * @param languageIds
	 *            语言对
	 * @return
	 * @author gucl
	 */
	private List<SearchCriteria> installConditions(OrdOrder request, String interperLevel, List<Object> languageIds) {
		List<SearchCriteria> searchfieldVos = new ArrayList<SearchCriteria>();
		if (!StringUtil.isBlank(interperLevel)) {
			Map<String, OrderLevelRange> interperLevelMap = this.interperLevelMap.getInterperLevelMap();
			SearchCriteria searchCriteria = new SearchCriteria();
			searchCriteria.setOption(new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.range));
			searchCriteria.setField(SearchFieldConfConstants.ORDER_LEVEL);
			String minValue = "1";
			String maxValue = "1";
			if (null != interperLevelMap.get(interperLevel)) {
				minValue = interperLevelMap.get(interperLevel).getMinValue();
				maxValue = interperLevelMap.get(interperLevel).getMaxValue();
			}
			searchCriteria.addFieldValue(minValue);
			searchCriteria.addFieldValue(maxValue);
			searchfieldVos.add(searchCriteria);
		}
		/*
		 * // 如果业务标识不为空 if (!StringUtil.isBlank(request.getFlag())) {
		 * searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.FLAG,
		 * request.getFlag(), new SearchOption(SearchOption.SearchLogic.must,
		 * SearchOption.SearchType.querystring))); }
		 */
		// 如果订单id不为空
		if (request.getOrderId() != null) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.ORDER_ID, request.getOrderId().toString(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果用户类型不为空
		if (!StringUtil.isBlank(request.getUserType())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.USER_TYPE, request.getUserType(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果用户id不为空
		if (!StringUtil.isBlank(request.getUserId()) && StringUtil.isBlank(request.getCorporaId())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.USER_ID, request.getUserId(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}

		// 如果企业id不为空
		if (!StringUtil.isBlank(request.getCorporaId()) && StringUtil.isBlank(request.getUserId())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.CORPORA_ID, request.getCorporaId(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果企业id和用户id同时不为空
		if (!StringUtil.isBlank(request.getUserId()) && !StringUtil.isBlank(request.getCorporaId())) {
			SearchCriteria vo = new SearchCriteria();
			vo.addSubCriteria(new SearchCriteria(SearchFieldConfConstants.CORPORA_ID, request.getCorporaId(),
					new SearchOption(SearchLogic.should, SearchType.querystring)));
			vo.addSubCriteria(new SearchCriteria(SearchFieldConfConstants.USER_ID, request.getUserId(),
					new SearchOption(SearchLogic.should, SearchType.querystring)));
			searchfieldVos.add(vo);
		}
		// 如果报价标识不为空
		if (!StringUtil.isBlank(request.getSubFlag())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.SUB_FLAG, request.getSubFlag(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果订单来源不为空
		if (!StringUtil.isBlank(request.getChlId())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.CHL_ID, request.getChlId(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果订单类型不为空
		if (!StringUtil.isBlank(request.getOrderType())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.ORDER_TYPE, request.getOrderType(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果订单级别不为空
		if (!StringUtil.isBlank(request.getOrderLevel())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.ORDER_LEVEL, request.getOrderLevel(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果翻译类型不为空
		if (!StringUtil.isBlank(request.getTranslateType())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.TRANSLATE_TYPE, request.getTranslateType(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果state不为空
		if (!StringUtil.isBlank(request.getState())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.STATE, request.getState(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果客户端显示状态不为空
		if (!StringUtil.isBlank(request.getDisplayFlag())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.DISPLAY_FLAG, request.getDisplayFlag(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果译员类型不为空
		if (!StringUtil.isBlank(request.getInterperType())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.INTERPER_TYPE, request.getInterperType(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果操作员id不为空
		if (!StringUtil.isBlank(request.getOperId())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.OPER_ID, request.getOperId(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果lspid不为空
		if (!StringUtil.isBlank(request.getLspId())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.LSP_ID, request.getLspId(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果译员id不为空
		if (!StringUtil.isBlank(request.getInterperId())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.INTERPER_ID, request.getInterperId(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}

		return searchfieldVos;
	}

	private List<SearchCriteria> installConditions4TaskCenter(OrdOrder request, String interperLevel,
			List<Object> languageIds) {
		List<SearchCriteria> searchfieldVos = new ArrayList<SearchCriteria>();
		if (!StringUtil.isBlank(interperLevel)) {
			Map<String, OrderLevelRange> interperLevelMap = this.interperLevelMap.getInterperLevelMap();
			SearchCriteria searchCriteria = new SearchCriteria();
			searchCriteria.setOption(new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.range));
			searchCriteria.setField(SearchFieldConfConstants.ORDER_LEVEL);
			String minValue = "1";
			String maxValue = "1";
			if (null != interperLevelMap.get(interperLevel)) {
				minValue = interperLevelMap.get(interperLevel).getMinValue();
				maxValue = interperLevelMap.get(interperLevel).getMaxValue();
			}
			searchCriteria.addFieldValue(minValue);
			searchCriteria.addFieldValue(maxValue);
			searchfieldVos.add(searchCriteria);
		}
		/*
		 * // 如果业务标识不为空 if (!StringUtil.isBlank(request.getFlag())) {
		 * searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.FLAG,
		 * request.getFlag(), new SearchOption(SearchOption.SearchLogic.must,
		 * SearchOption.SearchType.querystring))); }
		 */
		// 如果订单id不为空
		if (request.getOrderId() != null) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.ORDER_ID, request.getOrderId().toString(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果用户类型不为空
		if (!StringUtil.isBlank(request.getUserType())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.USER_TYPE, request.getUserType(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果用户id不为空
		if (!StringUtil.isBlank(request.getUserId()) && StringUtil.isBlank(request.getCorporaId())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.USER_ID, request.getUserId(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果企业id不为空
		if (!StringUtil.isBlank(request.getCorporaId()) && StringUtil.isBlank(request.getUserId())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.CORPORA_ID, request.getCorporaId(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果企业id和用户id同时不为空
		if (!StringUtil.isBlank(request.getUserId()) && !StringUtil.isBlank(request.getCorporaId())) {
			SearchCriteria vo = new SearchCriteria();
			vo.addSubCriteria(new SearchCriteria(SearchFieldConfConstants.CORPORA_ID, request.getCorporaId(),
					new SearchOption(SearchLogic.should, SearchType.querystring)));
			vo.addSubCriteria(new SearchCriteria(SearchFieldConfConstants.USER_ID, request.getUserId(),
					new SearchOption(SearchLogic.should, SearchType.querystring)));
			searchfieldVos.add(vo);
		}

		// 如果报价标识不为空
		if (!StringUtil.isBlank(request.getSubFlag())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.SUB_FLAG, request.getSubFlag(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果订单来源不为空
		if (!StringUtil.isBlank(request.getChlId())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.CHL_ID, request.getChlId(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果订单类型不为空
		if (!StringUtil.isBlank(request.getOrderType())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.ORDER_TYPE, request.getOrderType(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果订单级别不为空
		if (!StringUtil.isBlank(request.getOrderLevel())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.ORDER_LEVEL, request.getOrderLevel(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果翻译类型不为空
		if (!StringUtil.isBlank(request.getTranslateType())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.TRANSLATE_TYPE, request.getTranslateType(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}

		// 如果state不为空
		if (!StringUtil.isBlank(request.getState())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.STATE, request.getState(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果客户端显示状态不为空
		if (!StringUtil.isBlank(request.getDisplayFlag())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.DISPLAY_FLAG, request.getDisplayFlag(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果译员类型不为空
		if (!StringUtil.isBlank(request.getInterperType())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.INTERPER_TYPE, request.getInterperType(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果操作员id不为空
		if (!StringUtil.isBlank(request.getOperId())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.OPER_ID, request.getOperId(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}
		// 如果lspid不为空
		/*
		 * if (!StringUtil.isBlank(request.getLspId())) { searchfieldVos.add(new
		 * SearchCriteria(SearchFieldConfConstants.LSP_ID, request.getLspId(),
		 * new SearchOption(SearchOption.SearchLogic.must,
		 * SearchOption.SearchType.querystring))); }
		 */
		// 如果译员id不为空
		if (!StringUtil.isBlank(request.getInterperId())) {
			searchfieldVos.add(new SearchCriteria(SearchFieldConfConstants.INTERPER_ID, request.getInterperId(),
					new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.querystring)));
		}

		// 如果为非LSP用户，且语言对id集合不为空，那么就传入 2017-01-06 11:04 gucl
		if (StringUtil.isBlank(request.getLspId())) {
			if (CollectionUtil.isEmpty(languageIds)) {
				languageIds = new ArrayList<Object>();
				languageIds.add("0");// 0代表不存在
			}
			SearchCriteria searchCriteria = new SearchCriteria();
			searchCriteria.setOption(new SearchOption(SearchOption.SearchLogic.must, SearchOption.SearchType.term));
			searchCriteria.setField(SearchFieldConfConstants.LANGUNGE_ID);
			searchCriteria.setFieldValue(languageIds);
			searchfieldVos.add(searchCriteria);
		}

		return searchfieldVos;
	}

	@Override
	public Map<String, Integer> findOrderCount4TaskCenter(QueryOrdCountRequest request) {
		OrdOrder orderRequest = new OrdOrder();
		copyProperties(orderRequest, request);
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		if (!StringUtil.isBlank(request.getState())) {
			int stateCount = countAllOrders4TaskCenter(orderRequest, request.getInterperLevel(),
					request.getLanguageIds());
			countMap.put(request.getState(), stateCount);
			return countMap;
		}
		if (!StringUtil.isBlank(request.getUserId())) {
			// 待支付
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_PAY);
			int waitPayCount = countAllOrders4TaskCenter(orderRequest, request.getInterperLevel(),
					request.getLanguageIds());
			countMap.put(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_PAY, waitPayCount);

			// 待报价
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OFFER);
			int waitofferCount = countAllOrders4TaskCenter(orderRequest, request.getInterperLevel(),
					request.getLanguageIds());
			countMap.put(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OFFER, waitofferCount);

			// 翻译中
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_TRASLATING);
			int translatingCount = countAllOrders4TaskCenter(orderRequest, request.getInterperLevel(),
					request.getLanguageIds());
			countMap.put(OrdersConstants.OrderDisplayFlag.FLAG_TRASLATING, translatingCount);

			// 待确认
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OK);
			int waitOkCount = countAllOrders4TaskCenter(orderRequest, request.getInterperLevel(),
					request.getLanguageIds());
			countMap.put(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OK, waitOkCount);

			// 待评价
			orderRequest.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_COMMENT);
			int waitCommentCount = countAllOrders4TaskCenter(orderRequest, request.getInterperLevel(),
					request.getLanguageIds());
			countMap.put(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_COMMENT, waitCommentCount);

		} else if (!StringUtil.isBlank(request.getInterperId()) || !StringUtil.isBlank(request.getInterperId())) {
			// 待支付
			orderRequest.setState(OrdersConstants.OrderState.STATE_RECEIVED);
			int receivedCount = countAllOrders4TaskCenter(orderRequest, request.getInterperLevel(),
					request.getLanguageIds());
			countMap.put(OrdersConstants.OrderState.STATE_RECEIVED, receivedCount);

			// 翻译中
			orderRequest.setState(OrdersConstants.OrderState.STATE_TRASLATING);
			int translatingCount = countAllOrders4TaskCenter(orderRequest, request.getInterperLevel(),
					request.getLanguageIds());
			countMap.put(OrdersConstants.OrderState.STATE_TRASLATING, translatingCount);
		}

		return countMap;
	}

	@Override
	public OrderRefundResponse refundOrd(OrderRefundRequest request) {
		OrderRefundResponse response = new OrderRefundResponse();
		OrdOrder ordOrderDb = this.ordOrderAtomSV.findByPrimaryKey(request.getOrderId());
		if (null == ordOrderDb) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "此订单信息不存在");
		}
		OrdOrder ordOrder = new OrdOrder();
		// 获取父订单号
		Long parentOrderId = SequenceUtil.createOrderId();
		ordOrder.setParentOrderId(parentOrderId.toString());
		ordOrder.setOrderId(request.getOrderId());
		ordOrder.setState(request.getState());
		ordOrder.setStateChgTime(DateUtil.getSysDate());
		ordOrder.setEndChgTime(DateUtil.getSysDate());
		ordOrder.setBusiType(request.getBusiType());
		if (!StringUtil.isBlank(request.getReasonDesc())) {
			ordOrder.setReasonDesc(request.getReasonDesc());
		}
		if (!StringUtil.isBlank(request.getDisplayFlag())) {
			ordOrder.setDisplayFlag(request.getDisplayFlag());
			ordOrder.setDisplayFlagChgTime(DateUtil.getSysDate());
		}

		this.ordOrderAtomSV.updateByPrimaryKeySelective(ordOrder);
		// 4.入库订单轨迹表
		OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
		ordOdStateChg.setStateChgId(SequenceUtil.createStateChgId());
		ordOdStateChg.setOrderId(request.getOrderId());
		ordOdStateChg.setChgDesc("客户要求退款：没有按时完成");
		ordOdStateChg.setChgDescEn("Client asked for refund: failed to deliver the translation on time");
		ordOdStateChg.setChgDescD("客户要求退款：没有按时完成");
		ordOdStateChg.setChgDescUEn("Client asked for refund: failed to deliver the translation on time");
		ordOdStateChg.setFlag(OrdOdStateChgConstants.FLAG_USER);
		ordOdStateChg.setOrgId("1");
		ordOdStateChg.setOperId(request.getOperId());
		ordOdStateChg.setOperName(request.getOperName());
		ordOdStateChg.setOrgState(ordOrderDb.getState());
		ordOdStateChg.setNewState(request.getState());
		ordOdStateChg.setStateChgTime(DateUtil.getSysDate());

		this.ordOdStateChgAtomSV.insertSelective(ordOdStateChg);

		response.setOrderId(request.getOrderId());

		return response;
	}

	@Override
	public OrderRefundResponse refundCheckOrd(OrderRefundCheckRequest request) {
		OrderRefundResponse response = new OrderRefundResponse();

		OrdOrder ordOrderDb = this.ordOrderAtomSV.findByPrimaryKey(request.getOrderId());
		if (null == ordOrderDb) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "此订单信息不存在");
		}
		OrdOrder ordOrder = new OrdOrder();
		ordOrder.setOrderId(request.getOrderId());
		ordOrder.setState(request.getState());
		ordOrder.setStateChgTime(DateUtil.getSysDate());
		ordOrder.setEndChgTime(DateUtil.getSysDate());
		if (!StringUtil.isBlank(request.getReasonDesc())) {
			ordOrder.setReasonDesc(request.getReasonDesc());
		}
		if (!StringUtil.isBlank(request.getDisplayFlag()) && "92".equals(request.getState())) {
			ordOrder.setDisplayFlag(request.getDisplayFlag());
			ordOrder.setDisplayFlagChgTime(DateUtil.getSysDate());
		}

		this.ordOrderAtomSV.updateByPrimaryKeySelective(ordOrder);
		// 4.入库订单轨迹表 42审核失败，92：退款完成
		OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
		ordOdStateChg.setStateChgId(SequenceUtil.createStateChgId());
		ordOdStateChg.setOrderId(request.getOrderId());
		if("42".equals(request.getState())){
			ordOdStateChg.setChgDesc("订单未通过审核");
			ordOdStateChg.setChgDescEn("Order review failed");
			ordOdStateChg.setChgDescD("订单未通过审核");
			ordOdStateChg.setChgDescUEn("Order review failed");
		}else if("92".equals(request.getState())){
			ordOdStateChg.setChgDesc("您的订单已退款，预计30个工作日之内将款项返回至原支付账户");
			ordOdStateChg.setChgDescEn("Your order has been refunded; the fund will be returned to your disbursement account within 30 workdays");
			ordOdStateChg.setChgDescD("您的订单已退款，预计30个工作日之内将款项返回至原支付账户");
			ordOdStateChg.setChgDescUEn("Your order has been refunded; the fund will be returned to your disbursement account within 30 workdays");
		}
		ordOdStateChg.setFlag(OrdOdStateChgConstants.FLAG_USER);
		ordOdStateChg.setOrgId("1");
		ordOdStateChg.setOperId(request.getOperId());
		ordOdStateChg.setOperName(request.getOperName());
		ordOdStateChg.setOrgState(ordOrderDb.getState());
		ordOdStateChg.setNewState(request.getState());
		ordOdStateChg.setStateChgTime(DateUtil.getSysDate());

		this.ordOdStateChgAtomSV.insertSelective(ordOdStateChg);

		response.setOrderId(request.getOrderId());

		return response;
	}

	@Override
	public void deplayOrder(OrderDeplayRequest request) {
		OrdOrder noConfirmOrders = null;
		// 1.获取订单
		try {
			noConfirmOrders = ordOrderAtomSV.findByPrimaryKey(request.getOrderId());
		} catch (Exception e) {
			throw new SystemException(e);
		}
		// 2.判断订单是否存在
		if (noConfirmOrders == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,
					"订单为空[orderId:" + request.getOrderId() + "]");
		}
		OrdOrder ord = new OrdOrder();
		BeanUtils.copyProperties(ord, request);
		ord.setDelayedFlag("1");
		ordOrderAtomSV.updateByPrimaryKeySelective(ord);
		// 添加修改轨迹
		OrdOdStateChg chg = new OrdOdStateChg();
		chg.setOrderId(request.getOrderId());
		chg.setStateChgId(SequenceUtil.createStateChgId());
		chg.setOrgState(noConfirmOrders.getState());
		chg.setNewState(noConfirmOrders.getState());
		chg.setOperId(request.getOperId());
		chg.setOperName(request.getOperName());
		chg.setChgDesc(ORDER_DEPLAY_CN);
		chg.setChgDescEn(ORDER_DEPLAY_EN);
		// 前端门户显示字段
		chg.setChgDescUEn(ORDER_DEPLAY_EN);
		chg.setChgDescD(ORDER_DEPLAY_UCN);
		chg.setFlag(OrdOdStateChgConstants.FLAG_USER);
		chg.setOperName(request.getOperName());
		chg.setStateChgTime(DateUtil.getSysDate());
		ordOdStateChgAtomSV.insertSelective(chg);
	}

	@Override
	public OrdOrderCountResponse countInfo(OrdOrderCountRequest request) {
		OrdOrderCountResponse response = new OrdOrderCountResponse();
		OrdOrderCountAttach attach = ordOrderAttachAtomSV.queryOrderCountInfo(request.getChlId(), request.getUserId(),
				request.getCorporaId());
		OrdOrderHFCountAttach attachHF = ordOrderAttachAtomSV.queryOrderCountHFInfo(request.getChlId(), request.getUserId(),
				request.getCorporaId());
		if(null!=attachHF){
			response.setOrderHFCounts(attachHF.getOrderCounts());
			response.setHFtotalFees(attachHF.getTotalFeeCount());
		}
		if (attach != null) {
			BeanUtils.copyVO(response, attach);
		}
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "订单汇总信息查询成功");
		response.setResponseHeader(responseHeader);
		return response;
	}

	@Override
	public void reprocessOrder(OrderReprocessRequest request) {
		// 判断订单是否存在
		OrdOrder ordOrderDb = this.ordOrderAtomSV.findByPrimaryKey(request.getBaseInfo().getOrderId());
		if (null == ordOrderDb) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "此订单信息不存在");
		}
		// 修改订单状态
		OrderBaseInfo baseInfo = request.getBaseInfo();
		BeanUtils.copyVO(ordOrderDb, baseInfo);
		ordOrderDb.setStateChgTime(DateUtil.getSysDate());
		ordOrderDb.setDisplayFlag(baseInfo.getState());
		ordOrderDb.setDisplayFlagChgTime(DateUtil.getSysDate());
		ordOrderAtomSV.updateByPrimaryKeySelective(ordOrderDb);
		// 修改产品信息
		OrdProductInfo ordProductInfo = request.getProductInfo();
		OrdOdProd ordOdProd = ordOdProdAtomSV.findByOrderId(request.getBaseInfo().getOrderId());
		// 判断订单产品信息是否存在
		if (ordOdProd == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单的产品信息为空");
		}
		if (null != ordProductInfo) {
			ordOdProd.setTakeDay(ordProductInfo.getTakeDay());
			ordOdProd.setTakeTime(ordProductInfo.getTakeTime());
		}
		ordOdProdAtomSV.updateBySelective(ordOdProd);
		// 添加修改轨迹
		OrdOdStateChg chg = new OrdOdStateChg();
		chg.setOrderId(request.getBaseInfo().getOrderId());
		chg.setStateChgId(SequenceUtil.createStateChgId());
		chg.setOrgState(ordOrderDb.getState());
		chg.setNewState(request.getBaseInfo().getState());
		chg.setOperId(request.getBaseInfo().getOperId());
		chg.setOperName(request.getBaseInfo().getOperName());
		chg.setChgDesc("客户要求修改订单：翻译的不够准确");
		chg.setChgDescEn("Client asked for revising the order: the translation is not accurate enough");
		// 前端门户显示字段
		chg.setChgDescUEn("Client asked for revising the order: the translation is not accurate enough");
		chg.setChgDescD("客户要求修改订单：翻译的不够准确");
		chg.setFlag(OrdOdStateChgConstants.FLAG_USER);
		chg.setOperName(request.getBaseInfo().getOperName());
		chg.setStateChgTime(DateUtil.getSysDate());
		ordOdStateChgAtomSV.insertSelective(chg);

	}

	@Override
	public RecordOrderResponse getRecordOrder(RecordOrderRequest req) {
		RecordOrderResponse response = new RecordOrderResponse();
		List<OrdOrder> orderList = ordOrderAtomSV.getRecordOrder(req, OrderState.COMMENTED_STATE);
		List<RecordOrderVo> results = new ArrayList<RecordOrderVo>();
		if (!CollectionUtil.isEmpty(orderList)) {
			for (OrdOrder order : orderList) {
				RecordOrderVo orderVO = new RecordOrderVo();
				BeanUtils.copyProperties(orderVO, order);
				//获取对应的语言对信息
				List<OrdProdExtendVo> ordProdExtendList = new ArrayList<OrdProdExtendVo>();
				List<OrdOdProdExtend> ordOdProdExtendList = ordOdProdExtendAtomSV.findByOrderId(order.getOrderId());
				if (!CollectionUtil.isEmpty(ordOdProdExtendList)) {
					for (OrdOdProdExtend extend : ordOdProdExtendList) {
						OrdProdExtendVo prodextendVo = new OrdProdExtendVo();
						BeanUtils.copyProperties(prodextendVo, extend);
						prodextendVo.setLangungePairChName(extend.getLangungePairName());
						prodextendVo.setLangungePairEnName(extend.getLangungeNameEn());
						ordProdExtendList.add(prodextendVo);
					}
					orderVO.setOrdProdExtendList(ordProdExtendList);
				}
				// 查询费用信息
				OrdOdFeeTotal ordOdFeeTotal = ordOdFeeTotalAtomSV.findByOrderId(order.getOrderId());
				if (ordOdFeeTotal != null) {
					if (ordOdFeeTotal.getPlatFee() != null) {
						orderVO.setPlatFee(ordOdFeeTotal.getPlatFee());
					}
					if (ordOdFeeTotal.getInterperFee() != null) {
						orderVO.setInterperFee(ordOdFeeTotal.getInterperFee());
					}
					if (ordOdFeeTotal.getPaidFee() != null) {
						orderVO.setPaidFee(ordOdFeeTotal.getPaidFee());
					}
					orderVO.setCurrencyUnit(ordOdFeeTotal.getCurrencyUnit());
				}
				//获取翻译字数
				OrdOdProd ordOdProd = ordOdProdAtomSV.findByOrderId(order.getOrderId());
				if (ordOdProd != null) {
					orderVO.setTranslateSum(Long.valueOf(ordOdProd.getTranslateSum()));
				}
				results.add(orderVO);
			}
		}
		PageInfo<RecordOrderVo> pageinfo = new PageInfo<RecordOrderVo>();
		pageinfo.setResult(results);
		pageinfo.setPageSize(req.getPageSize());
		pageinfo.setPageNo(req.getPageNo());
		pageinfo.setCount(ordOrderAtomSV.getRecordOrderCount(req, OrderState.COMMENTED_STATE));
		response.setPageInfo(pageinfo);
		//获取汇总信息
		RecordOrderInfoAttach attach = ordOrderAttachAtomSV.queryRecordOrderInfo(req.getOrderId(),OrderState.COMMENTED_STATE, req.getInterperId(),req.getLspId(),req.getStateChgTimeStart(), req.getStateChgTimeEnd());
		if(null!=attach){
			RecoedCountInfo countInfo = new RecoedCountInfo();
			countInfo.setSumInterperFee(attach.getInterperFeeCount());
			countInfo.setSumPlatFee(attach.getPlatFeeCount());
			countInfo.setSumTotalFee(attach.getTotalFeeCount());
			countInfo.setCurrencyUnit(attach.getCurrencyUnit());
			response.setCountInfo(countInfo);
		}
		return response;
	}

}
