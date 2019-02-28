package com.udesc.ceavi.deso.empds.backend.services.interfaces;

import com.udesc.ceavi.deso.empds.backend.model.Login;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginService {
    List<Login> getAllUsers();

    Login cadastrar(Login login);

    void remover(Login login);
}
