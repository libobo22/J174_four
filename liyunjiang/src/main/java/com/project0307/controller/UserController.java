package com.project0307.controller;

import com.project0307.entity.UserEntity;
import com.project0307.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/findByUserName")
    public UserEntity findByUserName(String userName){
        System.out.println("service:"+userName);
        UserEntity user=userService.findByUserName(userName);
        System.out.println(user);
        return user;
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody UserEntity user){
        System.out.println(user.getUserName());
        userService.addUser(user);
        return "ok";
    }
}
