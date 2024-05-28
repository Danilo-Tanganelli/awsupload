package br.mackenzie.restapi.springrolejwt.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.mackenzie.restapi.springrolejwt.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}