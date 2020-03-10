package com.project.controller;


import com.project.entity.UserEntity;
import com.project.service.IUserService;
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
    private IUserService service;

    @RequestMapping("find/{userName}")
    @ResponseBody
    public UserEntity findByUserName(@PathVariable("userName") String userName){
     return  service.findByUserName(userName);
    }

    @RequestMapping("add")
    public void addUser(@RequestBody UserEntity userEntity, HttpServletResponse response) throws IOException {
        service.addUser(userEntity);
        response.getWriter().print(userEntity.getUserName());
    }
}
