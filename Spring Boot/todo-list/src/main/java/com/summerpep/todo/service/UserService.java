package com.summerpep.todo.service;

import com.summerpep.todo.model.User;

public interface UserService {
    User findUsername(String username);
    User addUser(User user);
}
