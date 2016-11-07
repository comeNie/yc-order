package com.ai.yc.order.api.orderquery.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.paas.ipaas.search.vo.Result;
import com.ai.paas.ipaas.search.vo.Sort.SortOrder;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.yc.order.api.orderquery.interfaces.IOrderQuerySV;
import com.ai.yc.order.api.orderquery.param.OrdOrderVo;
import com.ai.yc.order.api.orderquery.param.QueryOrdCountRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrdCountResponse;
import com.ai.yc.order.api.orderquery.param.QueryOrderRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrderRsponse;
import com.ai.yc.order.search.bo.OrderInfo;
import com.ai.yc.order.search.dto.OrderSearchCriteria;
import com.ai.yc.order.service.business.impl.search.OrderSearchImpl;
import com.ai.yc.order.service.business.interfaces.IOrdOrderBusiSV;
import com.ai.yc.order.service.business.interfaces.search.IOrderSearch;
import com.ai.yc.order.util.ValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

@Service
@Component
public class OrderQuerySVImpl implements IOrderQuerySV {
	@Autowired
	IOrdOrderBusiSV iOrdOrderBusiSV;
	@Override
	public QueryOrderRsponse queryOrder(QueryOrderRequest request) throws BusinessException, SystemException {
		//有效性校验
		
		// 调用搜索引擎进行查询
		QueryOrderRsponse response = new QueryOrderRsponse();
        PageInfo<OrdOrderVo> pageinfo = new PageInfo<OrdOrderVo>();
        List<OrdOrderVo> results = new ArrayList<OrdOrderVo>();
        IOrderSearch orderSearch = new OrderSearchImpl();
        int startSize=1;
        int maxSize=1;
        //最大条数设置
        int pageNo = request.getPageNo();
        int size = request.getPageSize();
        if(request.getPageNo()==1){
            startSize=0;
        }else{
            startSize = (pageNo-1)*size;
        }
            maxSize=size;
        OrderSearchCriteria orderSearchCriteria =null;
         //如果业务标识不为空
         if(!StringUtil.isBlank(request.getFlag())){
        	 orderSearchCriteria =
                     new OrderSearchCriteria.OrderSearchCriteriaBuilder()
                             .startSize(startSize).maxSearchSize(maxSize).addOrderBy("ordertime", SortOrder.ASC).build();
         }
         Result<Map<String, Object>>  result = orderSearch.search(orderSearchCriteria);
         List<Map<String,Object>> reslist = result.getContents();
         String info = JSON.toJSONString(reslist);
         List<OrderInfo> ordList = JSON.parseObject(info,new TypeReference<List<OrderInfo>>(){}); 
         if(!CollectionUtil.isEmpty(ordList)){
             for(OrderInfo ord:ordList){
            	 OrdOrderVo order = new OrdOrderVo();
            	 //订单id
            	 order.setOrderId(ord.getOrderid());
                 results.add(order);
             }
         }
         pageinfo.setResult(results);
         pageinfo.setPageSize(request.getPageSize());
         pageinfo.setPageNo(request.getPageNo());
         pageinfo.setCount(queryPageCount(request));
         response.setPageInfo(pageinfo);
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "订单查询成功");
		response.setResponseHeader(responseHeader);
		return response;

	}
	//获取查询条数
	 //获取条数
    public int queryPageCount(QueryOrderRequest request){
    	// 调用搜索引擎进行查询
    	        IOrderSearch orderSearch = new OrderSearchImpl();
    	        int startSize=1;
    	        int maxSize=1;
    	        //最大条数设置
    	        int pageNo = request.getPageNo();
    	        int size = request.getPageSize();
    	        if(request.getPageNo()==1){
    	            startSize=0;
    	        }else{
    	            startSize = (pageNo-1)*size;
    	        }
    	            maxSize=size;
    	        OrderSearchCriteria orderSearchCriteria =null;
    	         //如果业务标识不为空
    	         if(!StringUtil.isBlank(request.getFlag())){
    	        	 orderSearchCriteria =
    	                     new OrderSearchCriteria.OrderSearchCriteriaBuilder()
    	                             .startSize(startSize).maxSearchSize(maxSize).addOrderBy("ordertime", SortOrder.ASC).build();
    	         }
    	         Result<Map<String, Object>>  result = orderSearch.search(orderSearchCriteria);
    	         List<Map<String,Object>> reslist = result.getContents();
    	         String info = JSON.toJSONString(reslist);
    	         List<OrderInfo> ordList = JSON.parseObject(info,new TypeReference<List<OrderInfo>>(){}); 
    	         if(!CollectionUtil.isEmpty(ordList)){
    	        	 return ordList.size();
    	         }else{
    	        	 return 0;
    	         }
    }
	
	
	
	
	
	
	
	@Override
	public QueryOrdCountResponse queryOrderCount(QueryOrdCountRequest request)
			throws BusinessException, SystemException {
		//有效性校验
		ValidateUtils.validateQueryOrdCount(request);
		QueryOrdCountResponse response = new QueryOrdCountResponse();
		int count = iOrdOrderBusiSV.findOrderCount(request);
		response.setCountNumber(count);
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "查询订单数成功");
		response.setResponseHeader(responseHeader);
		return response;
	}

}
