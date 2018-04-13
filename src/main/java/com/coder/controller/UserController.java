package com.coder.controller;

import com.coder.entity.User;
import com.coder.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/index")
    public String index(){

        return "user/index";
    }

    /**
     * http://localhost:8080/user/show?name="lh"
     * @param name
     * @return
     */
    @RequestMapping(value = "/show")
    @ResponseBody
    public String show(@RequestParam(value = "name")String name){
        User user = userService.findUserByName(name);
        if(null != user){
            return user.getId()+"/"+user.getName()+"/"+user.getPassword();
        }
        else {
            return "null";
        }
    }
}
