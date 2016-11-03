package com.ai.yc.order.api.orderquery.param;

import java.io.Serializable;

public class OrdProdFileVo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件存储ID
	 */
	private String fileSaveId;

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

}
