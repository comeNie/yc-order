package com.ai.slp.order.search;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.order.api.BaseTest;
import com.ai.yc.order.api.sesdata.interfaces.ISesDataUpdateSV;
import com.alibaba.fastjson.JSON;

public class SESdataUpdateTest extends BaseTest{
	@Autowired
	private ISesDataUpdateSV iSesDataUpdateSV;
	@Test
	public void updateSes(){
		BaseResponse response = this.iSesDataUpdateSV.updateSesData(2000000024195005l);
		log.info("response:"+JSON.toJSONString(response));
	}
}
