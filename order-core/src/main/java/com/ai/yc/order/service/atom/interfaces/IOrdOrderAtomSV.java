package com.ai.yc.order.service.atom.interfaces;

import java.util.List;

import com.ai.yc.order.dao.mapper.bo.OrdOrder;

public interface IOrdOrderAtomSV {
	/**
	 * 根据主键查询
	 */
	public OrdOrder findByPrimaryKey(OrdOrder ordOrder);
	
	public OrdOrder findByPrimaryKey(Long orderId);
	/**
	 * 查询订单数
	 */
	public int findOrderCount(OrdOrder ordOrder);
	/**
	 * 添加订单
	 * @author zhangzd
	 */
	public void insertSelective(OrdOrder OrdOrder);
	/**
	 * 根据id修改订单
	 * @author zhanglh
	 */
	 int updateById(OrdOrder ordOrder);
	 
	 public List<OrdOrder> findOrdList(Integer limitStart, Integer limitEnd); 
	 
}
