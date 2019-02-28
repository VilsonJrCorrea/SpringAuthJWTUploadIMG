package com.udesc.ceavi.deso.empds.backend.repository;

import com.udesc.ceavi.deso.empds.backend.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {

}
