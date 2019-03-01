package com.udesc.ceavi.deso.empds.backend.services.implementations;

import com.udesc.ceavi.deso.empds.backend.model.Image;
import com.udesc.ceavi.deso.empds.backend.repository.ImageRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.udesc.ceavi.deso.empds.backend.services.interfaces.ImageService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Service
public class ImageConcreta implements ImageService {

    @Autowired
    private ImageRepository imageRepository;
//
//    @Autowired
//    private GridFsOperations gridFsOperations;

    @Override
    public Image saveImage(MultipartFile multipartFile) {
        Image image = null;
        try {
            String[] metadata = {"type", "image"};
            image = imageRepository.save(new Image(multipartFile.getOriginalFilename(), multipartFile.getContentType(), multipartFile.getBytes(), metadata));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        DBObject metadata = new BasicDBObject();
//        System.out.println(multipartFile.getResource().getFilename());
//        InputStream inputStream = null;
//        try {
//            inputStream = multipartFile.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        metadata.put("type", "image");
//        ObjectId objectId = gridFsOperations.store(inputStream, multipartFile.getResource().getFilename(), multipartFile.getContentType(), metadata);
//        Query query = new Query();
//        query.addCriteria(Criteria.where("_id").is(objectId));

//        multipartFile.getResource()
//        multipartFile.getContentType()
//        multipartFile.getInputStream()
//        multipartFile.getBytes()
//        GridFSFile gridFSFile = gridFsOperations.findOne(query);
//        GridFsResource gridFsResource = gridFsOperations.getResource(gridFSFile);
//    imageRepository.save()

//        Image image = new Image(multipartFile, multipartFile.getName());
//        image = imageRepository.save(image);

        return image;
    }
//        return ResponseEntity.ok(new Response<Login>(this.loginService.cadastrar(login)));

    @Override
    public void getImages(String id) {
//        GridFSFile gridFSDBFile = gridFsOperations.findOne(new Query(Criteria.where("_id").is(id)));
//        System.out.println("File " + gridFSDBFile.getFilename());
    }
}
