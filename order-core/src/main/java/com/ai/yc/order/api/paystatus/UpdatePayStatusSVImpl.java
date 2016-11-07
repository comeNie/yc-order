package com.ai.yc.order.api.paystatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.paystatus.interfaces.IUpdatePayStatusSV;
import com.ai.yc.order.api.paystatus.param.UpdatePayStatusRequest;
import com.ai.yc.order.api.paystatus.param.UpdatePayStatusResponse;
import com.ai.yc.order.service.business.interfaces.IUpdatePayStatusBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Description: 修改支付状态
 * @author hougang@asiainfo.com
 * @date 2016年11月7日 上午11:13:54 
 * @version V1.0
 */
@Service
@Component
public class UpdatePayStatusSVImpl implements IUpdatePayStatusSV{
	
	@Autowired
	private IUpdatePayStatusBusiSV iUpdatePayStatusBusiSV;

	@Override
	public UpdatePayStatusResponse updatePayStatus(UpdatePayStatusRequest req)
			throws BusinessException, SystemException {
		if(req==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数不能为空");
		}
		if(req.getOrderId()==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单ID不能为空");
		}
		if(StringUtil.isBlank(req.getOperId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "操作工号不能为空");
		}
		if(StringUtil.isBlank(req.getOperName())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "操作人用户名不能为空");
		}
		if(req.getOrderFee()==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单费用不能为空");
		}
		if(StringUtil.isBlank(req.getOrderFee().getCurrencyUnit())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "费用币种不能为空");
		}
		if(req.getOrderFee().getTotalFee()==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "总费用不能为空");
		}
		if(req.getOrderFee().getDiscountFee()==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "总优惠金额不能为空");
		}
		if(req.getOrderFee().getOperDiscountFee()==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "减免费用不能为空");
		}
		if(req.getOrderFee().getAdjustFee()==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "应收费用不能为空");
		}
		if(req.getOrderFee().getPaidFee()==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "总实收费用 不能为空");
		}
		if(req.getOrderFee().getPayFee()==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "总待收费用不能为空");
		}
		if(StringUtil.isBlank(req.getOrderFee().getPayStyle())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "支付方式不能为空");
		}
		if(StringUtil.isBlank(req.getOrderFee().getRemark())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "支付备注不能为空");
		}
		return iUpdatePayStatusBusiSV.updatePayStatus(req);
	}

}
