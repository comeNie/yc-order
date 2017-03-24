package com.ai.yc.order.dao.mapper.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdOdReceive;
import com.ai.yc.order.dao.mapper.bo.OrdOdReceiveCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdOdReceiveMapper {
    int countByExample(OrdOdReceiveCriteria example);

    int deleteByExample(OrdOdReceiveCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(OrdOdReceive record);

    int insertSelective(OrdOdReceive record);

    List<OrdOdReceive> selectByExample(OrdOdReceiveCriteria example);

    OrdOdReceive selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrdOdReceive record, @Param("example") OrdOdReceiveCriteria example);

    int updateByExample(@Param("record") OrdOdReceive record, @Param("example") OrdOdReceiveCriteria example);

    int updateByPrimaryKeySelective(OrdOdReceive record);

    int updateByPrimaryKey(OrdOdReceive record);
}