package com.ai.yc.order.constants;

import java.math.BigDecimal;

public final class OrdersConstants {
	
	public final static class TranslatePrice {
		private TranslatePrice() {}
		
		public final static BigDecimal BASE_DOLLAR = new BigDecimal(15);
		
		public final static BigDecimal BASE_RMB = new BigDecimal(100);
		
        /**
         * 币种  1：RMB 2：$
         */
        public final static String DOLLAR = "2";
		
		public final static String RMB = "1";
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
		public final static String  ORDINARY = "100210";

		/**
		 * 专业级
		 */
		public final static String PERFESSION = "100220";

		/**
		 * 出版集
		 */
		public final static String PUBLISH = "100230";

	}
}
