package me.batizhao.dao;

import me.batizhao.model.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RoleDaoTest extends BaseDaoTestCase {

    @Autowired
    RoleDao roleDao;

    @Test
    public void testSaveRole() throws Exception {
        Role role = new Role();
        role.setId(1010L);
        role.setName("ROLE_DOC_ADMIN");

        roleDao.saveRole(role);

        role = roleDao.getRole(1010L);

        assertNotNull(role);
        assertTrue(role.getName().equals("ROLE_DOC_ADMIN"));

        log.info("Role: " + role);
    }

    @Test
    @Rollback(value = false)
    public void testUpdateRole() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_ADMIN");

        roleDao.updateRole(role);

        /*role = roleDao.getRole(1L);

        assertNotNull(role);
        assertEquals("ROLE_ADMIN", role.getName());

        log.info("Role: " + role);*/
    }

    @Test
    public void testGetRole() throws Exception {
        Role role = roleDao.getRole(1L);

        assertNotNull(role);
        assertTrue(role.getName().equals("ROLE_ADMIN"));

        log.info("Role: " + role);
    }

    @Test
    public void testGetRoles() throws Exception {
        List list = roleDao.getRoles();

        assertNotNull(list);
        assertEquals(2, list.size());

        log.info("Role List: " + list);
    }
}
