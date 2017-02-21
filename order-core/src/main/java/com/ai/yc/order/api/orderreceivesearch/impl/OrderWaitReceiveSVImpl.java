package com.ai.yc.order.api.orderreceivesearch.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.paas.ipaas.search.vo.Result;
import com.ai.paas.ipaas.search.vo.SearchCriteria;
import com.ai.paas.ipaas.search.vo.SearchOption;
import com.ai.paas.ipaas.search.vo.Sort;
import com.ai.paas.ipaas.search.vo.Sort.SortOrder;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.yc.order.api.orderquery.param.OrdProdExtendVo;
import com.ai.yc.order.api.orderreceivesearch.interfaces.IOrderWaitReceiveSV;
import com.ai.yc.order.api.orderreceivesearch.param.OrderWaitReceiveSearchInfo;
import com.ai.yc.order.api.orderreceivesearch.param.OrderWaitReceiveSearchRequest;
import com.ai.yc.order.api.orderreceivesearch.param.OrderWaitReceiveSearchResponse;
import com.ai.yc.order.constants.SearchFieldConfConstants;
import com.ai.yc.order.search.bo.OrdProdExtend;
import com.ai.yc.order.search.bo.OrderInfo;
import com.ai.yc.order.service.business.interfaces.IOrderWaitReceiveBusiSV;
import com.ai.yc.order.validate.OrderWaitReceiveSearchValidate;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

@Service
@Component
public class OrderWaitReceiveSVImpl implements IOrderWaitReceiveSV {

	@Autowired
	private IOrderWaitReceiveBusiSV orderWaitReceiveBusiSV;
	@Autowired
	private OrderWaitReceiveSearchValidate validate;
	//
	@Override
	public OrderWaitReceiveSearchResponse pageSearchWaitReceive(OrderWaitReceiveSearchRequest request)
			throws BusinessException, SystemException {
		OrderWaitReceiveSearchResponse response = new OrderWaitReceiveSearchResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			this.validate.validate(request);
			//
			response = this.orderWaitReceiveBusiSV.pageSearchWaitReceive(request);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SUCCESS);
			responseHeader.setResultMessage("待领取订单查询成功");
			response.setResponseHeader(responseHeader);
		} catch (BusinessException | SystemException e) {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			response.setResponseHeader(responseHeader);
		} catch (Exception e){
			
		}
		return response;
	}

}
