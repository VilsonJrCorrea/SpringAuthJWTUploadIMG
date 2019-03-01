package com.udesc.ceavi.deso.empds.backend.controller;

import com.mongodb.client.gridfs.model.GridFSFile;
import com.udesc.ceavi.deso.empds.backend.model.Image;
import com.udesc.ceavi.deso.empds.backend.responses.Response;
import com.udesc.ceavi.deso.empds.backend.services.interfaces.ImageService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/image")
public class ImageController {
    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Response<Image>> saveFile(@RequestParam("file") MultipartFile multipartFile) {
        Image image = imageService.saveImage(multipartFile);
        return ResponseEntity.ok(new Response<Image>(image));
    }

    @GetMapping("/get")
    public String getImage(@PathVariable String id) {
        imageService.getImages(id);
        return "";
    }
}
