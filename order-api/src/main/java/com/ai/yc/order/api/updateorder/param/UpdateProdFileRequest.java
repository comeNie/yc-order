package com.ai.yc.order.api.updateorder.param;

import java.io.Serializable;

public class UpdateProdFileRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 订单ID
	 */
	private Long orderId;

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
	/**
	 * 创建标识
	 */
	private String taskCreation;
	/**
	 * 操作人
	 */
	private String operName;

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

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}
