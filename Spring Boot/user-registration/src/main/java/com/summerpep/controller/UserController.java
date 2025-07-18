package com.summerpep.controller;

import com.summerpep.model.User;
import com.summerpep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> register(@RequestBody User user){
        if(userService.checkUser(user.getUsername(), user.getMail())){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email already exists");
        }
        userService.addUser(user);
        return ResponseEntity.ok("User added successfully");
    }
}
