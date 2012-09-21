package me.batizhao.dao;

import me.batizhao.model.Role;

import java.util.List;

public interface RoleDao {

    void saveRole(Role role);

    void updateRole(Role role);

    Role getRole(Long id);

    List<Role> getRoles();
}
