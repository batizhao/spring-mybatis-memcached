package me.batizhao.dao;

import com.google.code.ssm.api.*;
import me.batizhao.model.Role;
import me.batizhao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Override
    public void saveRole(Role role) {
        sqlMapClientTemplate.insert("saveRole", role);
    }

    @Override
    @UpdateSingleCache(namespace = "role", expiration = 60)
    public void updateRole(@ParameterValueKeyProvider @ParameterDataUpdateContent Role role) {
        sqlMapClientTemplate.update("updateRole", role);
    }

    @Override
    @ReadThroughSingleCache(namespace = "role", expiration = 60)
    public Role getRole(@ParameterValueKeyProvider Long id) {
        return (Role) sqlMapClientTemplate.queryForObject("getRole", id);
    }

    @Override
    @ReadThroughAssignCache(assignedKey = "getRoles", namespace = "role", expiration = 60)
    public List<Role> getRoles() {
        return sqlMapClientTemplate.queryForList("getRoles");
    }
}
