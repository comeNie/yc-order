package com.ai.yc.order.service.elasticjob;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.yc.order.api.orderdeal.interfaces.IAutoDealOrderSV;
import com.alibaba.fastjson.JSON;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @Description: 自动确认订单定时任务
 * @author hougang@asiainfo.com
 * @date 2016年11月17日 下午4:48:12 
 * @version V1.0
 */
public class AutoConfirmOrderJob implements SimpleJob {
	
	private static final Logger LOG = LogManager.getLogger(AutoConfirmOrderJob.class);
	
	@Override
	public void execute(ShardingContext shardingContext) {
		LOG.info("自动确认订单定时任务start.....................");
		IAutoDealOrderSV iAutoDealOrderSV = DubboConsumerFactory.getService(IAutoDealOrderSV.class);
    	BaseResponse resp = iAutoDealOrderSV.autoConfirmOrder();
    	LOG.info("自动确认订单定时任务消息："+JSON.toJSONString(resp));
    	LOG.info("自动确认订单定时任务end.....................");
	}

}
