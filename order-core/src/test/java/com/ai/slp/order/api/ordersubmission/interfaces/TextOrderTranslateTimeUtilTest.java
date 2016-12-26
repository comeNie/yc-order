package com.ai.slp.order.api.ordersubmission.interfaces;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.validate.TextOrderTranslateTimeUtil;

public class TextOrderTranslateTimeUtilTest extends BaseTest {
	@Autowired
	private TextOrderTranslateTimeUtil textOrderTranslateTimeUtil;
	@Test
	public void text(){
		Integer sum = this.textOrderTranslateTimeUtil.textOrderTranslateTime("100210", "Y", 1200L);
		log.info("sum:"+sum);
	}
}
