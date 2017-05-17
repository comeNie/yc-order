package com.ai.yc.order.validate;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.updateorder.param.UContactsVo;
import com.ai.yc.order.api.updateorder.param.UOrderFeeVo;
import com.ai.yc.order.api.updateorder.param.UpdateOrderRequest;
import com.ai.yc.order.api.updateorder.param.UpdateProdFileRequest;

/**
 * @Description: 订单信息修改校验
 * @author hougang@asiainfo.com
 * @date 2016年11月8日 上午10:26:21 
 * @version V1.0
 */
@Component("updateOrderValidate")
public class UpdateOrderValidate {
	public void validateFlie(UpdateProdFileRequest req){
		if(req==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数不能为空");
		}
		if(req.getProdFileId()==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "产品明细文件ID不能为空");
		}
	}
	public void validate(UpdateOrderRequest req){
		if(req==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数不能为空");
		}
		if(req.getOrderId()==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "订单ID不能为空");
		}
		if(StringUtil.isBlank(req.getOperId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "操作工号不能为空");
		}
		UOrderFeeVo orderFee = req.getOrderFee();
		if(orderFee!=null){
			if(StringUtil.isBlank(orderFee.getCurrencyUnit())){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "费用币种不能为空");
			}
			if(orderFee.getTotalFee()==null){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "总费用不能为空");
			}
			if(orderFee.getTotalFee()<0){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "总费用不合法");
			}
			if(orderFee.getDiscountFee()==null){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "总优惠金额不能为空");
			}
			if(orderFee.getDiscountFee()<0){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "总优惠金额不合法");
			}
			if(orderFee.getOperDiscountFee()==null){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "减免费用不能为空");
			}
			if(orderFee.getOperDiscountFee()<0){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "减免费用不合法");
			}
			if(orderFee.getAdjustFee()==null){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "应收费用不能为空");
			}
			if(orderFee.getAdjustFee()<0){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "应收费用不合法");
			}
			if(orderFee.getPaidFee()==null){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "总实收费用 不能为空");
			}
			if(orderFee.getPaidFee()<0){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "总实收费用 不合法");
			}
			if(orderFee.getPayFee()==null){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "总待收费用不能为空");
			}
			if(StringUtil.isBlank(orderFee.getUpdateOperId())){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "操作工号不能为空");
			}
			
		}
		UContactsVo contacts = req.getContacts();
		if(contacts!=null){
			if(contacts.getContactName()==null){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "联系人名称不能为空");
			}
			if(contacts.getContactTel()==null){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "联系人电话不能为空");
			}
			if(contacts.getContactEmail()==null){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "联系人邮箱不能为空");
			}
		}
	}

}
