package com.ai.yc.order.api.translatesave.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.translatesave.interfaces.ITranslateSaveSV;
import com.ai.yc.order.api.translatesave.param.SaveTranslateInfoRequest;
import com.ai.yc.order.service.business.interfaces.ITranslateSaveBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Description: 保存翻译内容
 * @author hougang@asiainfo.com
 * @date 2016年11月17日 下午8:14:21 
 * @version V1.0
 */
@Service
public class TranslateSaveSVImpl implements ITranslateSaveSV {
	
	@Autowired
	private ITranslateSaveBusiSV iTranslateSaveBusiSV;

	@Override
	public BaseResponse saveTranslateInfo(SaveTranslateInfoRequest request)
			throws BusinessException, SystemException {
		if(request==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数不能为空");
		}
		if(request.getOrderId()==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单号不能为空");
		}
		if(StringUtil.isBlank(request.getTranslateInfo())&&CollectionUtil.isEmpty(request.getFileVos())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "翻译内容不能为空");
		}
		return iTranslateSaveBusiSV.saveTranslateInfo(request);
	}

}
