package com.summerpep.todo.service;

import com.summerpep.todo.model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class UserServiceImplTest {
    public static List<String>list=new ArrayList<>();
    @Autowired
    UserService userService;
    @Test
    void testFindUsername() {
        User byUsername=userService.findUsername("yash");
        assertNotNull(byUsername);
    }
    @Test
    void testFindUsernameNotExist(){
        User byUsername=userService.findUsername("ayush234");
        assertNull(byUsername);
    }
    @Test
    void testFindUsernameNullValue(){
        User byUsername=userService.findUsername(null);
        assertNull(byUsername);
    }
    @Test
    void testAddUser() {
        String username="sasank"+System.currentTimeMillis();
        User user=new User(username,"sasank", true);
        userService.addUser(user);
        list.add(username);
    }
    @AfterAll
    public static void afterAllTests(){
        // delete the dummy data
    }
}