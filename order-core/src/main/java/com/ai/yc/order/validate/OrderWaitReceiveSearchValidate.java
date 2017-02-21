package com.ai.yc.order.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.orderreceivesearch.param.OrderWaitReceiveSearchRequest;
import com.alibaba.fastjson.JSON;

@Service
public class OrderWaitReceiveSearchValidate {
	@Autowired
	private OrderSubmissionParam orderSubmissionParam;

	public void validate(OrderWaitReceiveSearchRequest request) {
		this.validateNull(request);
	}

	public void validateNull(OrderWaitReceiveSearchRequest request) {
		// 总请求参数校验
		if (null == request) {
			this.newException("请求参数不能为空");
		}
		/**
		 * 业务标识 0:国内业务 1：国际业务
		 */
		// flag;
//		if (StringUtil.isBlank(request.getFlag())) {
//			this.newException("业务标识不能为空");
//		} else {
//			String flag = this.orderSubmissionParam.getFlagMap().get(request.getFlag());
//			if (StringUtil.isBlank(flag)) {
//				this.newException("业务标识范围不正确，请参考" + JSON.toJSONString(this.orderSubmissionParam.getFlagMap()));
//			}
//		}
		/**
		 * 译员级别 跟 订单级别一样
		 */
		if (StringUtil.isBlank(request.getInterperLevel())) {
			this.newException("译员级别不能为空");
		} else {
			String flag = this.orderSubmissionParam.getOrderLevelMap().get(request.getInterperLevel());
			if (StringUtil.isBlank(flag)) {
				this.newException(
						"译员级别范围不正确，请参考" + JSON.toJSONString(this.orderSubmissionParam.getOrderLevelMap()));
			}
		}
		/**
		 * 译员类型:"0：普通译员 1：LSP译员"
		 */
		/*if (StringUtil.isBlank(request.getInterperType())) {
			this.newException("译员类型不能为空");
		} else {
			String flag = this.orderSubmissionParam.getInterperTypeMap().get(request.getInterperType());
			if (StringUtil.isBlank(flag)) {
				this.newException(
						"译员类型范围不正确，请参考" + JSON.toJSONString(this.orderSubmissionParam.getInterperTypeMap()));
			}
		}*/
		if(null == request.getPageNo() || request.getPageNo() == 0){
			this.newException("页码不能为空或0");
		}
		if(null == request.getPageSize() || request.getPageSize() == 0){
			this.newException("分页大小不能为空或0");
		}
	}

	/**
	 * 异常消息打印
	 */
	public void newException(String errorMessage) {
		throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, errorMessage);
	}
}
