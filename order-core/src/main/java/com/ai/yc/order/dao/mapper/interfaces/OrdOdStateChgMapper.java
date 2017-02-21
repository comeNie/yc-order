package com.ai.yc.order.dao.mapper.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChgCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdOdStateChgMapper {
    int countByExample(OrdOdStateChgCriteria example);

    int deleteByExample(OrdOdStateChgCriteria example);

    int deleteByPrimaryKey(Long stateChgId);

    int insert(OrdOdStateChg record);

    int insertSelective(OrdOdStateChg record);

    List<OrdOdStateChg> selectByExample(OrdOdStateChgCriteria example);

    OrdOdStateChg selectByPrimaryKey(Long stateChgId);

    int updateByExampleSelective(@Param("record") OrdOdStateChg record, @Param("example") OrdOdStateChgCriteria example);

    int updateByExample(@Param("record") OrdOdStateChg record, @Param("example") OrdOdStateChgCriteria example);

    int updateByPrimaryKeySelective(OrdOdStateChg record);

    int updateByPrimaryKey(OrdOdStateChg record);
}