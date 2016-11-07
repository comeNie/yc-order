package com.ai.yc.order.service.business.interfaces;

import com.ai.yc.order.api.paystatus.param.UpdatePayStatusRequest;
import com.ai.yc.order.api.paystatus.param.UpdatePayStatusResponse;

/**
 * @Description: 修改支付状态
 * @author hougang@asiainfo.com
 * @date 2016年11月7日 上午11:25:36 
 * @version V1.0
 */
public interface IUpdatePayStatusBusiSV {
	
	UpdatePayStatusResponse updatePayStatus(UpdatePayStatusRequest req);

}
