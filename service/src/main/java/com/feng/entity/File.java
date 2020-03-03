package com.feng.entity;

import java.util.Date;

import java.io.Serializable;


public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件路径
     */
    private String filePath;
    private Date createTime;
    private Integer fileTypeId;



    public File() {
    }

    public File(String fileName, String filePath, Integer fileTypeId) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileTypeId = fileTypeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFileTypeId() {
        return fileTypeId;
    }

    public void setFileTypeId(Integer fileTypeId) {
        this.fileTypeId = fileTypeId;
    }


    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", createTime=" + createTime +
                ", fileTypeId=" + fileTypeId +
                '}';
    }
}
