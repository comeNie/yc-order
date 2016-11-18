package com.ai.yc.order.api.autooffer.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.autooffer.interfaces.IQueryAutoOfferSV;
import com.ai.yc.order.api.autooffer.param.QueryAutoOfferReq;
import com.ai.yc.order.api.autooffer.param.QueryAutoOfferRes;
import com.ai.yc.order.service.business.interfaces.IQueryAutoOfferBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Description: 查询系统自动报价服务
 * @author hougang@asiainfo.com
 * @date 2016年11月2日 下午2:19:40 
 * @version V1.0
 */
@Service
public class QueryAutoOfferSVImpl implements IQueryAutoOfferSV {
	
	@Autowired
	private transient IQueryAutoOfferBusiSV iQueryAutoOfferBusiSV;

	@Override
	public QueryAutoOfferRes queryAutoOffer(QueryAutoOfferReq req)
			throws BusinessException, SystemException {
		if(req==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数不能为空");
		}
		if(StringUtil.isBlank(req.getLanguage())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "站点语言不能为空");
		}
		if(req.getWordNum()<=0){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "字数不合法");
		}
		if(StringUtil.isBlank(req.getDuadId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "语言对ID不能为空");
		}
		if(StringUtil.isBlank(req.getPurposeId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "用途ID不能为空");
		}
		if(StringUtil.isBlank(req.getTranslateLevel())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "翻译级别不能为空");
		}
		return iQueryAutoOfferBusiSV.queryAutoOffer(req);
	}

}
