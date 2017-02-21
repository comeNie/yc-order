package com.ai.yc.order.dao.mapper.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdOdProdLevel;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdLevelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdOdProdLevelMapper {
    int countByExample(OrdOdProdLevelCriteria example);

    int deleteByExample(OrdOdProdLevelCriteria example);

    int deleteByPrimaryKey(Long prodDetalExtendId);

    int insert(OrdOdProdLevel record);

    int insertSelective(OrdOdProdLevel record);

    List<OrdOdProdLevel> selectByExample(OrdOdProdLevelCriteria example);

    OrdOdProdLevel selectByPrimaryKey(Long prodDetalExtendId);

    int updateByExampleSelective(@Param("record") OrdOdProdLevel record, @Param("example") OrdOdProdLevelCriteria example);

    int updateByExample(@Param("record") OrdOdProdLevel record, @Param("example") OrdOdProdLevelCriteria example);

    int updateByPrimaryKeySelective(OrdOdProdLevel record);

    int updateByPrimaryKey(OrdOdProdLevel record);
}