package com.ai.yc.order.util;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.orderclose.param.OrderCancelRequest;
import com.ai.yc.order.api.orderevaluation.param.OrderEvaluationRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrdCountRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrderRequest;
import com.ai.yc.order.api.orderrefund.param.OrderRefundRequest;
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
	 * 退款审核订单校验
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
		if(StringUtil.isBlank(request.getBusiType())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"业务类型不能为空");
		}
		if(StringUtil.isBlank(request.getDisplayFlag())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"客户端显示状态不能为空");
		}
	}
}
