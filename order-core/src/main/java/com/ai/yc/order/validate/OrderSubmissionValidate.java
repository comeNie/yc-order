package com.ai.yc.order.validate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionRequest;
import com.alibaba.fastjson.JSON;
@Service
public class OrderSubmissionValidate {
	@Autowired
	private OrderSubmissionParam orderSubmissionParam;
	/**
	 * 文本翻译下单校验
	 */
	public static String textTraslateOrder(OrderSubmissionRequest request) {
		return null;
	}

	/**
	 * 文档翻译下单校验
	 */
	public static String docTranslateOrder(OrderSubmissionRequest request) {
		return null;
	}

	/**
	 * 口译翻译下单校验
	 */
	public static String interpretOrder(OrderSubmissionRequest request) {
		return null;

	}

	/**
	 * 校验空值
	 */
	public void validateNull(OrderSubmissionRequest request) {
		//总请求参数校验
		if (null == request) {
			this.newException("请求参数不能为空");
		}
		//基本信息校验
		if (null == request.getBaseInfo()) {
			this.newException("订单基本信息不能为空");
		} else {
			/**
			 * 业务标识 0:国内业务 1：国际业务
			 */
			// flag;
			if (StringUtil.isBlank(request.getBaseInfo().getFlag())) {
				this.newException("业务标识不能为空");
			}else{
				String flag = this.orderSubmissionParam.getFlagMap().get(request.getBaseInfo().getFlag());
				if(StringUtil.isBlank(flag)){
					this.newException("业务标识范围不正确，请参考"+JSON.toJSONString(this.orderSubmissionParam.getFlagMap()));
				}
			}
			/**
			 * 订单来源 0：PC-中文站 1：PC-汉语站 2：百度 3：金山 4：找翻译 5：WAP-中文 6：WAP-英语 7：微信助手
			 * 
			 */
			// chlId;
			if (StringUtil.isBlank(request.getBaseInfo().getChlId())) {
				this.newException("订单来源不能为空");
			}else{
				String flag = this.orderSubmissionParam.getChlIdMap().get(request.getBaseInfo().getChlId());
				if(StringUtil.isBlank(flag)){
					this.newException("订单来源范围不正确，请参考"+JSON.toJSONString(this.orderSubmissionParam.getChlIdMap()));
				}
			}
			/**
			 * 订单类型 "订单类型： 1：个人订单 2：企业订单 "
			 */
			// orderType;
			if (StringUtil.isBlank(request.getBaseInfo().getOrderType())) {
				this.newException("订单类型不能为空");
			}else{
				String flag = this.orderSubmissionParam.getOrderTypeMap().get(request.getBaseInfo().getOrderType());
				if(StringUtil.isBlank(flag)){
					this.newException("订单类型范围不正确，请参考"+JSON.toJSONString(this.orderSubmissionParam.getOrderTypeMap()));
				}
			}
			/**
			 * 翻译类型 "0：快速翻译 1：文档翻译 2：口译翻译"
			 * 
			 */
			// translateType;
			if (StringUtil.isBlank(request.getBaseInfo().getTranslateType())) {
				this.newException("翻译类型不能为空");
			}else{
				String flag = this.orderSubmissionParam.getTranslateTypeMap().get(request.getBaseInfo().getTranslateType());
				if(StringUtil.isBlank(flag)){
					this.newException("翻译类型范围不正确，请参考"+JSON.toJSONString(this.orderSubmissionParam.getTranslateTypeMap()));
				}
			}

			/**
			 * 翻译主题 快速翻译：取文本前15个字 文档翻译：取第一个文件名称 口译翻译：用户填写
			 */
			// translateName;
			if (StringUtil.isBlank(request.getBaseInfo().getTranslateName())) {
				this.newException("翻译主题不能为空");
			}
			/**
			 * 业务类型 "1：正常单 2：退费单"
			 */
			// busiType;
			if (StringUtil.isBlank(request.getBaseInfo().getBusiType())) {
				this.newException("业务类型不能为空");
			}else{
				String flag = this.orderSubmissionParam.getBusiTypeMap().get(request.getBaseInfo().getBusiType());
				if(StringUtil.isBlank(flag)){
					this.newException("业务类型范围不正确，请参考"+JSON.toJSONString(this.orderSubmissionParam.getBusiTypeMap()));
				}
			}
			/**
			 * 订单级别
			 */
			// orderLevel;
			if (StringUtil.isBlank(request.getBaseInfo().getOrderLevel())) {
				this.newException("订单级别不能为空");
			}else{
				String flag = this.orderSubmissionParam.getOrderLevelMap().get(request.getBaseInfo().getOrderLevel());
				if(StringUtil.isBlank(flag)){
					this.newException("订单级别范围不正确，请参考"+JSON.toJSONString(this.orderSubmissionParam.getOrderLevelMap()));
				}
			}
			/**
			 * 报价标识 "0：系统自动报价 1：人工报价"
			 * 
			 */
			// subFlag;
			if (StringUtil.isBlank(request.getBaseInfo().getSubFlag())) {
				this.newException("报价标识不能为空");
			}else{
				String flag = this.orderSubmissionParam.getSubFlagMap().get(request.getBaseInfo().getSubFlag());
				if(StringUtil.isBlank(flag)){
					this.newException("报价标识范围不正确，请参考"+JSON.toJSONString(this.orderSubmissionParam.getSubFlagMap()));
				}
			}
			/**
			 * 用户类型 "10：个人 11：企业 12：代理人 "
			 * 
			 */
			// userType;
			if (StringUtil.isBlank(request.getBaseInfo().getUserType())) {
				this.newException("用户类型不能为空");
			}else{
				String flag = this.orderSubmissionParam.getUserTypeMap().get(request.getBaseInfo().getUserType());
				if(StringUtil.isBlank(flag)){
					this.newException("用户类型范围不正确，请参考"+JSON.toJSONString(this.orderSubmissionParam.getUserTypeMap()));
				}
			}
			/**
			 * 用户ID
			 */
			// userId;
			if (StringUtil.isBlank(request.getBaseInfo().getUserId())) {
				this.newException("用户Id不能为空");
			}
			/**
			 * 企业ID
			 */
			// corporaId;

			/**
			 * 账户ID
			 */
			// accountId;

			// 时区
			/**
			 * 下单时间 取系统时间
			 */
			// orderTime;
			if (null == request.getBaseInfo().getOrderTime()) {
				this.newException("下单时间不能为空");
			}
			/**
			 * 省份
			 */
			// provinceCode;
			/**
			 * 地市
			 */
			// cityCode;
			/**
			 * 订单简要信息
			 */
			// orderDesc;
			/**
			 * 订单关键词
			 */
			// keywords;
			/**
			 * 订单备注
			 */
			// remark;

		}
		//产品信息校验
		if(null == request.getProductInfo()){
			this.newException("产品信息不能为空");
		}else{
			/**
			 * 翻译类型 "0：快速翻译 1：文档翻译 2：口译翻译"
			 * 
			 */
			// translateType;
			if (StringUtil.isBlank(request.getBaseInfo().getTranslateType())) {
				this.newException("翻译类型不能为空");
			}

			/**
			 * 翻译主题 快速翻译：取文本前15个字 文档翻译：取第一个文件名称 口译翻译：用户填写
			 */
			// translateName;
			if (StringUtil.isBlank(request.getBaseInfo().getTranslateName())) {
				this.newException("翻译主题不能为空");
			}
		}

	}

	/**
	 * 异常消息打印
	 */
	public void newException(String errorMessage) {
		throw new BusinessException("999999", errorMessage);
	}
	
}
