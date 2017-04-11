package com.ai.yc.order.util;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationPersonInfo;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationSearchRequest;
import com.ai.yc.order.api.orderclose.param.OrderCancelRequest;
import com.ai.yc.order.api.orderdeplay.param.OrderDeplayRequest;
import com.ai.yc.order.api.orderevaluation.param.OrdEvaluationRuleRequest;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrdCountRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrderRequest;
import com.ai.yc.order.api.orderreceive.param.OrderAlloReceiveRequest;
import com.ai.yc.order.api.orderrefund.param.OrderRefundCheckRequest;
import com.ai.yc.order.api.orderrefund.param.OrderRefundRequest;
import com.ai.yc.order.api.orderreprocess.param.OrderReprocessRequest;
import com.ai.yc.order.api.orderreview.param.OrderLspReviewRequest;
import com.ai.yc.order.api.orderreview.param.OrderReviewRequest;

public class ValidateUtils {
	private ValidateUtils() {
	}

	public static void validateQueryOrder(QueryOrderRequest condition) {
		if (condition == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (condition.getPageNo()==null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "页码不能为空");
		}
		if (condition.getPageSize()==null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "页码大小不能为空");
		}
	}
	public static void validateQueryOrdCount(QueryOrdCountRequest condition) {
		if (condition == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
	}
	/**
	 * 关闭订单校验
	 */
	public static void validateCancleOrdOrder(OrderCancelRequest condition) {
		if (condition == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (condition.getOrderId() == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单ID不能为空");
		}
		if (StringUtil.isBlank(condition.getOperId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "操作员ID不能为空");
		}
	}
	/**
	 * 审核订单校验
	 */
	public static void validateReviewOrder(OrderReviewRequest condition) {
		if (condition == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (CollectionUtil.isEmpty(condition.getOrderIdList())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单ID不能为空");
		}
		if (StringUtil.isBlank(condition.getOperId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "操作员ID不能为空");
		}
		if (StringUtil.isBlank(condition.getState())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "状态不能为空");
		}
	}
	/**
	 * lsp审核订单校验
	 */
	public static void validateLspReviewOrder(OrderLspReviewRequest condition) {
		if (condition == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (null==condition.getOrderId()) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单ID不能为空");
		}
		if (StringUtil.isBlank(condition.getOperId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "操作员ID不能为空");
		}
		if (StringUtil.isBlank(condition.getState())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "状态不能为空");
		}
	}
	
	/**
	 * 订单评价参数校验
	 */
	public static void validateOrderEvaluation(OrderEvaluationRequest condition) {
		if (condition == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if(condition.getBaseInfo()==null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单基本信息对象不能为空");
		}
		if(condition.getExtendInfo()==null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "评价基本信息对象不能为空");
		}
		if(condition.getBaseInfo().getOrderId()==null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单ID不能为空");
		}
		if (StringUtil.isBlank(condition.getBaseInfo().getState())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单状态不能为空");
		}
		if (StringUtil.isBlank(condition.getBaseInfo().getUserId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "用户id不能为空");
		}
		if (StringUtil.isBlank(condition.getBaseInfo().getOperName())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "操作者昵称不能为空");
		}
		if(condition.getExtendInfo().getServeQuality()==null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "评价信息服务质量不能为空");
		}
		if(condition.getExtendInfo().getServeSpeen()==null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "评价信息服务速度不能为空");
		}
		if(condition.getExtendInfo().getServeManner()==null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "评价信息服务态度不能为空");
		}
		if (StringUtil.isBlank(condition.getExtendInfo().getEvaluateContent())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "评价内容不能为空");
		}
		if (StringUtil.isBlank(condition.getExtendInfo().getState())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "评价信息状态不能为空");
		}
		if (condition.getExtendInfo().getEvaluateTime()==null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "评论时间不能为空");
		}
	}
	/**
	 * 退款申请订单校验
	 */
	public static void validateRefundOrder(OrderRefundRequest request) {
		if (request == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if(null == request.getOrderId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"订单编号不能为空");
		}
		if(StringUtil.isBlank(request.getState())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"订单状态不能为空");
		}
		if(StringUtil.isBlank(request.getDisplayFlag())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"客户端显示状态不能为空");
		}
		if (StringUtil.isBlank(request.getOperId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "操作id不能为空");
		}
		if (StringUtil.isBlank(request.getOperName())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "操作者昵称不能为空");
		}
		if (StringUtil.isBlank(request.getBusiType())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "业务类型不能为空");
		}
	}
	/**
	 * 退款审核订单校验
	 */
	public static void validateRefundCheck(OrderRefundCheckRequest request) {
		if (request == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if(null == request.getOrderId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"订单编号不能为空");
		}
		if(StringUtil.isBlank(request.getState())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"订单状态不能为空");
		}
		if(StringUtil.isBlank(request.getDisplayFlag())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"客户端显示状态不能为空");
		}
		if (StringUtil.isBlank(request.getOperId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "操作id不能为空");
		}
		if (StringUtil.isBlank(request.getOperName())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "操作者昵称不能为空");
		}
	}
	/**
	 * 评价规则校验OrderDeplayRequest
	 */
	public static void validateEvaluteRule(OrdEvaluationRuleRequest request) {
		if (request == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if(null == request.getServeManner()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"态度不能为空");
		}
		if(null == request.getServeQuality()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"质量不能为空");
		}
		if(null == request.getServeSpeen()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"速度不能为空");
		}
		
	}
	/**
	 * 订单延迟校验
	 */
	public static void validateOrdDeplay(OrderDeplayRequest request) {
		if (request == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if(null == request.getOrderId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"订单id不能为空");
		}
		if(null == request.getEndChgTime() || "".equals(request.getEndChgTime())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"状态结束时间不能为空");
		}
		if(StringUtil.isBlank(request.getOperId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"操作者id不能为空");
		}
		if(StringUtil.isBlank(request.getOperName())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"操作者名称不能为空");
		}
	}
	//订单分配校验
	public static void validateAllocateOrder(OrderAllocationRequest request) {
		if (request == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if(null == request.getOrderAllocationBaseInfo()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"分配基本信息参数对象不能为空");
		}
		if(null==request.getOrderAllocationReceiveFollowInfo()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"任务跟踪参数对象不能为空");
		}
		if(CollectionUtil.isEmpty(request.getOrdAllocationPersonInfoList())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"分配人员参数对象不能为空");
		}
		if(null!=request.getOrderAllocationReceiveFollowInfo()){
			if(StringUtil.isBlank(request.getOrderAllocationReceiveFollowInfo().getOperType())){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"操作类型不能为空");
			}
		}
		if(!CollectionUtil.isEmpty(request.getOrdAllocationPersonInfoList())){
			for(OrdAllocationPersonInfo info:request.getOrdAllocationPersonInfoList()){
				if(null==info){
					throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"分配人员参数对象不能为空");
				}else{
					if(StringUtil.isBlank(info.getInterperName())){
						throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"译员名称不能为空");
					}
					if(StringUtil.isBlank(info.getTel())){
						throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"联系方式不能为空");
					}
				}
			}
		}
		if(null==request.getOrderAllocationBaseInfo().getOrderId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"订单id不能为空");
		}
		if(StringUtil.isBlank(request.getOrderAllocationBaseInfo().getState())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"订单状态不能为空");
		}
		if(StringUtil.isBlank(request.getOrderAllocationBaseInfo().getOperId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"操作者id不能为空");
		}
		if(StringUtil.isBlank(request.getOrderAllocationBaseInfo().getOperName())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"操作者名称不能为空");
		}
		
	}
	/**
	 * 分配订单领取校验
	 */
	public static void validateOrdAlloReceive(OrderAlloReceiveRequest request) {
		if (request == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if(null == request.getOrderId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"订单id不能为空");
		}
		if(null == request.getInterperId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"译员id不能为空");
		}
		if(StringUtil.isBlank(request.getStep())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"操作类型不能为空");
		}
		if(StringUtil.isBlank(request.getOperName())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"操作者名称不能为空");
		}
	}
	/**
	 * 分配订单查询
	 */
	public static void validateAlloQuryeOrder(OrderAllocationSearchRequest condition) {
		if (condition == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (null==condition.getPageNo()) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "页码不能为空");
		}
		if (null==condition.getPageSize()) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "页码大小不能为空");
		}
	}
	/**
	 * 订单返工校验
	 */
	public static void validateOrdReprocess(OrderReprocessRequest request) {
		if (request == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if(null==request.getBaseInfo()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"基础信息不能为空");
		}
		if(null==request.getProductInfo()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"产品信息不能为空");
		}
		if(null == request.getBaseInfo().getOrderId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"订单id不能为空");
		}
		if(StringUtil.isBlank(request.getBaseInfo().getState())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"状态不能为空");
		}
		if(StringUtil.isBlank(request.getBaseInfo().getOperId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"操作者id不能为空");
		}
		if(StringUtil.isBlank(request.getBaseInfo().getOperName())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"操作者名称不能为空");
		}
		if(StringUtil.isBlank(request.getProductInfo().getTakeDay())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"需耗天不能为空");
		}
		if(StringUtil.isBlank(request.getProductInfo().getTakeTime())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"需耗时不能为空");
		}
	}
}
