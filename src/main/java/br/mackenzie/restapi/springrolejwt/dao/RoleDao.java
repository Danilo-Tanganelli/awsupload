package br.mackenzie.restapi.springrolejwt.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.mackenzie.restapi.springrolejwt.model.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {
    Role findRoleByName(String name);
}