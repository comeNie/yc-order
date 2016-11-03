package com.ai.yc.order.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.yc.order.dao.mapper.bo.OrdOdFeeProd;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeProdCriteria;

public interface OrdOdFeeProdMapper {
    int countByExample(OrdOdFeeProdCriteria example);

    int deleteByExample(OrdOdFeeProdCriteria example);

    int deleteByPrimaryKey(Long feeProdId);

    int insert(OrdOdFeeProd record);

    int insertSelective(OrdOdFeeProd record);

    List<OrdOdFeeProd> selectByExample(OrdOdFeeProdCriteria example);

    OrdOdFeeProd selectByPrimaryKey(Long feeProdId);

    int updateByExampleSelective(@Param("record") OrdOdFeeProd record, @Param("example") OrdOdFeeProdCriteria example);

    int updateByExample(@Param("record") OrdOdFeeProd record, @Param("example") OrdOdFeeProdCriteria example);

    int updateByPrimaryKeySelective(OrdOdFeeProd record);

    int updateByPrimaryKey(OrdOdFeeProd record);
}