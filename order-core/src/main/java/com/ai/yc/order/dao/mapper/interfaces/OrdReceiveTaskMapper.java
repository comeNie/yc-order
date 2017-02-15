package com.ai.yc.order.dao.mapper.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdReceiveTask;
import com.ai.yc.order.dao.mapper.bo.OrdReceiveTaskCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdReceiveTaskMapper {
    int countByExample(OrdReceiveTaskCriteria example);

    int deleteByExample(OrdReceiveTaskCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(OrdReceiveTask record);

    int insertSelective(OrdReceiveTask record);

    List<OrdReceiveTask> selectByExample(OrdReceiveTaskCriteria example);

    OrdReceiveTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrdReceiveTask record, @Param("example") OrdReceiveTaskCriteria example);

    int updateByExample(@Param("record") OrdReceiveTask record, @Param("example") OrdReceiveTaskCriteria example);

    int updateByPrimaryKeySelective(OrdReceiveTask record);

    int updateByPrimaryKey(OrdReceiveTask record);
}