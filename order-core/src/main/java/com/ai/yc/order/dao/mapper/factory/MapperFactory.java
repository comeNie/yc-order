package com.ai.yc.order.dao.mapper.factory;

import javax.annotation.PostConstruct;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.interfaces.OrdBalacneIfMapper;
import com.ai.yc.order.dao.mapper.interfaces.OrdEvaluateMapper;
import com.ai.yc.order.dao.mapper.interfaces.OrdOdFeeOffsetMapper;
import com.ai.yc.order.dao.mapper.interfaces.OrdOdFeeProdMapper;
import com.ai.yc.order.dao.mapper.interfaces.OrdOdFeeTotalMapper;
import com.ai.yc.order.dao.mapper.interfaces.OrdOdInvoiceLogisticsMapper;
import com.ai.yc.order.dao.mapper.interfaces.OrdOdInvoiceMapper;
import com.ai.yc.order.dao.mapper.interfaces.OrdOdLogisticsMapper;
import com.ai.yc.order.dao.mapper.interfaces.OrdOdPersonInfoMapper;
import com.ai.yc.order.dao.mapper.interfaces.OrdOdProdExtendMapper;
import com.ai.yc.order.dao.mapper.interfaces.OrdOdProdFileMapper;
import com.ai.yc.order.dao.mapper.interfaces.OrdOdProdMapper;
import com.ai.yc.order.dao.mapper.interfaces.OrdOdStateChgMapper;
import com.ai.yc.order.dao.mapper.interfaces.OrdOrderMapper;


@Component
public class MapperFactory {

    @Autowired
    private SqlSessionTemplate st;

    private static SqlSessionTemplate sqlSessionTemplate;

    @PostConstruct
    void init() {
        setSqlSessionTemplate(st);
    }

    public static void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        MapperFactory.sqlSessionTemplate = sqlSessionTemplate;
    }
    
    public static OrdOrderMapper getOrdOrderMapper(){
    	return sqlSessionTemplate.getMapper(OrdOrderMapper.class);
    }

    
    public static OrdBalacneIfMapper getOrdBalacneIfMapper(){
    	return sqlSessionTemplate.getMapper(OrdBalacneIfMapper.class);
    }
    
    public static OrdEvaluateMapper getOrdEvaluateMapper(){
    	return sqlSessionTemplate.getMapper(OrdEvaluateMapper.class);
    }
    
    public static OrdOdFeeOffsetMapper getOrdOdFeeOffsetMapper(){
    	return sqlSessionTemplate.getMapper(OrdOdFeeOffsetMapper.class);
    }
    
    public static OrdOdFeeProdMapper getOrdOdFeeProdMapper(){
    	return sqlSessionTemplate.getMapper(OrdOdFeeProdMapper.class);
    }
    
    public static OrdOdFeeTotalMapper getOrdOdFeeTotalMapper(){
    	return sqlSessionTemplate.getMapper(OrdOdFeeTotalMapper.class);
    }
    
    public static OrdOdInvoiceLogisticsMapper getOrdOdInvoiceLogisticsMapper(){
    	return sqlSessionTemplate.getMapper(OrdOdInvoiceLogisticsMapper.class);
    }
    
    public static OrdOdInvoiceMapper getOrdOdInvoiceMapper(){
    	return sqlSessionTemplate.getMapper(OrdOdInvoiceMapper.class);
    }
    
    public static OrdOdLogisticsMapper getOrdOdLogisticsMapper(){
    	return sqlSessionTemplate.getMapper(OrdOdLogisticsMapper.class);
    }
    
    public static OrdOdPersonInfoMapper getOrdOdPersonInfoMapper(){
    	return sqlSessionTemplate.getMapper(OrdOdPersonInfoMapper.class);
    }
    
    public static OrdOdProdExtendMapper getOrdOdProdExtendMapper(){
    	return sqlSessionTemplate.getMapper(OrdOdProdExtendMapper.class);
    }
    
    public static OrdOdProdMapper getOrdOdProdMapper(){
    	return sqlSessionTemplate.getMapper(OrdOdProdMapper.class);
    }
    
    public static OrdOdStateChgMapper getOrdOdStateChgMapper(){
    	return sqlSessionTemplate.getMapper(OrdOdStateChgMapper.class);
    }
    
    public static OrdOdProdFileMapper getOrdOdProdFileMapper(){
    	return sqlSessionTemplate.getMapper(OrdOdProdFileMapper.class);
    }
}

