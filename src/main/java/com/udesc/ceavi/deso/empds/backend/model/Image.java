package com.udesc.ceavi.deso.empds.backend.model;

import org.bson.types.ObjectId;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public class Image {
    private ObjectId _id;
    private String title;
    private String contentType;
    private byte[] bytes;
    private String[] metadata;

    public Image(String title, String contentType, byte[] bytes, String[] metadata) {
        this.title = title;
        this.contentType = contentType;
        this.bytes = bytes;
        this.metadata = metadata;
    }

    public Image() {
    }

    public ObjectId get_id() {
        return _id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String[] getMetadata() {
        return metadata;
    }

    public void setMetadata(String[] metadata) {
        this.metadata = metadata;
    }
}
