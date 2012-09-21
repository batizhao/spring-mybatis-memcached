package me.batizhao.dao;

import me.batizhao.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void updateUser(User user);

    User getUser(Long id);

    List<User> getUsers();

    List<User> getUsersByRoleId(Long id);
}
