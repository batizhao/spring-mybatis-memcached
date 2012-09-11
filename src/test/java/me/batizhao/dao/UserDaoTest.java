package me.batizhao.dao;

import me.batizhao.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: bati
 * Date: 12-9-10
 * Time: 下午4:38
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoTest extends BaseDaoTestCase {

    private User newUser;
    private User cacheUser;

    @Autowired
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        newUser = new User();
        newUser.setId(2000L);
        newUser.setName("batizhao");
    }

    @Test
    public void testGetUser() throws Exception {
        cacheUser = userDao.getUser(2000L);

        log.info("cacheUser:" + cacheUser);

        assertTrue(newUser.equals(cacheUser));

    }
}
