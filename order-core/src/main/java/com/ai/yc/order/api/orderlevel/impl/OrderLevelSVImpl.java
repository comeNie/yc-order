package com.ai.yc.order.api.orderlevel.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.orderlevel.interfaces.IOrderLevelSV;
import com.ai.yc.order.api.orderlevel.param.OrderLevelRequest;
import com.ai.yc.order.api.orderlevel.param.OrderLevelResponse;
import com.ai.yc.order.orderlevel.rule.OrderLevelUtil;
import com.ai.yc.order.validate.OrderSubmissionParam;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;

@Service
@Component
public class OrderLevelSVImpl implements IOrderLevelSV {
	@Autowired
	private OrderLevelUtil orderLevelUtil;// 订单级别算法类
	@Autowired
	private OrderSubmissionParam orderSubmissionParam;

	@Override
	public OrderLevelResponse getOrderLevel(OrderLevelRequest request) throws BusinessException, SystemException {
		OrderLevelResponse response = new OrderLevelResponse();
		//
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			if (null == request) {
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
			}
			if (null == request.getTotalFee() || request.getTotalFee() == 0) {
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "总费用不能为空或0");
			}
			if (StringUtil.isBlank(request.getTranslateLevel())) {

				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "翻译级别不能为空");
			} else {
				String flag = this.orderSubmissionParam.getTranslateLevelMap().get(request.getTranslateLevel());
				if (StringUtil.isBlank(flag)) {
					throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR,
							"翻译级别范围不正确，请参考" + JSON.toJSONString(this.orderSubmissionParam.getTranslateLevelMap()));
				}
			}

			if (StringUtil.isBlank(request.getTranslateType())) {

				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "翻译类型不能为空");
			} else {
				String flag = this.orderSubmissionParam.getTranslateTypeMap().get(request.getTranslateType());
				if (StringUtil.isBlank(flag)) {
					throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR,
							"翻译类型范围不正确，请参考" + JSON.toJSONString(this.orderSubmissionParam.getTranslateTypeMap()));
				}
			}

			if (StringUtil.isBlank(request.getIsUrgent())) {

				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "是否加急不能为空");
			} else {
				String flag = this.orderSubmissionParam.getIsUrgentMap().get(request.getIsUrgent());
				if (StringUtil.isBlank(flag)) {
					throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR,
							"是否加急范围不正确，请参考" + JSON.toJSONString(this.orderSubmissionParam.getIsUrgentMap()));
				}
			}

			String orderLevel = this.orderLevelUtil.orderLevel(request.getTotalFee(), request.getTranslateLevel(),
					request.getTranslateType(), request.getIsUrgent());
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("订单级别计算成功");
			response.setResponseHeader(responseHeader);
			response.setOrderLevel(orderLevel);

		} catch (BusinessException | SystemException e) {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			response.setResponseHeader(responseHeader);
		}
		return response;
	}

}
