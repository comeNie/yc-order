package com.ai.yc.order.dao.mapper.attach;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
public interface OrdOrderAttachMapper {
		@Results({@Result(property = "orderId", column = "order_id"),
        @Result(property = "personId", column = "person_id"),
        @Result(property = "interperFee", column = "interper_fee"),
        @Result(property = "step", column = "step"),
        @Result(property = "operType", column = "oper_type"),
        @Result(property = "interperId", column = "interper_id"),
        @Result(property = "interperName", column = "interper_name"),
        @Result(property = "creartTime", column = "creart_time"),
        @Result(property = "remark", column = "remark"),
        @Result(property = "receiveState", column = "receive_state"),
        @Result(property = "finishState", column = "finish_state"),
        @Result(property = "expectEndTime", column = "expect_end_time"),
        @Result(property = "tel", column = "tel")})
    @SelectProvider(type = OrdOrderAllocationSqlProvider.class, method = "allocationQueryOrdOrder")
	public List<OrdOrderAttach> getAllocationOrdOrder(@Param("interperId") String interperId,
			@Param("receiveState") String receiveState);
		/**
		 * 佣金查询
		 */
		@Results({ @Result(property = "interperFee", column = "sum_interper_fee")})
	    @SelectProvider(type = OrdOrderAlloInterperFeeSqlProvider.class, method = "allocationQueryOrdOrderFee")
		public OrdOrderInferperFeeAttach getAllocationOrdOrderFee(@Param("orderId") Long orderId,
				@Param("receiveState") String receiveState);
		/**
		 * 信息汇总
		 */
		@Results({ @Result(property = "orderCounts", column = "orderCounts"),
			 	@Result(property = "discountFeeCount", column = "discountFeeCount"),
		        @Result(property = "paidFeeCount", column = "paidFeeCount"),
		        @Result(property = "adjustFeeCount", column = "adjustFeeCount")
		})
	    @SelectProvider(type = OrdorderCountSqlProvider.class, method = "ordOrderCount")
		public OrdOrderCountAttach getOrdOrderCount(@Param("chlId") String chlId,
				@Param("userId") String userId,@Param("corporaId") String corporaId);
}
