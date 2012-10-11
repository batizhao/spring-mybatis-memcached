package me.batizhao.dao;

import me.batizhao.model.Role;
import me.batizhao.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserDaoTest extends BaseDaoTestCase {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSaveUser() throws Exception {

        User user = new User();
        user.setId(1003L);
        user.setName("Jacky");

        userDao.saveUser(user);

        user = userDao.getUser(1003L);

        assertNotNull(user);
        assertTrue(user.getName().equals("Jacky"));

        log.info("User: " + user);

    }

    @Test
    //@Rollback(value = false)
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setId(1000L);
        user.setName("Tom");

        userDao.updateUser(user);

        user = userDao.getUser(1000L);

        assertNotNull(user);
        assertEquals("Tom", user.getName());

        log.info("User: " + user);
    }

    @Test
    public void testGetUser() throws Exception {

        User user = userDao.getUser(1000L);

        assertNotNull(user);
        assertTrue(user.getName().equals("Tom"));

        log.info("User: " + user);

    }

    @Test
    public void testGetUsersByRoleId() throws Exception {
        List list = userDao.getUsersByRoleId(1L);

        assertNotNull(list);
        assertEquals(2, list.size());

        log.info("UserList: " + list);
    }

    @Test
    public void testGetUsersByRoleIds() throws Exception {
        List<Long> list = Arrays.asList(1L, 2L);

        List users = userDao.getUsersByRoleIds(list);

        log.info("users: " + users);

        assertNotNull(users);
        assertEquals(3, users.size());
    }

    @Test
    public void testGetUsersByRoles() throws Exception {
        Role role1 = new Role();
        role1.setId(1L);

        Role role2 = new Role();
        role2.setId(2L);

        List<Role> list = Arrays.asList(role1, role2);

        List users = userDao.getUsersByRoles(list);

        log.info("users: " + users);

        assertNotNull(users);
        assertEquals(3, users.size());
    }

    @Test
    public void testGetUsersByUserIds() throws Exception {
        List<Long> list = Arrays.asList(1000L, 1001L);

        List users = userDao.getUsersByUserIds(list);

        log.info("users: " + users);

        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    @Rollback(value = false)
    public void testUpdateUsersByUserIds() throws Exception {
        User user1 = new User();
        user1.setId(1000L);
        user1.setName("Messi");

        User user2 = new User();
        user2.setId(1001L);
        user2.setName("Vpersi");

        List<User> list = Arrays.asList(user1, user2);

        userDao.updateUsersByUserIds(list);

        User user = userDao.getUser(1000L);

        assertNotNull(user);
        assertTrue(user.getName().equals("Messi"));

        log.info("User1: " + user);

        user = userDao.getUser(1001L);

        assertNotNull(user);
        assertTrue(user.getName().equals("Vpersi"));

        log.info("User2: " + user);
    }
}
