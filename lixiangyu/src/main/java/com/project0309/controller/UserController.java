package com.project0309.controller;

import com.project0309.entity.UserEntity;
import com.project0309.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("find/{userName}")
    @ResponseBody
    public UserEntity findByUserName(@PathVariable("userName") String userName) {
        return userService.findByUserName(userName);
    }

    @RequestMapping("add")
    public void addUser(@RequestBody UserEntity userEntity, HttpServletResponse response) throws IOException {
        userService.addUser(userEntity);
        response.getWriter().print("ok");
    }

}
