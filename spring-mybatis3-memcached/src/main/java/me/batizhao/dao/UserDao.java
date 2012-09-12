package me.batizhao.dao;

import me.batizhao.model.User;

public interface UserDao {

    void saveUser(User user);

    //@Select(value = "SELECT * FROM user WHERE id = #{id}")
    User getUser(Long id);
}
