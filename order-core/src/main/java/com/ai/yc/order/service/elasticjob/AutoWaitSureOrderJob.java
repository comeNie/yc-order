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
 * @Description: 口译订单超过翻译完成时间 自动待确认
 * @author zhangzd@asiainfo.com
 * @date 2016年12月28日 上午11:31:06 
 * @version V1.0
 */
public class AutoWaitSureOrderJob implements SimpleJob {
	
    private static final Logger LOG = LogManager.getLogger(AutoWaitSureOrderJob.class);
    
    @Override
	public void execute(ShardingContext shardingContext){
    	LOG.info("口译订单超过翻译完成时间 自动待确认订单定时任务start.....................");
    	IAutoDealOrderSV iAutoDealOrderSV = DubboConsumerFactory.getService(IAutoDealOrderSV.class);
    	BaseResponse resp = iAutoDealOrderSV.autoWaitSureOrder();
    	LOG.info("口译订单超过翻译完成时间 自动待确认订单定时任务消息："+JSON.toJSONString(resp));
    	
    	LOG.info("口译订单超过翻译完成时间 自动待确认订单定时任务end.....................");
	}

}
