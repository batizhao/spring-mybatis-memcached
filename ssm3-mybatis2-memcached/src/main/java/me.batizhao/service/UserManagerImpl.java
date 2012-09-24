package me.batizhao.service;

import me.batizhao.dao.UserDao;
import me.batizhao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsersByRoleId(Long id) {
        return userDao.getUsersByRoleId(id);
    }
}
