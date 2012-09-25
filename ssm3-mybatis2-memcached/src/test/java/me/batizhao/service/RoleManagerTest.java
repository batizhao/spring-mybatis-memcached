package me.batizhao.service;

import me.batizhao.dao.BaseDaoTestCase;
import me.batizhao.model.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import static org.junit.Assert.assertEquals;

public class RoleManagerTest extends BaseDaoTestCase{

    @Autowired
    private RoleManager roleManager;

    @Test
    //@Rollback(value = false)
    public void testUpdateRole() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_ADMIN");

        roleManager.updateRole(role);

        role = roleManager.getRole(1L);

        log.info("Role: " + role);

        assertEquals("ROLE_ADMIN", role.getName());

    }
}
