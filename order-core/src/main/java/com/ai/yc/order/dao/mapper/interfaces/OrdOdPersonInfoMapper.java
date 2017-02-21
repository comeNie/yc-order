package com.ai.yc.order.dao.mapper.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdOdPersonInfo;
import com.ai.yc.order.dao.mapper.bo.OrdOdPersonInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdOdPersonInfoMapper {
    int countByExample(OrdOdPersonInfoCriteria example);

    int deleteByExample(OrdOdPersonInfoCriteria example);

    int deleteByPrimaryKey(Long personId);

    int insert(OrdOdPersonInfo record);

    int insertSelective(OrdOdPersonInfo record);

    List<OrdOdPersonInfo> selectByExample(OrdOdPersonInfoCriteria example);

    OrdOdPersonInfo selectByPrimaryKey(Long personId);

    int updateByExampleSelective(@Param("record") OrdOdPersonInfo record, @Param("example") OrdOdPersonInfoCriteria example);

    int updateByExample(@Param("record") OrdOdPersonInfo record, @Param("example") OrdOdPersonInfoCriteria example);

    int updateByPrimaryKeySelective(OrdOdPersonInfo record);

    int updateByPrimaryKey(OrdOdPersonInfo record);
}