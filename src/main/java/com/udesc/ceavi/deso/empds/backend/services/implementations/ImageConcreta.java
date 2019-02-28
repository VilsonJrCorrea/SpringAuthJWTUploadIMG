package com.udesc.ceavi.deso.empds.backend.services.implementations;

import com.mongodb.gridfs.GridFSDBFile;
import com.udesc.ceavi.deso.empds.backend.repository.ImageRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.udesc.ceavi.deso.empds.backend.services.interfaces.ImageService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ImageConcreta implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private GridFsOperations gridFsOperations;


    @Override
    public ObjectId saveImage(MultipartFile multipartFile) {
        DBObject metadata = new BasicDBObject();
        System.out.println(multipartFile.getResource().getFilename());
        InputStream inputStream = null;
        try {
            inputStream = multipartFile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        metadata.put("type", "image");
        gridFsOperations.store(inputStream, multipartFile.getResource().getFilename(), multipartFile.getContentType(), metadata);
    }

    @Override
    public void getImages(String id) {
        GridFSFile gridFSDBFile = gridFsOperations.findOne(new Query(Criteria.where("_id").is(id)));
        System.out.println("File " + gridFSDBFile.getFilename());
    }
}
