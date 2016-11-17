package com.ai.yc.order.service.task;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

import com.ai.opt.sdk.dts.base.ITask;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdOdStateChgBusiSV;
import com.ai.yc.order.util.SpringUtil;

/**
 * @Description: 自动确认订单定时任务
 * @author hougang@asiainfo.com
 * @date 2016年11月17日 下午4:48:12 
 * @version V1.0
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class AutoConfirmOrderTask implements ITask {
	
	private static final Logger LOG = LogManager.getLogger(AutoConfirmOrderTask.class);
	    
	private final static int DAY = 7;

	@Override
	public void execute(JobExecutionContext context)throws JobExecutionException {
		LOG.info("自动确认订单定时任务start.....................");
    	IOrdOrderAtomSV iOrdOrderAtomSV = SpringUtil.getBean(IOrdOrderAtomSV.class);
    	IOrdOdStateChgBusiSV iOrdOdStateChgBusiSV = SpringUtil.getBean(IOrdOdStateChgBusiSV.class);
    	List<OrdOrder> ordOrders = iOrdOrderAtomSV.findByState(OrdersConstants.OrderState.WAIT_OK_STATE);
    	long now = System.currentTimeMillis();
    	for(OrdOrder ordOrder:ordOrders){
    		long start = ordOrder.getStateChgTime().getTime();
    	    if(now-start >= DAY*24*60*60*1000l){
    	    	//修改订单状态为待评论
    	    	OrdOrder record = new OrdOrder();
    	    	record.setOrderId(ordOrder.getOrderId());
    	    	record.setState(OrdersConstants.OrderState.WAIT_COMMENT_STATE);
    	    	record.setStateChgTime(DateUtil.getSysDate());
    	    	record.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_COMMENT);
    	    	record.setDisplayFlagChgTime(DateUtil.getSysDate());
    	    	record.setOperId(OrdersConstants.SYS_OPER_ID);
    	    	iOrdOrderAtomSV.updateByPrimaryKeySelective(record);
    	    	//添加订单轨迹
    	    	OrdOdStateChg chg = new OrdOdStateChg();
    	    	chg.setOrderId(ordOrder.getOrderId());
    	    	chg.setOrgState(ordOrder.getState());
    	    	chg.setNewState(OrdersConstants.OrderState.WAIT_COMMENT_STATE);
    	    	iOrdOdStateChgBusiSV.addAllCloseChgDesc(chg);
    	    }
    	}
    	LOG.info("自动确认订单定时任务end.....................");
	}

}
