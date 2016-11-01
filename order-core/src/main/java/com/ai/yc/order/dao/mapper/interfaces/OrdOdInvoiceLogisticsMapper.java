package com.ai.yc.order.dao.mapper.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdOdInvoiceLogistics;
import com.ai.yc.order.dao.mapper.bo.OrdOdInvoiceLogisticsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdOdInvoiceLogisticsMapper {
    int countByExample(OrdOdInvoiceLogisticsCriteria example);

    int deleteByExample(OrdOdInvoiceLogisticsCriteria example);

    int deleteByPrimaryKey(Long logisticsId);

    int insert(OrdOdInvoiceLogistics record);

    int insertSelective(OrdOdInvoiceLogistics record);

    List<OrdOdInvoiceLogistics> selectByExample(OrdOdInvoiceLogisticsCriteria example);

    OrdOdInvoiceLogistics selectByPrimaryKey(Long logisticsId);

    int updateByExampleSelective(@Param("record") OrdOdInvoiceLogistics record, @Param("example") OrdOdInvoiceLogisticsCriteria example);

    int updateByExample(@Param("record") OrdOdInvoiceLogistics record, @Param("example") OrdOdInvoiceLogisticsCriteria example);

    int updateByPrimaryKeySelective(OrdOdInvoiceLogistics record);

    int updateByPrimaryKey(OrdOdInvoiceLogistics record);
}