package com.summerpep.controller;

import com.summerpep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @GetMapping (path = "/")
    public String getHome(){return "home";}
    @PostMapping(path = "/register")
    public String register(){return "user-registration";}
    @GetMapping(path = "/register/success")
    public String success(){return "success";}
}
