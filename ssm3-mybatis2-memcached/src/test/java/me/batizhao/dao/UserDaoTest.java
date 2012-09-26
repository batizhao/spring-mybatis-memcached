package me.batizhao.dao;

import me.batizhao.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        user.setId(1002L);
        user.setName("Jacky");

        userDao.saveUser(user);

        user = userDao.getUser(1002L);

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
    public void testGetMultiCache() throws Exception {
        List<Long> list = new ArrayList<Long>();
        list.add(1L);
        list.add(2L);
        list.add(3L);

        List<String> strings = userDao.getMultiCache(list);

        log.info("strings: " + strings);

        assertNotNull(strings);
        assertEquals(3, strings.size());
    }
}
