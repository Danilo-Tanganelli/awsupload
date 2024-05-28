package br.mackenzie.restapi.springrolejwt.service;

import br.mackenzie.restapi.springrolejwt.model.Role;

public interface RoleService {
    Role findByName(String name);
}
