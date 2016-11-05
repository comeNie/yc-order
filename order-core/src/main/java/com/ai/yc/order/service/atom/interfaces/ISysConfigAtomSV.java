package com.ai.yc.order.service.atom.interfaces;

import com.ai.platform.common.api.sysdomain.param.QuerySysDomainDetailsRes;
import com.ai.platform.common.api.sysduad.param.QuerySysDuadDetailsRes;
import com.ai.platform.common.api.syspurpose.param.QuerySysPurposeDetailsRes;



/**
 * @author hougang@asiainfo.com
 * @date 2016年11月2日 下午3:49:11 
 * @version V1.0
 */
public interface ISysConfigAtomSV {
	
	QuerySysDuadDetailsRes querySysDuadDetails(String duadId);
	
	QuerySysPurposeDetailsRes querySysPurposeDetails(String purposeId);
	
	QuerySysDomainDetailsRes querySysDomainDetails(String domainId);

}
