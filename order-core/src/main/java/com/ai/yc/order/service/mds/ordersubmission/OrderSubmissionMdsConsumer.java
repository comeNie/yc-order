package com.ai.yc.order.service.mds.ordersubmission;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.sdk.components.mds.MDSClientFactory;
import com.ai.opt.sdk.components.mds.base.AbstractMdsConsumer;
import com.ai.paas.ipaas.mds.IMessageConsumer;
import com.ai.paas.ipaas.mds.IMessageProcessor;
import com.ai.paas.ipaas.mds.IMsgProcessorHandler;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.service.business.interfaces.IOrderSubmissionBusiSV;

public class OrderSubmissionMdsConsumer extends AbstractMdsConsumer{

	private static Logger logger = LoggerFactory.getLogger(OrderSubmissionMdsConsumer.class);
	@Autowired
	private IOrderSubmissionBusiSV orderSubmissionBusiSV;
	//
	@Override
	public void startMdsConsumer() throws Exception {
		// TODO Auto-generated method stub
		logger.info("开始启动OrderSubmissionMdsConsumer。。。。。");
		IMsgProcessorHandler msgProcessorHandler = new IMsgProcessorHandler() {
            @Override
            public IMessageProcessor[] createInstances(int paramInt) {
                List<IMessageProcessor> processors = new ArrayList<IMessageProcessor>();
                IMessageProcessor processor = null;
                for (int i = 0; i < paramInt; i++) {
                    processor = new OrderSubmissionMdsProcessorImpl(orderSubmissionBusiSV);
                    processors.add(processor);
                }
                return processors.toArray(new IMessageProcessor[processors.size()]);
            }
        };
        IMessageConsumer msgConsumer = MDSClientFactory.getConsumerClient(
                OrdersConstants.YC_ORDERSUBMISSION_TOPIC, msgProcessorHandler);
        msgConsumer.start();
        logger.info("成功启动OrderSubmissionMdsConsumer。。。。。");
	}
	
}
