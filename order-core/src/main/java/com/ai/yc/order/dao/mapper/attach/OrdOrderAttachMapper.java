package com.ai.yc.order.dao.mapper.attach;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

public interface OrdOrderAttachMapper {
	@Results({ @Result(property = "orderId", column = "order_id") })
	@SelectProvider(type = OrdOrderAllocationSqlProvider.class, method = "allocationQueryOrdOrder")
	public List<Object> getAllocationOrdOrder(@Param("interperId") String interperId,
			@Param("receiveState") String receiveState);

	/**
	 * lsp下译员领取订单查询
	 */
	@Results({ @Result(property = "orderId", column = "order_id") })
	@SelectProvider(type = OrdInterperQuerySqlProvider.class, method = "interperQueryOrdOrder")
	public List<Object> getInterperOrdOrder(@Param("interperId") String interperId);

	/**
	 * 佣金查询
	 */
	@Results({ @Result(property = "interperFee", column = "sum_interper_fee") })
	@SelectProvider(type = OrdOrderAlloInterperFeeSqlProvider.class, method = "allocationQueryOrdOrderFee")
	public OrdOrderInferperFeeAttach getAllocationOrdOrderFee(@Param("orderId") Long orderId,
			@Param("receiveState") String receiveState);

	/**
	 * 信息汇总
	 */
	@Results({ @Result(property = "orderCounts", column = "orderCounts"),
			@Result(property = "discountFeeCount", column = "discountFeeCount"),
			@Result(property = "paidFeeCount", column = "paidFeeCount"),
			@Result(property = "adjustFeeCount", column = "adjustFeeCount") })
	@SelectProvider(type = OrdorderCountSqlProvider.class, method = "ordOrderCount")
	public OrdOrderCountAttach getOrdOrderCount(@Param("chlId") String chlId, @Param("userId") String userId,
			@Param("corporaId") String corporaId);

	/**
	 * 后付费信息汇总
	 */
	@Results({ @Result(property = "orderCounts", column = "orderCounts"),
			@Result(property = "totalFeeCount", column = "totalFeeCount"), })
	@SelectProvider(type = OrdorderHFCountSqlProvider.class, method = "ordOrderHFCount")
	public OrdOrderHFCountAttach getOrdOrderHFCount(@Param("chlId") String chlId, @Param("userId") String userId,
			@Param("corporaId") String corporaId);

	/**
	 * 获取工作记录
	 */
	@Results({ @Result(property = "totalFeeCount", column = "totalFeeCount"),
			@Result(property = "platFeeCount", column = "platFeeCount"),
			@Result(property = "currencyUnit", column = "currencyUnit"),
			@Result(property = "interperFeeCount", column = "interperFeeCount") })
	@SelectProvider(type = RecordOrderInfoSqlProvider.class, method = "recordOrderCount")
	public RecordOrderInfoAttach getRecordCount(@Param("orderId") Long orderId,
			@Param("state") String state,
			@Param("interperId") String interperId,
			@Param("lspId") String lspId,
			@Param("stateChgTimeStart") Timestamp stateChgTimeStart,
			@Param("stateChgTimeEnd") Timestamp stateChgTimeEnd);
}
