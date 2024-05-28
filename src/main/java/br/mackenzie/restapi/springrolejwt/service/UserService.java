package br.mackenzie.restapi.springrolejwt.service;



import java.util.List;

import br.mackenzie.restapi.springrolejwt.model.UserJwt;
import br.mackenzie.restapi.springrolejwt.model.UserDto;

public interface UserService {
    UserJwt save(UserDto user);
    List<UserJwt> findAll();
    UserJwt findOne(String username);
}
