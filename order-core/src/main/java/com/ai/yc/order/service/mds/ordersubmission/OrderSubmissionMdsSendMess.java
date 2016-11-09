package com.ai.yc.order.service.mds.ordersubmission;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.opt.sdk.components.mds.MDSClientFactory;
import com.ai.paas.ipaas.mds.IMessageSender;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionRequest;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.util.SequenceUtil;
import com.alibaba.fastjson.JSON;

@Service
public class OrderSubmissionMdsSendMess {
	private static Logger logger = LoggerFactory.getLogger(OrderSubmissionMdsSendMess.class);
	//
	public void sendMessages(OrderSubmissionMdsVo request) {
		//
        IMessageSender msgSender = MDSClientFactory
                .getSenderClient(OrdersConstants.YC_ORDERSUBMISSION_TOPIC);

        msgSender.send(JSON.toJSONString(request), 0);// 第二个参数为分区键，如果不分区，传入0
        logger.info("----order submission mds sender success");
    }

}
