package com.udesc.ceavi.deso.empds.backend.controller;

import com.udesc.ceavi.deso.empds.backend.model.Image;
import com.udesc.ceavi.deso.empds.backend.responses.Response;
import com.udesc.ceavi.deso.empds.backend.services.interfaces.ImageService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/image")
public class ImageController {
    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Response<ObjectId>> saveFile(@RequestParam("file") MultipartFile multipartFile) {
        ObjectId objectId = imageService.saveImage(multipartFile);
        return ResponseEntity.ok(new Response(objectId));
    }

    @GetMapping("/get")
    public String getImage(@PathVariable String id) {
        imageService.getImages(id);
        return "";
    }
}
