package me.batizhao.service;

import me.batizhao.model.Role;

public interface RoleManager {

    void updateRole(Role role);

    Role getRole(Long id);
}
