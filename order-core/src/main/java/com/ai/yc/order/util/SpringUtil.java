package com.ai.yc.order.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring工具类 
 * @author hougang@asiainfo.com
 * @date 2016年11月17日 下午6:00:36 
 * @version V1.0
 */
public final class SpringUtil {
    private SpringUtil() {
    }

    private static ApplicationContext context = new ClassPathXmlApplicationContext("/context/core-context.xml");
    
    public static ApplicationContext getApplicationContext() {
         return context;
    }
    
    public static <T> T getBean(Class<T> requiredType) {
        return context.getBean(requiredType);
    }
}
