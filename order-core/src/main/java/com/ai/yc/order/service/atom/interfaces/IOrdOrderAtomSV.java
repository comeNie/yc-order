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
	 * 
	 * @author zhangzd
	 */
	public void insertSelective(OrdOrder OrdOrder);

	int updateByPrimaryKeySelective(OrdOrder record);

	/**
	 * 根据id修改订单
	 * 
	 */
	int updateById(OrdOrder ordOrder);

	/**
	 * 搜索引擎刷新数据使用
	 * 
	 * @author zhanglh
	 */
	public List<OrdOrder> findOrdList(Integer limitStart, Integer limitEnd);

	/**
	 * 根据id获取待支付订单
	 * 
	 * @author zhanglh
	 */
	List<OrdOrder> findNoPayOrdList(long orderId);
	/**
	 * 根据id获取待报价订单
	 * 
	 * @author zhanglh
	 */
	List<OrdOrder> findNoPriceOrdList(long orderId);
	/**
	 * 根据id获取待审核订单
	 * 
	 * @author zhanglh
	 */
	List<OrdOrder> findNoReviewList(long orderId);
	
	/**
	 * 根据订单状态查询
	 */
	List<OrdOrder> findByState(String state);

}
