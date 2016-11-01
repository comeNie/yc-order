package com.ai.yc.order.dao.mapper.factory;

import javax.annotation.PostConstruct;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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

    
}

