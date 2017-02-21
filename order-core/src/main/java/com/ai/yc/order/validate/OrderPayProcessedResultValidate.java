package com.ai.yc.order.validate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.yc.order.api.orderpay.param.OrderPayProcessedResultRequest;
import com.alibaba.fastjson.JSON;

@Service
public class OrderPayProcessedResultValidate {
	public static final Logger log = LogManager.getLogger(OrderPayProcessedResultValidate.class);
	@Autowired
	private OrderSubmissionParam orderSubmissionParam;
	/**
	 * 总校验方法 订单支付结果处理数据校验
	 */
	public void validate(OrderPayProcessedResultRequest request) {
		this.validateNull(request);
	}

	public void validateNull(OrderPayProcessedResultRequest request) {
		// 总请求参数校验
		if (null == request) {
			this.newException("请求参数不能为空");
		}
		//
		this.validateBaseInfo(request);
		this.validateProdInfo(request);
		this.validateFeeInfo(request);
		//

	}

	// 基本信息校验
	public void validateBaseInfo(OrderPayProcessedResultRequest request) {
		if (null == request.getBaseInfo()) {
			this.newException("订单基本信息不能为空");
		}
		// 订单ID
		if(null == request.getBaseInfo().getOrderId()){
			this.newException("订单id不能为空");
		}
		// 订单类型
		if(StringUtil.isBlank(request.getBaseInfo().getOrderType())){
			this.newException("订单类型不能为空");
		}else{
			String flag = this.orderSubmissionParam.getOrderTypeMap().get(request.getBaseInfo().getOrderType());
			if(StringUtil.isBlank(flag)){
				this.newException("订单类型范围不正确，请参考"+JSON.toJSONString(this.orderSubmissionParam.getOrderTypeMap()));
			}
		}
		// 用户类型
		if(StringUtil.isBlank(request.getBaseInfo().getUserType())){
			this.newException("用户类型不能为空");
		}else{
			String flag = this.orderSubmissionParam.getUserTypeMap().get(request.getBaseInfo().getUserType());
			if(StringUtil.isBlank(flag)){
				this.newException("用户类型范围不正确，请参考"+JSON.toJSONString(this.orderSubmissionParam.getUserTypeMap()));
			}
		}
		// 用户ID
		if(StringUtil.isBlank(request.getBaseInfo().getUserId())){
			this.newException("用户Id不能为空");
		}
		// 企业ID
		
		// 账户ID
//		if(null == request.getBaseInfo().getAccountId()){
//			this.newException("账户Id不能为空");
//		}
		// 订单状态
		
		// 客户端显示状态

	}

	// 产品信息校验
	public void validateProdInfo(OrderPayProcessedResultRequest request) {
		if (null == request.getProdInfo()) {
			this.newException("产品信息不能为空");
		}
		if(null == request.getProdInfo().getStateTime()){
			this.newException("订单支付完成时间信息不能为空");
		}
	}

	// 费用信息校验
	public void validateFeeInfo(OrderPayProcessedResultRequest request) {
		if (null == request.getFeeInfo()) {
			this.newException("费用信息不能为空");
		}
		
		// 支付方式
		if(StringUtil.isBlank(request.getFeeInfo().getPayStyle())){
			this.newException("支付方式不能为空");
		}else{
			String flag = this.orderSubmissionParam.getPayStyleMap().get(request.getFeeInfo().getPayStyle());
			if(StringUtil.isBlank(flag)){
				this.newException("支付方式范围不正确，请参考"+JSON.toJSONString(this.orderSubmissionParam.getPayStyleMap()));
			}
		}
		// 总费用
		if(null == request.getFeeInfo().getTotalFee() || request.getFeeInfo().getTotalFee() == 0){
			this.newException("总费用信息不能为空或0");
		}
		// 总优惠金额
		// 总减免费用
		// 减免原因
		// 总应收费用
		// 总实收费用
		// 总已收费用
		// 支付时间
		if(null == request.getFeeInfo().getPayTime()){
			this.newException("支付时间不能为空");
		}
		if(StringUtil.isBlank(request.getFeeInfo().getExternalId())){
			this.newException("外部支付流水号不能为空");
		}
		// 赠送积分


	}

	/**
	 * 异常消息打印
	 */
	public void newException(String errorMessage) {
		throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, errorMessage);
	}
}
