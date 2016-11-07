package com.ai.yc.order.validate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextOrderTranslateTimeUtil {
	public static final Logger log = LogManager.getLogger(TextOrderTranslateTimeUtil.class);
	@Autowired
	private TextOrderTranslateTimeBeanMap textOrderTranslateTimeBeanMap;
	/**
	 * 根据翻译级别计算文本翻译下根据字数计算耗时
	 * @author zhangzd
	 */
	public Integer textOrderTranslateTime(String translateLevel,String isUrgent,Long translateSum){
		//
		Integer sumHours = 0;
		Integer time = 0;
		TextOrderTranslateTimeBean textOrderTranslateTimeBean = this.textOrderTranslateTimeBeanMap.getTranslateLevelMap().get(translateLevel);
		if(null != textOrderTranslateTimeBean){
			Integer total = Integer.parseInt(translateSum.toString()) / textOrderTranslateTimeBean.getIncreases();
			Integer remainder = Integer.parseInt(translateSum.toString()) % textOrderTranslateTimeBean.getIncreases();
			log.info("total:"+total);
			log.info("remainder:"+remainder);
			//非加急状态
			if("N".equals(isUrgent)){
				time = textOrderTranslateTimeBean.getNonUrgentTime();
			}
			//加急状态
			if("Y".equals(isUrgent)){
				time = textOrderTranslateTimeBean.getUrgentTime();
			}
			
			if(remainder > 0 ){
				sumHours = (total + 1) * time;
			}else{
				sumHours = (total) * time;
			}
		}
		//
		return sumHours;
	}
	
	public static void main(String args[]){
		int a = 100/1000;
		int b = 100%1000;
		System.out.println("倍数："+a);
		System.out.println("余数："+b);
	}
}
