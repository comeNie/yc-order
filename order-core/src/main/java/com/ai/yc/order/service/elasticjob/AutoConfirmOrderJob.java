package com.ai.yc.order.service.elasticjob;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.PersistJobDataAfterExecution;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.yc.order.api.orderdeal.interfaces.IAutoDealOrderSV;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @Description: 自动确认订单定时任务
 * @author hougang@asiainfo.com
 * @date 2016年11月17日 下午4:48:12 
 * @version V1.0
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class AutoConfirmOrderJob implements SimpleJob {
	
	private static final Logger LOG = LogManager.getLogger(AutoConfirmOrderJob.class);
	
	@Override
	public void execute(ShardingContext shardingContext) {
		LOG.info("自动确认订单定时任务start.....................");
		IAutoDealOrderSV iAutoDealOrderSV = DubboConsumerFactory.getService(IAutoDealOrderSV.class);
    	BaseResponse resp = null;
    	try {
    		resp = iAutoDealOrderSV.autoConfirmOrder();
		} catch (Exception e) {
			LOG.error("自动确认订单定时任务出现异常",e);
		}
    	if(resp==null){
    		LOG.error("自动确认订单定时任务出现异常");
    	}
    	if(!resp.getResponseHeader().isSuccess()){
    		LOG.error(resp.getResponseHeader().getResultMessage());
    	}
    	LOG.info("自动确认订单定时任务end.....................");
	}

}
