package com.summerpep.todo.controller;

import com.summerpep.todo.model.User;
import com.summerpep.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/api")
// instead of Controller and ResponseBody seperately, we can use RestController which combines both
// It will be acted as a Controller where all methods of it returns the object (JSON) i.e. actual response, not view name
public class UserController {
    @Autowired
    UserService userService;
    // automatically REST API is converting the result object to json
    @GetMapping(path = "/user", produces = "application/json")
//    @ResponseBody
    public User getUser(@RequestParam("username") String username){
        return userService.findUsername(username);  // usually this will return name of the view
        // but due to the annotation @ResponseBody, it will show the data in json format
    }
    @GetMapping(path = "/users", produces = "application/json")
    public List<User>findAll(){
        return userService.findAll();
    }
    // the user will post the data on the same data
    // data is coming through RequestBody
    // the data came will be converted automatically into json
    // this will be adding the user to the table
    @PostMapping(path = "/user", consumes = "application/json")
    public User addUser(@RequestBody User user){
        User added = userService.addUser(user);
        return added;
    }

    // this will delete a user from the table
    @DeleteMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public String deleteUser(@RequestBody User user){
        boolean removed=userService.remove(user);
        if(removed) return "User "+user.getUsername()+" deleted";
        return "Failed deleting "+user.getUsername();
    }

    // this will update the details of the user already existed
    @PutMapping(path = "user", consumes = "application/json", produces = "application/json")
    public User putMethodName(@RequestBody User user){
        return userService.updateUser(user);
    }
}
