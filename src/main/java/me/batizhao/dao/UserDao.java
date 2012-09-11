package me.batizhao.dao;

import me.batizhao.model.User;

public interface UserDao {

    User saveUser(User user);

    User getUser(Long id);
}
