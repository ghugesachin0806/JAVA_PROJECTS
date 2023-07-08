package com.file_rest_api.file_upload.Entity;

import org.springframework.stereotype.Component;

@Component
public class FileInfo {

    int id;
    String name;
    String fileType;
    String downloadUrl;

    public FileInfo() {
    }

    public FileInfo(int id, String name, String fileType, String downloadUrl) {
        this.id = id;
        this.name = name;
        this.fileType = fileType;
        this.downloadUrl = downloadUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String toString() {
        return "FileInfo [id=" + id + ", name=" + name + ", fileType=" + fileType + ", downloadUrl=" + downloadUrl
                + "]";
    }
}
