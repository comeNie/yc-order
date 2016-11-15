package com.ai.yc.order.api.updateorder.param;

import java.io.Serializable;

/**
 * @Description: 文件信息
 * @author hougang@asiainfo.com
 * @date 2016年11月4日 下午8:42:12 
 * @version V1.0
 */
public class UProdFileVo implements Serializable{
	
	private static final long serialVersionUID = -7415876498022426680L;

	/**
	 * 文件名称
	 */
	private String fileName;
	
	/**
	 * 文件存储ID
	 */
	private String fileSaveId;
	
	/**
	 * 翻译文件名称
	 */
	private String fileTranslateName;
	
	/**
	 * 翻译文件存储ID
	 */
	private String fileTranslateId;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSaveId() {
		return fileSaveId;
	}

	public void setFileSaveId(String fileSaveId) {
		this.fileSaveId = fileSaveId;
	}

	

	public String getFileTranslateId() {
		return fileTranslateId;
	}

	public void setFileTranslateId(String fileTranslateId) {
		this.fileTranslateId = fileTranslateId;
	}

	public String getFileTranslateName() {
		return fileTranslateName;
	}

	public void setFileTranslateName(String fileTranslateName) {
		this.fileTranslateName = fileTranslateName;
	}
	
	

}
