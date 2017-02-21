package com.ai.yc.order.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.yc.order.dao.mapper.bo.OrdBalacneIf;
import com.ai.yc.order.dao.mapper.bo.OrdBalacneIfCriteria;

public interface OrdBalacneIfMapper {
    int countByExample(OrdBalacneIfCriteria example);

    int deleteByExample(OrdBalacneIfCriteria example);

    int deleteByPrimaryKey(Long balacneIfId);

    int insert(OrdBalacneIf record);

    int insertSelective(OrdBalacneIf record);

    List<OrdBalacneIf> selectByExample(OrdBalacneIfCriteria example);

    OrdBalacneIf selectByPrimaryKey(Long balacneIfId);

    int updateByExampleSelective(@Param("record") OrdBalacneIf record, @Param("example") OrdBalacneIfCriteria example);

    int updateByExample(@Param("record") OrdBalacneIf record, @Param("example") OrdBalacneIfCriteria example);

    int updateByPrimaryKeySelective(OrdBalacneIf record);

    int updateByPrimaryKey(OrdBalacneIf record);
}