package com.summerpep.todo.controller;

import com.summerpep.todo.model.User;
import com.summerpep.todo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

import javax.sound.midi.Soundbank;

//@Controller
@RestController
@RequestMapping("/api")
// instead of Controller and ResponseBody seperately, we can use RestController which combines both
// It will be acted as a Controller where all methods of it returns the object (JSON) i.e. actual response, not view name
public class UserController {
    @Autowired
    UserService userService;
    private static final Logger log= LoggerFactory.getLogger(UserController.class);
    // automatically REST API is converting the result object to json
//    @GetMapping(path = "/user", produces = "application/json")
////    @ResponseBody
//    public User getUser(@RequestParam("username") String username){
//        return userService.findUsername(username);  // usually this will return name of the view
//        // but due to the annotation @ResponseBody, it will show the data in json format
//    }
//  {username} is used for not to do hardcoding. it will be passed as parameters for fetching
    @GetMapping(path = "/user/{username}", produces = "application/json")
    public User getUserByName(@PathVariable("username") String username){
        log.debug("request for user {}", username);  // {} is like %d in c programming
        return userService.findUsername(username);  // returns actual data
    }

    @GetMapping(path = "/user",produces = "application/json")
    public User getUser(@RequestParam("username") String username, HttpServletRequest request){
        Enumeration<String>headerNames=request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName=headerNames.nextElement();
            String headerValue=request.getHeader(headerName);
            System.out.println(headerName+": "+headerValue);
        }
        return userService.findUsername(username);
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

    @PatchMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public User patchUser(@RequestBody Map<String, String> map){
        User patched=userService.patchUser(map);
        return patched;
    }

    @GetMapping("/qualification")
    public String saveQualification(@RequestParam Map<String, String> map,
                                    HttpServletRequest request,
                                    HttpSession session,
                                    @SessionAttribute String username){
        request.getSession().getAttribute("username");
        log.debug("{}", map);
        return "qualification saved";
    }
}
