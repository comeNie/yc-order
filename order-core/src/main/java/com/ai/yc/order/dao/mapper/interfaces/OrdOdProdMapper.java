package com.ai.yc.order.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.yc.order.dao.mapper.bo.OrdOdProd;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdCriteria;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdWithBLOBs;

public interface OrdOdProdMapper {
    int countByExample(OrdOdProdCriteria example);

    int deleteByExample(OrdOdProdCriteria example);

    int deleteByPrimaryKey(Long prodDetalId);

    int insert(OrdOdProdWithBLOBs record);

    int insertSelective(OrdOdProdWithBLOBs record);

    List<OrdOdProdWithBLOBs> selectByExampleWithBLOBs(OrdOdProdCriteria example);

    List<OrdOdProd> selectByExample(OrdOdProdCriteria example);

    OrdOdProdWithBLOBs selectByPrimaryKey(Long prodDetalId);

    int updateByExampleSelective(@Param("record") OrdOdProdWithBLOBs record, @Param("example") OrdOdProdCriteria example);

    int updateByExampleWithBLOBs(@Param("record") OrdOdProdWithBLOBs record, @Param("example") OrdOdProdCriteria example);

    int updateByExample(@Param("record") OrdOdProd record, @Param("example") OrdOdProdCriteria example);

    int updateByPrimaryKeySelective(OrdOdProdWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OrdOdProdWithBLOBs record);

    int updateByPrimaryKey(OrdOdProd record);
}