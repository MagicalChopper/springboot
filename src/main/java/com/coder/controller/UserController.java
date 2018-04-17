package com.coder.controller;

import com.coder.entity.User;
import com.coder.service.UserService;
import com.coder.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value="create",method = RequestMethod.POST)
    public String createUser(User user){
        userService.createUser(user);
        return "index";
    }

    @RequestMapping(value="remove",method = RequestMethod.GET)
    public String deleteUser(long id){
        userService.deleteUser(id);
        return "index";
    }

    @RequestMapping(value="update",method = RequestMethod.POST)
    public String updateUser(User user){
        userService.updateUser(user);
        return "index";
    }

    @RequestMapping(value="findById",method = RequestMethod.GET)
    public String retrieveOne(long id){
        User user = userService.retrieveOne(id);
        return "index";
    }

    @RequestMapping("findAll")
    public String retrieveAll(){
        List<User> list = userService.retrieveAll();
        return "index";
    }

}
