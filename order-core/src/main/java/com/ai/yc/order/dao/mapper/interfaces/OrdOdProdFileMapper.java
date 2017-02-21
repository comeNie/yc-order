package com.ai.yc.order.dao.mapper.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdOdProdFile;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdFileCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdOdProdFileMapper {
    int countByExample(OrdOdProdFileCriteria example);

    int deleteByExample(OrdOdProdFileCriteria example);

    int deleteByPrimaryKey(String prodFileId);

    int insert(OrdOdProdFile record);

    int insertSelective(OrdOdProdFile record);

    List<OrdOdProdFile> selectByExample(OrdOdProdFileCriteria example);

    OrdOdProdFile selectByPrimaryKey(String prodFileId);

    int updateByExampleSelective(@Param("record") OrdOdProdFile record, @Param("example") OrdOdProdFileCriteria example);

    int updateByExample(@Param("record") OrdOdProdFile record, @Param("example") OrdOdProdFileCriteria example);

    int updateByPrimaryKeySelective(OrdOdProdFile record);

    int updateByPrimaryKey(OrdOdProdFile record);
}