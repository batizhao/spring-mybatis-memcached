package me.batizhao.dao;

import me.batizhao.model.Role;
import me.batizhao.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserDao{

    void saveUser(User user);

    /**
     * \\@ReadThroughSingleCache demo
     * @param id
     * @return
     */
    User getUser(Long id);

    /**
     * \\@UpdateSingleCache demo
     * @param user
     * @return
     */
    void updateUser(User user);

    /**
     * \\@ReadThroughMultiCache demo
     * @param ids
     * @return
     */
    List<User> getUsersByUserIds(List<Long> ids);

    /**
     * \\@UpdateMultiCache demo
     * @param users
     */
    void updateUsersByUserIds(List<User> users);

    List<User> getUsersByRoleId(Long id);

    /**
     * \\@ReadThroughAssignCache demo
     * @param ids
     * @return
     */
    List<User> getUsersByRoleIds(List<Long> ids);
    List<User> getUsersByRoles(List<Role> roles);
}
