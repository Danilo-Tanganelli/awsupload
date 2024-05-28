package br.mackenzie.restapi.springrolejwt.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mackenzie.restapi.springrolejwt.dao.RoleDao;
import br.mackenzie.restapi.springrolejwt.model.Role;
import br.mackenzie.restapi.springrolejwt.service.RoleService;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findByName(String name) {
        Role role = roleDao.findRoleByName(name);
        return role;
    }
}
