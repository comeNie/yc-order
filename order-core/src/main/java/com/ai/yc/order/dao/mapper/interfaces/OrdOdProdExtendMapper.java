package com.ai.yc.order.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.yc.order.dao.mapper.bo.OrdOdProdExtend;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdExtendCriteria;

public interface OrdOdProdExtendMapper {
    int countByExample(OrdOdProdExtendCriteria example);

    int deleteByExample(OrdOdProdExtendCriteria example);

    int deleteByPrimaryKey(Long prodDetalExtendId);

    int insert(OrdOdProdExtend record);

    int insertSelective(OrdOdProdExtend record);

    List<OrdOdProdExtend> selectByExample(OrdOdProdExtendCriteria example);

    OrdOdProdExtend selectByPrimaryKey(Long prodDetalExtendId);

    int updateByExampleSelective(@Param("record") OrdOdProdExtend record, @Param("example") OrdOdProdExtendCriteria example);

    int updateByExample(@Param("record") OrdOdProdExtend record, @Param("example") OrdOdProdExtendCriteria example);

    int updateByPrimaryKeySelective(OrdOdProdExtend record);

    int updateByPrimaryKey(OrdOdProdExtend record);
}