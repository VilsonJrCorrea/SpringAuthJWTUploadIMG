package com.udesc.ceavi.deso.empds.backend.repository;

import com.udesc.ceavi.deso.empds.backend.model.Login;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRepository extends MongoRepository<Login, String> {
    Login findByCnpj(String cnpj);

}
