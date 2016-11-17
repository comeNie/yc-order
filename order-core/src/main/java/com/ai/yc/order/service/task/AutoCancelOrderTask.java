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
 * @Description: 自动取消订单定时任务
 * @author hougang@asiainfo.com
 * @date 2016年11月17日 下午4:45:06 
 * @version V1.0
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class AutoCancelOrderTask implements ITask {
	
    private static final Logger LOG = LogManager.getLogger(AutoCancelOrderTask.class);
    
    private final static int DAY = 3;
    
    @Override
	public void execute(JobExecutionContext context)throws JobExecutionException {
    	LOG.info("自动取消订单定时任务start.....................");
    	IOrdOrderAtomSV iOrdOrderAtomSV = SpringUtil.getBean(IOrdOrderAtomSV.class);
    	IOrdOdStateChgBusiSV iOrdOdStateChgBusiSV = SpringUtil.getBean(IOrdOdStateChgBusiSV.class);
    	List<OrdOrder> ordOrders = iOrdOrderAtomSV.findByState(OrdersConstants.OrderState.STATE_WAIT_PAY);
    	long now = System.currentTimeMillis();
    	for(OrdOrder ordOrder:ordOrders){
    		long start = ordOrder.getStateChgTime()==null?ordOrder.getOrderTime().getTime():ordOrder.getStateChgTime().getTime();
    	    if(now-start >= DAY*24*60*60*1000l){
    	    	//修改订单状态
    	    	OrdOrder record = new OrdOrder();
    	    	record.setOrderId(ordOrder.getOrderId());
    	    	record.setState(OrdersConstants.OrderState.CANCEL_STATE);
    	    	record.setStateChgTime(DateUtil.getSysDate());
    	    	record.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_CANCEL);
    	    	record.setDisplayFlagChgTime(DateUtil.getSysDate());
    	    	record.setOperId(OrdersConstants.SYS_OPER_ID);
    	    	iOrdOrderAtomSV.updateByPrimaryKeySelective(record);
    	    	//添加订单轨迹
    	    	OrdOdStateChg chg = new OrdOdStateChg();
    	    	chg.setOrderId(ordOrder.getOrderId());
    	    	chg.setOrgState(ordOrder.getState());
    	    	chg.setNewState(OrdersConstants.OrderState.CANCEL_STATE);
    	    	chg.setOrgId(OrdersConstants.OrgID.ORG_ID_SYS);
    	    	chg.setOperId(OrdersConstants.SYS_OPER_ID);
    	    	iOrdOdStateChgBusiSV.addAllCloseChgDesc(chg);
    	    }
    	}
    	LOG.info("自动取消订单定时任务end.....................");
	}

}
