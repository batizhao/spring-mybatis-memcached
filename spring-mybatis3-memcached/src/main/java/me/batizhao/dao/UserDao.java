package me.batizhao.dao;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.google.code.ssm.api.format.Serialization;
import com.google.code.ssm.api.format.SerializationType;
import me.batizhao.model.User;

public interface UserDao {

    //@Serialization(SerializationType.JSON)
    //@UpdateSingleCache(namespace = "user", expiration = 30)
    //@ReadThroughSingleCache(namespace = "user", expiration = 30)
    void saveUser(User user);

    //@Select("SELECT * FROM user WHERE id = #{id}")
    @Serialization(SerializationType.JSON)
    @ReadThroughSingleCache(namespace = "user", expiration = 30)
    User getUser(@ParameterValueKeyProvider Long id);
}
