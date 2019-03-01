package com.udesc.ceavi.deso.empds.backend.services.interfaces;

import com.mongodb.client.gridfs.model.GridFSFile;
import com.udesc.ceavi.deso.empds.backend.model.Image;
import org.bson.types.ObjectId;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public interface ImageService {
    public Image saveImage(MultipartFile multipartFile);

    public Resource findImageById(String id);

    public List<Resource> findAll();
}
