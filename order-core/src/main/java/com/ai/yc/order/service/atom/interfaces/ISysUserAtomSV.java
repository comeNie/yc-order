package com.ai.yc.order.service.atom.interfaces;

import com.ai.yc.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.yc.common.api.sysuser.param.SysUserQueryResponse;

public interface ISysUserAtomSV {
	
	SysUserQueryResponse queryUserInfo(SysUserQueryRequest req);

}
