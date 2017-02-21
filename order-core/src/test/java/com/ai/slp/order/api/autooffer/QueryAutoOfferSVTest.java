package com.ai.slp.order.api.autooffer;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.autooffer.interfaces.IQueryAutoOfferSV;
import com.ai.yc.order.api.autooffer.param.QueryAutoOfferReq;
import com.ai.yc.order.api.autooffer.param.QueryAutoOfferRes;

public class QueryAutoOfferSVTest extends BaseTest {

	@Autowired
	private IQueryAutoOfferSV iQueryAutoOfferSV;

	@Test
	public void queryAutoOffer() {
		QueryAutoOfferReq req = new QueryAutoOfferReq();
		
		//[{"duadId":"8","language":"zh_CN","purposeId":"1","translateLevel":"100220","urgent":false,"wordNum":1}]

		req.setDuadId("8");
		req.setLanguage("zh_CN");
		req.setWordNum(1);
		req.setPurposeId("1");
		req.setTranslateLevel("100220");
		req.setUrgent(false);
		QueryAutoOfferRes res = iQueryAutoOfferSV.queryAutoOffer(req);
		double   f   =   111231.5585; 
		BigDecimal   b   =   new   BigDecimal(1112.3355); 
		
		System.out.println("保留两位小数：" + b.setScale(2, BigDecimal.ROUND_HALF_UP));
		System.out.println("res:" + res.getPrice());
	}

}
