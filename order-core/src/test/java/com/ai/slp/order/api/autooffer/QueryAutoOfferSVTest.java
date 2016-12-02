package com.ai.slp.order.api.autooffer;

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
	public void queryAutoOffer(){
		QueryAutoOfferReq req = new QueryAutoOfferReq();
		req.setDuadId("8");
		req.setLanguage("zh_CN");
		req.setWordNum(1);
		req.setPurposeId("1");
		req.setTranslateLevel("100220");
		req.setUrgent(false);
		QueryAutoOfferRes res  = iQueryAutoOfferSV.queryAutoOffer(req);
		System.out.println("res:"+res.getPrice());
	}

}
