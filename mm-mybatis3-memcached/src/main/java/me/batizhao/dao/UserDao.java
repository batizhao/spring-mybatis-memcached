package me.batizhao.dao;

import me.batizhao.model.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    void saveUser(User user);

    User getUser(Long id);
}
