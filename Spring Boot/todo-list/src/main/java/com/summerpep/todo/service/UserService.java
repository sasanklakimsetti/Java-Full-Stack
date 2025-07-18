package com.summerpep.todo.service;

import com.summerpep.todo.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User findUsername(String username);
    User addUser(User user);
    boolean remove(User user);
    User updateUser(User user);
    boolean checkLogin(String username, String password);
    List<User>findAll();
    User patchUser(Map<String, String> map);
}
