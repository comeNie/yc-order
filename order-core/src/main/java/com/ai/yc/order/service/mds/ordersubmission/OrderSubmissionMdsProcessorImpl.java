package com.ai.yc.order.service.mds.ordersubmission;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ai.paas.ipaas.mds.IMessageProcessor;
import com.ai.paas.ipaas.mds.vo.MessageAndMetadata;
import com.ai.yc.order.service.business.interfaces.IOrderSubmissionBusiSV;
import com.alibaba.fastjson.JSON;

public class OrderSubmissionMdsProcessorImpl implements IMessageProcessor  {
	//
	private static Logger logger = LoggerFactory.getLogger(OrderSubmissionMdsProcessorImpl.class);
	//
	private IOrderSubmissionBusiSV orderSubmissionBusiSV;
	
	public OrderSubmissionMdsProcessorImpl(IOrderSubmissionBusiSV orderSubmissionBusiSV){
		this.orderSubmissionBusiSV = orderSubmissionBusiSV;
	}
	@Override
	public void process(MessageAndMetadata message) throws Exception {
		// TODO Auto-generated method stub
		 logger.info("开始处理提交订单.........");
		if (null == message)
			return;
		String content = new String(message.getMessage(), "UTF-8");
		System.out.println("RouteChargeMessProcessorImpl " + content);
		logger.info("--Topic:{}\r\n----key:{}\r\n----content:{}", message.getTopic(),
				new String(message.getKey(), "UTF-8"), content);
		//调用订单提交服务
		OrderSubmissionMdsVo vo = JSON.parseObject(content,OrderSubmissionMdsVo.class);
		if(null != vo){
			//
			this.orderSubmissionBusiSV.saveOrderSubmissionSupperMds(vo.getOrderId(), vo.getOrderSubmissionRequest());
		}
	}

}
