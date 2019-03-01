package com.udesc.ceavi.deso.empds.backend.model;

import org.bson.types.ObjectId;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Arrays;

public class Image {
    private ObjectId _id;
    private String originalName;
    private String nameWithDate;
    private long size;
    private String url;
    private String path;

    public Image(String originalName, String nameWithDate, long size, String url, String path) {
        this.originalName = originalName;
        this.nameWithDate = nameWithDate;
        this.size = size;
        this.url = url;
        this.path = path;
    }

    public ObjectId get_id() {
        return _id;
    }

    public String getNameWithDate() {
        return nameWithDate;
    }

    public void setNameWithDate(String nameWithDate) {
        this.nameWithDate = nameWithDate;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Image{" +
                "_id=" + _id +
                ", nameWithDate='" + nameWithDate + '\'' +
                ", originalName='" + originalName + '\'' +
                ", size=" + size +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
