package com.project;


import com.project.entity.UserEntity;
import com.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private IUserService service;

    @RequestMapping("find/{userName}")
    @ResponseBody
    public UserEntity findByUserName(@PathVariable("userName") String userName){
     return  service.findByUserName(userName);
    }
}
