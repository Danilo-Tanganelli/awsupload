package br.mackenzie.restapi.springrolejwt.service;



import java.util.List;

import br.mackenzie.restapi.springrolejwt.model.User;
import br.mackenzie.restapi.springrolejwt.model.UserDto;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}
