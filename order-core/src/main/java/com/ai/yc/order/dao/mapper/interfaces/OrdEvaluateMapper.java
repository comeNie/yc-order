package com.ai.yc.order.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.yc.order.dao.mapper.bo.OrdEvaluate;
import com.ai.yc.order.dao.mapper.bo.OrdEvaluateCriteria;

public interface OrdEvaluateMapper {
    int countByExample(OrdEvaluateCriteria example);

    int deleteByExample(OrdEvaluateCriteria example);

    int deleteByPrimaryKey(Long evaluateId);

    int insert(OrdEvaluate record);

    int insertSelective(OrdEvaluate record);

    List<OrdEvaluate> selectByExample(OrdEvaluateCriteria example);

    OrdEvaluate selectByPrimaryKey(Long evaluateId);

    int updateByExampleSelective(@Param("record") OrdEvaluate record, @Param("example") OrdEvaluateCriteria example);

    int updateByExample(@Param("record") OrdEvaluate record, @Param("example") OrdEvaluateCriteria example);

    int updateByPrimaryKeySelective(OrdEvaluate record);

    int updateByPrimaryKey(OrdEvaluate record);
}