package me.batizhao.dao;

import me.batizhao.model.User;

import java.util.List;

public interface UserDao{

    void saveUser(User user);

    User getUser(Long id);

    void updateUser(User user);

    List<User> getUsersByRoleId(Long id);
}
