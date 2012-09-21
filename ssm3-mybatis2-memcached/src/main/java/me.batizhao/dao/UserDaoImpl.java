package me.batizhao.dao;

import com.google.code.ssm.api.ParameterDataUpdateContent;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.google.code.ssm.api.UpdateSingleCache;
import com.google.code.ssm.api.format.Serialization;
import com.google.code.ssm.api.format.SerializationType;
import com.ibatis.sqlmap.client.SqlMapClient;
import me.batizhao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

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
    //@Serialization(SerializationType.JSON)
    @ReadThroughSingleCache(namespace = "user", expiration = 600)
    public User getUser(@ParameterValueKeyProvider Long id) {
        return (User) sqlMapClientTemplate.queryForObject("getUser", id);
    }

    @Override
    @ReadThroughSingleCache(namespace = "user/list", expiration = 600)
    public List<User> getUsersByRoleId(@ParameterValueKeyProvider Long id) {
        return (List<User>) sqlMapClientTemplate.queryForList("getUsersByRoleId", id);
    }
}
