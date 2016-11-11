package com.ai.yc.order.util;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.orderclose.param.OrderCancelRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrdCountRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrderRequest;
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
		if (condition.getOrderId() == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单ID不能为空");
		}
		if (StringUtil.isBlank(condition.getOperId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "操作员ID不能为空");
		}
		if (StringUtil.isBlank(condition.getState())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "状态不能为空");
		}
	}
}
