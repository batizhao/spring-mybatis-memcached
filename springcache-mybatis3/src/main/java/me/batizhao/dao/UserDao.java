package me.batizhao.dao;

import me.batizhao.model.User;
import org.springframework.cache.annotation.Cacheable;

public interface UserDao {

    //@CachePut(value = "user")
    void saveUser(User user);

    @Cacheable(value = "user")
    User getUser(Long id);
}
