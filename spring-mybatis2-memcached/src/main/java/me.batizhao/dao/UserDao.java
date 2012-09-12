package me.batizhao.dao;

import me.batizhao.model.User;

public interface UserDao {

    void saveUser(User user);

    User getUser(Long id);
}
