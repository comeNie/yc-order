package com.ai.yc.order.api.paystatus.param;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description: 产品明细信息
 * @author hougang@asiainfo.com
 * @date 2016年11月4日 下午8:07:17
 * @version V1.0
 */
public class ProdVo implements Serializable {

	private static final long serialVersionUID = 8276056654189580416L;

	/**
	 * 开始时间
	 */
	private Timestamp stateTime;



	public Timestamp getStateTime() {
		return stateTime;
	}



	public void setStateTime(Timestamp stateTime) {
		this.stateTime = stateTime;
	}

	
}
