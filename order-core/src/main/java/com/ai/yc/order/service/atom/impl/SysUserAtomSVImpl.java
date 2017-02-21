package com.ai.yc.order.service.atom.impl;

import org.springframework.stereotype.Service;

import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.yc.common.api.sysuser.interfaces.ISysUserQuerySV;
import com.ai.yc.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.yc.common.api.sysuser.param.SysUserQueryResponse;
import com.ai.yc.order.service.atom.interfaces.ISysUserAtomSV;

@Service
public class SysUserAtomSVImpl implements ISysUserAtomSV {

	@Override
	public SysUserQueryResponse queryUserInfo(SysUserQueryRequest req) {
		SysUserQueryResponse resp = DubboConsumerFactory.getService(ISysUserQuerySV.class).queryUserInfo(req);
		if(resp!=null&&resp.getResponseHeader().isSuccess()){
			return resp;
		}
		return null;
	}

}
