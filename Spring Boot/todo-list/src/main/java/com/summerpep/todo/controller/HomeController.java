package com.summerpep.todo.controller;

import com.summerpep.todo.model.ToDo;
import com.summerpep.todo.service.ToDoService;
import com.summerpep.todo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    ToDoService toDoService;
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String requestMethodName(){
        return "todohome";
    }

    @PostMapping(path = "/login")
    public String loginPage(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            ModelMap map, HttpServletRequest request)
    {
        if(userService.checkLogin(username, password)){
            HttpSession session=request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("logintime", new Date());
            session.setAttribute("ipaddress", request.getRemoteAddr());
            List<ToDo>list= toDoService.findAllByUsername(username);
            map.put("list", list);
            map.put("username", username);
            return "todos-view";
        }
        else{
            map.put("error","Invalid username or password");
            return "todohome";
        }
    }
}
