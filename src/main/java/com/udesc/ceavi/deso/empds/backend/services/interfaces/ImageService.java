package com.udesc.ceavi.deso.empds.backend.services.interfaces;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {
    public void saveImage(MultipartFile multipartFile);

    public void getImages(String id);
}
