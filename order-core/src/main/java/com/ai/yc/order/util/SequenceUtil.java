package com.ai.yc.order.util;

import java.util.Random;

import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.DateUtil;

public final class SequenceUtil {

    /**
     * 购物车中商品明细序列
     */
    private static final String ORD_OD_CART_PROD$PROD_DETAL_ID$SEQ = "ORD_OD_CART_PROD$PROD_DETAL_ID$SEQ";

    /**
     * 
     * 属性定义标识序列
     */
    private static final String ORD_ORDER$ORDER_ID$SEQ = "ORD_ORDER$ORDER_ID$SEQ";

    private static final String ORD_OD_PROD$PROD_DETAL_ID$SEQ = "ORD_OD_PROD$PROD_DETAL_ID$SEQ";

    private static final String ORD_OD_STATE_CHG$STATE_CHG_ID$SEQ = "ORD_OD_STATE_CHG$STATE_CHG_ID$SEQ";

    private static final String ORD_OD_PROD_EXTEND$PROD_DETAL_EXTEND_ID$SEQ = "ORD_OD_PROD_EXTEND$PROD_DETAL_EXTEND_ID$SEQ";
    
    private static final String ORD_OD_PROD_LEVEL$PROD_DETAL_EXTEND_ID$SEQ = "ORD_OD_PROD_LEVEL$PROD_DETAL_EXTEND_ID$SEQ";

    private static final String ORD_OD_FEE_OFFSET$FEE_OFFSET_ID$SEQ = "ORD_OD_FEE_OFFSET$FEE_OFFSET_ID$SEQ";

    private static final String ORD_BALACNE_IF$BALACNE_IF_ID$SEQ = "ORD_BALACNE_IF$BALACNE_IF_ID$SEQ";
    
    private static final String ORD_OD_LOGISTICS$CONTACT_ID$SEQ="ORD_OD_LOGISTICS$CONTACT_ID$SEQ";
    
    private static final String FREIGHT_TEMPLATE$TEMPLATE_ID$SEQ="FREIGHT_TEMPLATE$TEMPLATE_ID$SEQ";
    
    private static final String FREIGHT_TEMPLATE_PROD$REGION_ID$SEQ="FREIGHT_TEMPLATE_PROD$REGION_ID$SEQ";

    private static final String ORD_OD_DELIVER_INFO$REGION_ID$SEQ="ORD_OD_DELIVER_INFO$REGION_ID$SEQ";
    
    private static final String ORD_OD_PROD_FILE$PROD_FILE_ID$SEQ = "ORD_OD_PROD_FILE$PROD_FILE_ID$SEQ";
    
    private static final String ORD_OD_PERSON_INFO$PERSON_ID$SEQ = "ORD_OD_PERSON_INFO$PERSON_ID$SEQ";
    
    public static Long createOrderId() {
        String seq = SeqUtil.getNewId(ORD_ORDER$ORDER_ID$SEQ, 10);
        String orderId = "2" + seq + SequenceUtil.returnRandom();
        return Long.valueOf(orderId);
    }

    public static Long createProdDetailId() {
        Long newId = SeqUtil.getNewId(ORD_OD_PROD$PROD_DETAL_ID$SEQ);
        return Long.valueOf(newId);
    }

    public static Long createStateChgId() {
        Long newId = SeqUtil.getNewId(ORD_OD_STATE_CHG$STATE_CHG_ID$SEQ);
        return Long.valueOf(newId);
    }

    public static Long createProdDetailExtendId() {
        Long newId = SeqUtil.getNewId(ORD_OD_PROD_EXTEND$PROD_DETAL_EXTEND_ID$SEQ);
        return Long.valueOf(newId);
    }
    
    public static Long createProdDetailLevelId() {
        Long newId = SeqUtil.getNewId(ORD_OD_PROD_LEVEL$PROD_DETAL_EXTEND_ID$SEQ);
        return Long.valueOf(newId);
    }

    public static Long genCartProdId() {
        return SeqUtil.getNewId(ORD_OD_CART_PROD$PROD_DETAL_ID$SEQ);
    }
    
    public static Long createContactId() {
    	return SeqUtil.getNewId(ORD_OD_LOGISTICS$CONTACT_ID$SEQ);
    }
    
    public static Long createProdDetailFileId(){
    	return SeqUtil.getNewId(ORD_OD_PROD_FILE$PROD_FILE_ID$SEQ);
    }
    
    public static Long createPersonId(){
    	return SeqUtil.getNewId(ORD_OD_PERSON_INFO$PERSON_ID$SEQ);
    }
    

    public static Long createFeeOffsetId() {
        return SeqUtil.getNewId(ORD_OD_FEE_OFFSET$FEE_OFFSET_ID$SEQ);
    }

    public static Long createBalacneIfId() {
    	String seq = SeqUtil.getNewId(ORD_BALACNE_IF$BALACNE_IF_ID$SEQ, 10);
        String balacneIfId = "3" + seq + SequenceUtil.returnRandom();
        return Long.valueOf(balacneIfId);
        //return SeqUtil.getNewId();
    }

    public static String getExternalId() {
        String dateString = DateUtil.getDateString(DateUtil.YYYYMMDDHHMMSS);
        String result = SequenceUtil.returnRandom() + dateString;
        return result;
    }
    
    public static String createTemplateId() {
        String seq = SeqUtil.getNewId(FREIGHT_TEMPLATE$TEMPLATE_ID$SEQ, 10);
        String templateId = "2" + seq + SequenceUtil.returnRandom();
        return templateId;
    }
    
    public static Long createRegionId() {
        return SeqUtil.getNewId(FREIGHT_TEMPLATE_PROD$REGION_ID$SEQ);
    }
    
    public static Long createdeliverInfoId() {
    	return SeqUtil.getNewId(ORD_OD_DELIVER_INFO$REGION_ID$SEQ);
    }
    /**
     * 返回随机数  
     * @author zhangzd
     */
    public static int returnRandom(){
    	Random random = new Random();
        //
        int rannum = (int) (random.nextDouble() * 90000) + 10000;// 获取5位随机数
        //
        return rannum;
    }
}
