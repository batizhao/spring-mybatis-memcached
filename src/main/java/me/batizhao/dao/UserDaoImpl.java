package me.batizhao.dao;

import com.google.code.ssm.api.ParameterDataUpdateContent;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.google.code.ssm.api.format.Serialization;
import com.google.code.ssm.api.format.SerializationType;
import me.batizhao.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserDaoImpl implements UserDao {

    private static final String PREFIX = "1/";

    private static final String SINGLE_NS = PREFIX + "user/s";

    private static final String LIST_NS = PREFIX + "user/l";

    @Override
    public User saveUser(@ParameterDataUpdateContent @ParameterValueKeyProvider User user) {
        return null;
    }

    @Override
    @Serialization(SerializationType.JSON)
    @ReadThroughSingleCache(namespace = SINGLE_NS, expiration = 30)
    public User getUser(@ParameterValueKeyProvider Long id) {
        User user = new User();
        user.setId(id);
        user.setName("batizhao");

        return user;
    }
}
