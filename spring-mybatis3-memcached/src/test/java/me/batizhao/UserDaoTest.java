package me.batizhao;

import me.batizhao.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserDaoTest extends BaseDaoTestCase {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSaveUser() throws Exception {
        /*User user = new User();
        user.setId(1002L);
        user.setName("Jacky");

        userDao.saveUser(user);*/

        User user = userDao.getUser(1001L);

        assertNotNull(user);
        assertTrue(user.getName().equals("Jerry"));

        log.info("User: " + user);

    }

    /*@Test
    public void testGetUser() throws Exception {
        cacheUser = userDao.getUser(2000L);

        log.info("cacheUser:" + cacheUser);

        assertTrue(newUser.equals(cacheUser));

    }*/

}
