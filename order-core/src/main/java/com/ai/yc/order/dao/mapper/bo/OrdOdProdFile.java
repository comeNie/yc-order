package com.ai.yc.order.dao.mapper.bo;

public class OrdOdProdFile {
    private String prodFileId;

    private Long prodDetalId;

    private String fileName;

    private String fileSaveId;

    private String fileTranslateId;

    private String fileTranslateName;

    public String getProdFileId() {
        return prodFileId;
    }

    public void setProdFileId(String prodFileId) {
        this.prodFileId = prodFileId == null ? null : prodFileId.trim();
    }

    public Long getProdDetalId() {
        return prodDetalId;
    }

    public void setProdDetalId(Long prodDetalId) {
        this.prodDetalId = prodDetalId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileSaveId() {
        return fileSaveId;
    }

    public void setFileSaveId(String fileSaveId) {
        this.fileSaveId = fileSaveId == null ? null : fileSaveId.trim();
    }

    public String getFileTranslateId() {
        return fileTranslateId;
    }

    public void setFileTranslateId(String fileTranslateId) {
        this.fileTranslateId = fileTranslateId == null ? null : fileTranslateId.trim();
    }

    public String getFileTranslateName() {
        return fileTranslateName;
    }

    public void setFileTranslateName(String fileTranslateName) {
        this.fileTranslateName = fileTranslateName == null ? null : fileTranslateName.trim();
    }
}