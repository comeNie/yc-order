package com.ai.yc.order.api.test.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.yc.order.api.test.param.TestRequest;
import com.ai.yc.order.api.test.param.TestResponse;

@Path("/TestSV")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface TestSV {
	/**
     * 测试接口
     * 
     * @param vo
     *            路由基本信息
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangzd
     * @ApiDocMethod
     * @ApiCode TestSV-001
     * @RestRelativeURL TestSV/testResponse
     */
	@POST
	@Path("/testResponse")
	public TestResponse testResponse(TestRequest request)throws BusinessException,SystemException;
}
