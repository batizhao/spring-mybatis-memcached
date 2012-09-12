package me.batizhao;

import me.batizhao.dao.UserDao;
import me.batizhao.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
    public void testGetUser() throws Exception {

        User user = userDao.getUser(1000L);

        assertNotNull(user);
        assertTrue(user.getName().equals("Tom"));

        log.info("User: " + user);

    }

}
