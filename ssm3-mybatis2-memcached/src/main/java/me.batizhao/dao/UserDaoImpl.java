package me.batizhao.dao;

import com.google.code.ssm.api.*;
import me.batizhao.model.User;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Override
    public void saveUser(User user) {
        sqlMapClientTemplate.insert("saveUser", user);
    }

    @Override
    @UpdateSingleCache(namespace = "user", expiration = 60)
    public void updateUser(@ParameterValueKeyProvider @ParameterDataUpdateContent User user) {
        sqlMapClientTemplate.update("updateUser", user);
    }

    @Override
    @ReadThroughSingleCache(namespace = "user", expiration = 600)
    public User getUser(@ParameterValueKeyProvider Long id) {
        return (User) sqlMapClientTemplate.queryForObject("getUser", id);
    }

    @Override
    @ReadThroughSingleCache(namespace = "user/list", expiration = 600)
    public List<User> getUsersByRoleId(@ParameterValueKeyProvider Long id) {
        return (List<User>) sqlMapClientTemplate.queryForList("getUsersByRoleId", id);
    }

    @Override
    @ReadThroughMultiCache(namespace = "user/getUsersByUserIds", expiration = 60, option = @ReadThroughMultiCacheOption(generateKeysFromResult = true))
    public List<User> getUsersByRoleIds(@ParameterValueKeyProvider final List<Long> ids) {
        return (List<User>) sqlMapClientTemplate.queryForList("getUsersByRoleIds", ids);
    }

    @Override
    @ReadThroughMultiCache(namespace = "Delta", expiration = 1000)
    public List<String> getMultiCache(@ParameterValueKeyProvider final List<Long> keys) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.print(ex.getMessage());
        }
        final String series = RandomStringUtils.randomAlphabetic(6);
        final List<String> results = new ArrayList<String>(keys.size());
        for (final Long key : keys) {
            results.add(series + "-" + key.toString() + "-" + RandomStringUtils.randomAlphanumeric(25 + RandomUtils.nextInt(30)));
        }
        return results;
    }
}
