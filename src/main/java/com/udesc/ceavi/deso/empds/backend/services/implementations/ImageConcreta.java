package com.udesc.ceavi.deso.empds.backend.services.implementations;

import com.udesc.ceavi.deso.empds.backend.config.UploadConfig;
import com.udesc.ceavi.deso.empds.backend.model.Image;
import com.udesc.ceavi.deso.empds.backend.repository.ImageRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.udesc.ceavi.deso.empds.backend.services.interfaces.ImageService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ImageConcreta implements ImageService {


    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Image saveImage(MultipartFile multipartFile) {
        String path = "";
        String url = "";
        String nameWithDate = "";
        String originalName = "";
        Image image = null;
        try {
            File dir = new File(UploadConfig.ROOT_PATH);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String timestamp = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
            System.out.println(timestamp);
            originalName = multipartFile.getOriginalFilename();
            nameWithDate = timestamp + multipartFile.getOriginalFilename();
            url = dir.getAbsolutePath() + File.separator + timestamp + multipartFile.getOriginalFilename();
            path = dir.getAbsolutePath();
            System.out.println(url);
            File serverFile = new File(url);
            multipartFile.transferTo(serverFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = imageRepository.save(new Image(originalName, nameWithDate, multipartFile.getSize(), url, path));
        return image;
    }


    @Override
    public Resource findImageById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Image image = mongoTemplate.findOne(query, Image.class);
        Path fileStorageLocation = Paths.get(image.getPath()).toAbsolutePath().normalize();
        Resource resource = findResource(fileStorageLocation, image);
        return resource;
    }

    @Override
    public List<Resource> findAll() {
        List<Image> images = mongoTemplate.findAll(Image.class);
        List<Resource> resourcesList = new ArrayList<>();
        for (Image image : images) {
            Path fileStorageLocation = Paths.get(image.getPath()).toAbsolutePath().normalize();
            Resource resource = findResource(fileStorageLocation, image);
            resourcesList.add(resource);
        }
        return resourcesList;
    }

    private Resource findResource(Path fileStorageLocation, Image image) {
        Resource resource = null;
        try {
            Files.createDirectories(fileStorageLocation);
            Path filePath = fileStorageLocation.resolve(image.getNameWithDate()).normalize();
            resource = new UrlResource(filePath.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resource;
    }
}
