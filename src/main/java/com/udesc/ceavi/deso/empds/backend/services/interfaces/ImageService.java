package com.udesc.ceavi.deso.empds.backend.services.interfaces;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {
    public ObjectId saveImage(MultipartFile multipartFile);

    public void getImages(String id);
}
