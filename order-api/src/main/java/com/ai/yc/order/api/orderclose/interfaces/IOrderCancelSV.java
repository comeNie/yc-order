package com.ai.yc.order.api.orderclose.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.yc.order.api.orderclose.param.OrderCancelRequest;

/**
 * 订单关闭（取消）
 * Date: 2016年11月5日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
@Path("/ordercancel")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderCancelSV {
   
   /**
    * 手动关闭未支付订单
    * @param request
    * @return
    * @throws BusinessException
    * @throws SystemException
    * @author zhanglh
    * @ApiCode ORD_2011
    * @ApiDocMethod
    * @RestRelativeURL ordercancel/handCancelNoPayOrder
    */
    @POST
    @Path("/handCancelNoPayOrder")
    public BaseResponse handCancelNoPayOrder(OrderCancelRequest request) throws BusinessException, SystemException;
    

}
