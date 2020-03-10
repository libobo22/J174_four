package com.project0310.controller;

import com.project0310.bean.InfoBean;
import com.project0310.bean.UserBean;
import com.project0310.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/addUser")
    public String addUser(@RequestBody UserBean user){
        System.out.println("进入service的addUser:"+user.getUserName());
        userService.addUser(user);
        return "ok";
    }
    @RequestMapping("/findAll")
    public List<UserBean> findAll(){
        System.out.println("进入service的findAll");
        return userService.findAll();
    }
    @RequestMapping("/findUserInfoById")
    public UserBean findUserInfoById(Integer userId){

        return userService.findUserInfoById(userId);
    }

    @RequestMapping("/addInfo")
    public String addInfo(Integer userId, InfoBean info){
        userService.addInfo(userId,info);
        return "ok";
    }
}
