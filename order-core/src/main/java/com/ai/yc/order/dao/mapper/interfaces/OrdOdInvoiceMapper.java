package com.ai.yc.order.dao.mapper.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdOdInvoice;
import com.ai.yc.order.dao.mapper.bo.OrdOdInvoiceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdOdInvoiceMapper {
    int countByExample(OrdOdInvoiceCriteria example);

    int deleteByExample(OrdOdInvoiceCriteria example);

    int deleteByPrimaryKey(Long invoiceInfoId);

    int insert(OrdOdInvoice record);

    int insertSelective(OrdOdInvoice record);

    List<OrdOdInvoice> selectByExample(OrdOdInvoiceCriteria example);

    OrdOdInvoice selectByPrimaryKey(Long invoiceInfoId);

    int updateByExampleSelective(@Param("record") OrdOdInvoice record, @Param("example") OrdOdInvoiceCriteria example);

    int updateByExample(@Param("record") OrdOdInvoice record, @Param("example") OrdOdInvoiceCriteria example);

    int updateByPrimaryKeySelective(OrdOdInvoice record);

    int updateByPrimaryKey(OrdOdInvoice record);
}