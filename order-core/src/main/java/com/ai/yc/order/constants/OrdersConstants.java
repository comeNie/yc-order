package com.ai.yc.order.constants;

import java.math.BigDecimal;

public final class OrdersConstants {
	public final static String TENANT_ID = "yeecloud";

	public final static class TranslatePrice {
		private TranslatePrice() {
		}

		public final static BigDecimal BASE_DOLLAR = new BigDecimal(15);

		public final static BigDecimal BASE_RMB = new BigDecimal(100);

		/**
		 * 币种 1：RMB 2：$
		 */
		public final static String DOLLAR = "2";

		public final static String RMB = "1";
	}

	public final static class OrdOdFeeTotal {
		private OrdOdFeeTotal() {
		}

		/**
		 * in:收入 out:支出
		 */
		public final static String PAY_FLAG_IN = "in";

		public final static String PAY_FLAG_OUT = "out";
	}

	public final static class TranslateLevel {

		private TranslateLevel() {
		}

		/**
		 * 陪同翻译
		 */
		public final static String ACCOMAPANY_INTERPRETATION = "100110";

		/**
		 * 交替传译
		 */
		public final static String CONSECUTIVE_INTERPRETATION = "100120";

		/**
		 * 同声翻译
		 */
		public final static String SIMULTANEOUS_INTERPRETATION = "100130";

		/**
		 * 标准级或普通级
		 */
		public final static String ORDINARY = "100210";

		/**
		 * 专业级
		 */
		public final static String PERFESSION = "100220";

		/**
		 * 出版集
		 */
		public final static String PUBLISH = "100230";

	}

	/**
	 * 翻译类型
	 */
	public final static class TranslateType {

		private TranslateType() {
		}

		/**
		 * 文本翻译
		 */
		public static final String ORDER_TYPE_FAST = "0";

		/**
		 * 文档翻译
		 */
		public static final String ORDER_TYPE_DOC = "1";

		/**
		 * 口译
		 */
		public static final String ORDER_TYPE_ORAL = "2";
	}

	/*
	 * 订单状态(后厂)
	 */
	public final static class OrderState {
		private OrderState() {
		}

		/**
		 * 提交
		 */
		public final static String STATE_COMMIT = "10";

		/**
		 * 待支付
		 */
		public final static String STATE_WAIT_PAY = "11";

		/**
		 * 已支付
		 */
		public final static String STATE_PAIED = "12";

		/**
		 * 待报价
		 */
		public final static String STATE_WAIT_OFFER = "13";

		/**
		 * 待领取
		 */
		public final static String STATE_WAIT_RECEIVE = "20";

		/**
		 * 已领取
		 */
		public final static String STATE_RECEIVED = "21";

		/**
		 * 已分配
		 */
		public final static String STATE_DISTRIBUTION = "211";

		/**
		 * 翻译中
		 */
		public final static String STATE_TRASLATING = "23";

		/**
		 * 翻译完成 已提交
		 */
		public final static String STATE_TRASLATE_FINISHED = "23";

		/**
		 * 翻译修改中
		 */
		public final static String STATE_TRASLATE_UPDATING = "23";
		/**
		 * 取消
		 */
		public final static String CANCEL_STATE = "91";

	}

	/*
	 * 客户端显示状态
	 */
	public final static class OrderDisplayFlag {
		private OrderDisplayFlag() {
		}

		/**
		 * 待支付
		 */
		public final static String FLAG_WAIT_PAY = "11";

		/**
		 * 待报价
		 */
		public final static String FLAG_WAIT_OFFER = "13";

		/**
		 * 翻译中
		 */
		public final static String FLAG_TRASLATING = "23";

		/**
		 * 待确认
		 */
		public final static String FLAG_WAIT_OK = "50";

		/**
		 * 评论
		 */
		public final static String FLAG_WAIT_COMMENT = "52";

		/**
		 * 完成
		 */
		public final static String FLAG_FINISHED = "90";

		/**
		 * 取消、关闭
		 */
		public final static String FLAG_CANCEL = "91";

		/**
		 * 已退款
		 */
		public final static String FLAG_REFUNDED = "92";

	}

	/*
	 * 操作机构
	 */
	public final static class OrgID {
		private OrgID() {
		}

		/**
		 * 用户操作
		 */
		public final static String ORG_ID_USER = "0";

		/**
		 * 系统操作
		 */
		public final static String ORG_ID_SYS = "1";
	}

	public static final class OrdOdStateChg {

		/**
		 * 處理信息 Date: 2016年11月7日 <br>
		 * Copyright (c) 2016 asiainfo.com <br>
		 * 
		 * @author zhanglh
		 */
		public static class ChgDesc {
			/**
			 * 订单－取消
			 */
			public static final String ORDER_TO_CANCEL = "您的订单已取消";

		}

	}
	
	public static final class OrdOdProd{
		public static class ProdDetalState{
			public static final String UNTREATED = "0";
		}
	}
}
