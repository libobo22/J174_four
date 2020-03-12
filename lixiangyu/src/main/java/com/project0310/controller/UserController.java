package com.project0310.controller;


import com.project0310.entity.UserEntity0310;
import com.project0310.entity.UserInfoEntity;
import com.project0310.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("register")
    public String register(@RequestBody UserEntity0310 user) {
        userService.register(user);
        return "ok";
    }

    @RequestMapping("addUserInfo")
    public String addUserInfo(@RequestBody UserInfoEntity userInfo) {
        userService.addUserInfo(userInfo);
        return "ok";
    }

    @RequestMapping("getUserInfo/{id}")
    public UserEntity0310 getUserInfo(@PathVariable("id") int userId) {
        return userService.getUserInfo(userId);
    }

    @RequestMapping("findAllUser")
    public List<UserEntity0310> findAllUser() {
        return userService.findAllUser();
    }

}
