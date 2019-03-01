package com.udesc.ceavi.deso.empds.backend.services.interfaces;

import com.mongodb.client.gridfs.model.GridFSFile;
import com.udesc.ceavi.deso.empds.backend.model.Image;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public interface ImageService {
    public Image saveImage(MultipartFile multipartFile);

    public void getImages(String id);
}
