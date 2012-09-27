package me.batizhao.dao;

import com.google.code.ssm.api.*;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import me.batizhao.model.Role;
import me.batizhao.model.User;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Override
    public void saveUser(User user) {
        sqlMapClientTemplate.insert("saveUser", user);
    }

    @Override
    @ReadThroughSingleCache(namespace = "user", expiration = 600)
    public User getUser(@ParameterValueKeyProvider Long id) {
        return (User) sqlMapClientTemplate.queryForObject("getUser", id);
    }

    @Override
    @UpdateSingleCache(namespace = "user", expiration = 60)
    public void updateUser(@ParameterValueKeyProvider @ParameterDataUpdateContent User user) {
        sqlMapClientTemplate.update("updateUser", user);
    }

    @Override
    @ReadThroughMultiCache(namespace = "user", expiration = 600)
    public List<User> getUsersByUserIds(@ParameterValueKeyProvider List<Long> ids) {
        return (List<User>) sqlMapClientTemplate.queryForList("getUsersByUserIds", ids);
    }

    @Override
    @UpdateMultiCache(namespace = "user", expiration = 60)
    public void updateUsersByUserIds(@ParameterValueKeyProvider @ParameterDataUpdateContent final List<User> users) {
        sqlMapClientTemplate.execute(new SqlMapClientCallback() {
            @Override
            public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                executor.startBatch();

                for(User user: users){
                    executor.update("updateUser", user);
                }

                executor.executeBatch();

                return null;

            }
        });
    }

    @Override
    @ReadThroughSingleCache(namespace = "user/list", expiration = 600)
    public List<User> getUsersByRoleId(@ParameterValueKeyProvider Long id) {
        return (List<User>) sqlMapClientTemplate.queryForList("getUsersByRoleId", id);
    }

    @Override
    @ReadThroughMultiCache(namespace = "user/getUsersByRoleIds", expiration = 60, option = @ReadThroughMultiCacheOption(generateKeysFromResult = true))
    public List<User> getUsersByRoleIds(@ParameterValueKeyProvider final List<Long> ids) {
        return (List<User>) sqlMapClientTemplate.queryForList("getUsersByRoleIds", ids);
    }

    @Override
    @ReadThroughMultiCache(namespace = "user/getUsersByRoles", expiration = 60, option = @ReadThroughMultiCacheOption(generateKeysFromResult = true))
    //@ReadThroughAssignCache(assignedKey = "user/getUsersByRoles", namespace = "user", expiration = 60)
    public List<User> getUsersByRoles(@ParameterValueKeyProvider final List<Role> roles) {
        return (List<User>) sqlMapClientTemplate.queryForList("getUsersByRoles", roles);
    }

}
