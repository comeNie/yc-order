package com.ai.yc.order.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionRequest;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionResponse;
import com.ai.yc.order.service.atom.interfaces.IOrdOdPersonInfoAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdExtendAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdFileAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdLevelAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdOdFeeTotalBusiSV;
import com.ai.yc.order.service.business.interfaces.IOrderSubmissionBusiSV;
@Service
public class OrderSubmissionBusiSVImpl implements IOrderSubmissionBusiSV {
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;//订单主表
	@Autowired
	private IOrdOdProdAtomSV ordOdProdAtomSV;//产品明细表
	@Autowired
	private IOrdOdProdExtendAtomSV ordOdProdExtendAtomSV;//产品语言表
	@Autowired
	private IOrdOdProdFileAtomSV ordOdProdFileAtomSV;//产品文件表
	@Autowired
	private IOrdOdPersonInfoAtomSV ordOdPersonInfoAtomSV;//联系人信息表
	@Autowired
	private IOrdOdProdLevelAtomSV ordOdProdLevelAtomSV;//翻译级别表
	@Autowired
	private IOrdOdFeeTotalBusiSV ordOdFeeTotalBusiSV;//费用信息表
	
	@Override
	public OrderSubmissionResponse saveOrderSubmission(OrderSubmissionRequest request) {
		
		return null;
	}
	
	
}
