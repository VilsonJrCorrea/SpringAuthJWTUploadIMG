package com.udesc.ceavi.deso.empds.backend.controller;

import com.mongodb.client.gridfs.model.GridFSFile;
import com.udesc.ceavi.deso.empds.backend.config.UploadConfig;
import com.udesc.ceavi.deso.empds.backend.model.Image;
import com.udesc.ceavi.deso.empds.backend.responses.Response;
import com.udesc.ceavi.deso.empds.backend.services.interfaces.ImageService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/images")
public class ImageController {
    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Response<Image>> saveFile(@RequestParam("file") MultipartFile multipartFile) {
        Image image = imageService.saveImage(multipartFile);
        return ResponseEntity.ok(new Response<Image>(image));
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable String id, HttpServletRequest request) {
        Resource resource = imageService.findImageById(id);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, resource.getFilename()).body(resource);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Resource>> getAllImages(HttpServletRequest request) {
        List<Resource> resources = imageService.findAll();
        System.out.println(resources.size());
        String contentType = null;
//        for (Resource resource : resources) {
//            try {
//                contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//            if (contentType == null) {
//                contentType = "application/octet-stream";
//            }
//        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "TUDO!!!!").body(resources);
    }


}
