package br.mackenzie.restapi.springrolejwt.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.mackenzie.restapi.springrolejwt.model.UserJwt;

@Repository
public interface UserDao extends CrudRepository<UserJwt, Long> {
    UserJwt findByUsername(String username);
}