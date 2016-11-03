package com.ai.yc.order.api.ordersubmission.param;

import java.io.Serializable;

public class FileInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 文档名称
	 */
	private String fileName;
	/**
	 * 文档存储id
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
