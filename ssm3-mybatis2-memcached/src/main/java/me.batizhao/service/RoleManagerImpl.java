package me.batizhao.service;

import me.batizhao.cache.UserCache;
import me.batizhao.dao.RoleDao;
import me.batizhao.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleManagerImpl implements RoleManager {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserCache userCache;

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
        userCache.invalidateGetUsersByRoleId(role.getId());
    }
}
