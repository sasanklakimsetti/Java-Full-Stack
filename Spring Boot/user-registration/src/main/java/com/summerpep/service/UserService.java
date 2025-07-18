package com.summerpep.service;

import com.summerpep.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean checkUser(String username, String mail);
    User addUser(User user);
}
