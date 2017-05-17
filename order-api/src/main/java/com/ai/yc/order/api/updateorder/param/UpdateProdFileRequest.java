package com.ai.yc.order.api.updateorder.param;

import java.io.Serializable;

public class UpdateProdFileRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 产品明细ID
	 */
	private Long prodFileId;

	/**
	 * 翻译文件名称
	 */
	private String fileTranslateName;

	/**
	 * 翻译文件存储ID
	 */
	private String fileTranslateId;
	/**
	 * 创建标识
	 */
	private String taskCreation;
	/**
	 * 操作人
	 */
	private String operName;

	public String getFileTranslateName() {
		return fileTranslateName;
	}

	public void setFileTranslateName(String fileTranslateName) {
		this.fileTranslateName = fileTranslateName;
	}

	public String getFileTranslateId() {
		return fileTranslateId;
	}

	public void setFileTranslateId(String fileTranslateId) {
		this.fileTranslateId = fileTranslateId;
	}

	public String getTaskCreation() {
		return taskCreation;
	}

	public void setTaskCreation(String taskCreation) {
		this.taskCreation = taskCreation;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public Long getProdFileId() {
		return prodFileId;
	}

	public void setProdFileId(Long prodFileId) {
		this.prodFileId = prodFileId;
	}

}
