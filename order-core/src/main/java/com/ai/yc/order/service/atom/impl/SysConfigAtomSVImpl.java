package com.ai.yc.order.service.atom.impl;

import org.springframework.stereotype.Service;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.common.api.sysdomain.interfaces.IQuerySysDomainSV;
import com.ai.yc.common.api.sysdomain.param.QuerySysDomainDetailsRes;
import com.ai.yc.common.api.sysduad.interfaces.IQuerySysDuadSV;
import com.ai.yc.common.api.sysduad.param.QuerySysDuadDetailsRes;
import com.ai.yc.common.api.syspurpose.interfaces.IQuerySysPurposeSV;
import com.ai.yc.common.api.syspurpose.param.QuerySysPurposeDetailsRes;
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
		if(StringUtil.isBlank(duadId)){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "语言对ID不能为空");
		}
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
		if(StringUtil.isBlank(purposeId)){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "用途ID不能为空");
		}
		QuerySysPurposeDetailsRes purpose = DubboConsumerFactory.getService(IQuerySysPurposeSV.class).querySysPurposeDetails(purposeId);
		if(purpose==null){
			throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "系统异常，请稍后重试");
		}
		if(purpose.getResponseHeader()!=null&&!purpose.getResponseHeader().getIsSuccess()){
			throw new BusinessException(purpose.getResponseHeader().getResultCode(), purpose.getResponseHeader().getResultMessage());
		}
		return purpose;
	}

	@Override
	public QuerySysDomainDetailsRes querySysDomainDetails(String domainId) {
		if(StringUtil.isBlank(domainId)){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "领域ID不能为空");
		}
		QuerySysDomainDetailsRes domain = DubboConsumerFactory.getService(IQuerySysDomainSV.class).querySysDomainDetails(domainId);
		if(domain==null){
			throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "系统异常，请稍后重试");
		}
		if(domain.getResponseHeader()!=null&&!domain.getResponseHeader().getIsSuccess()){
			throw new BusinessException(domain.getResponseHeader().getResultCode(), domain.getResponseHeader().getResultMessage());
		}
		return domain;
	}

}
