package com.udesc.ceavi.deso.empds.backend.controller;

import com.udesc.ceavi.deso.empds.backend.model.Image;
import com.udesc.ceavi.deso.empds.backend.services.interfaces.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void saveFile(@RequestParam("file") MultipartFile multipartFile) {
        imageService.saveImage(multipartFile);

    }

    @GetMapping("/get")
    public String getImage(@PathVariable String id) {
        imageService.getImages(id);
        return "";
    }
}
