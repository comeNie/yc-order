package com.ai.yc.order.api.translatesave.param;

import java.io.Serializable;
import java.util.List;


/**
 * @Description: 
 * @author hougang@asiainfo.com
 * @date 2016年11月17日 下午7:46:15 
 * @version V1.0
 */
public class SaveTranslateInfoRequest implements Serializable{
	
	private static final long serialVersionUID = -5341746378735771941L;

	/**
	 * 订单ID(必填)
	 */
	private Long orderId;
	
	/**
	 * 翻译内容
	 */
	private String translateInfo;
	
	/**
	 * 文件列表
	 */
	private List<TranslateFileVo> fileVos;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getTranslateInfo() {
		return translateInfo;
	}

	public void setTranslateInfo(String translateInfo) {
		this.translateInfo = translateInfo;
	}

	public List<TranslateFileVo> getFileVos() {
		return fileVos;
	}

	public void setFileVos(List<TranslateFileVo> fileVos) {
		this.fileVos = fileVos;
	}
	
	

}
