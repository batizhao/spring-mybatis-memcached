package me.batizhao.service;

import me.batizhao.model.User;

import java.util.List;

public interface UserManager {

    List<User> getUsersByRoleId(Long id);
}
