package com.ai.yc.order.service.atom.impl;

import org.springframework.stereotype.Service;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.platform.common.api.sysduad.interfaces.IQuerySysDuadSV;
import com.ai.platform.common.api.sysduad.param.QuerySysDuadDetailsRes;
import com.ai.platform.common.api.syspurpose.interfaces.IQuerySysPurposeSV;
import com.ai.platform.common.api.syspurpose.param.QuerySysPurposeDetailsRes;
import com.ai.yc.order.service.atom.interfaces.ISysConfigAtomSV;

/**
 * @Description: 公共配置
 * @author hougang@asiainfo.com
 * @date 2016年11月2日 下午3:48:22 
 * @version V1.0
 */
@Service
public class SysConfigAtomSVImpl implements ISysConfigAtomSV {

	@Override
	public QuerySysDuadDetailsRes querySysDuadDetails(String duadId) {
		QuerySysDuadDetailsRes duad = DubboConsumerFactory.getService(IQuerySysDuadSV.class).querySysDuadDetails(duadId);
		if(duad==null){
			throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "系统异常，请稍后重试");
		}
		if(duad.getResponseHeader()!=null&&!duad.getResponseHeader().getIsSuccess()){
			throw new BusinessException(duad.getResponseHeader().getResultCode(), duad.getResponseHeader().getResultMessage());
		}
		return duad;
	}

	@Override
	public QuerySysPurposeDetailsRes querySysPurposeDetails(String purposeId) {
		QuerySysPurposeDetailsRes purpose = DubboConsumerFactory.getService(IQuerySysPurposeSV.class).querySysPurposeDetails(purposeId);
		if(purpose==null){
			throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "系统异常，请稍后重试");
		}
		if(purpose.getResponseHeader()!=null&&!purpose.getResponseHeader().getIsSuccess()){
			throw new BusinessException(purpose.getResponseHeader().getResultCode(), purpose.getResponseHeader().getResultMessage());
		}
		return purpose;
	}

}
