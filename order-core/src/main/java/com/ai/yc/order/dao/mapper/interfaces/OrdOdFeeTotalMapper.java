package com.ai.yc.order.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotalCriteria;

public interface OrdOdFeeTotalMapper {
    int countByExample(OrdOdFeeTotalCriteria example);

    int deleteByExample(OrdOdFeeTotalCriteria example);

    int deleteByPrimaryKey(Long orderId);

    int insert(OrdOdFeeTotal record);

    int insertSelective(OrdOdFeeTotal record);

    List<OrdOdFeeTotal> selectByExample(OrdOdFeeTotalCriteria example);

    OrdOdFeeTotal selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") OrdOdFeeTotal record, @Param("example") OrdOdFeeTotalCriteria example);

    int updateByExample(@Param("record") OrdOdFeeTotal record, @Param("example") OrdOdFeeTotalCriteria example);

    int updateByPrimaryKeySelective(OrdOdFeeTotal record);

    int updateByPrimaryKey(OrdOdFeeTotal record);
}