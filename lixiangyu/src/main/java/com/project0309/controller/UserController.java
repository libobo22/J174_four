package com.project0309.controller;

import com.project0309.entity.UserEntity;
import com.project0309.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;


//@Controller
//public class UserController {
//    @Autowired
//    private IUserService userService;
//
//    @RequestMapping("find/{userName}")
//    @ResponseBody
//    public UserEntity findByUserName(@PathVariable("userName") String userName) {
//        return userService.findByUserName(userName);
//    }
//
//    @RequestMapping("add")
//    public void addUser(@RequestBody @Valid UserEntity userEntity, BindingResult result, HttpServletResponse response) throws IOException {
//        if (result.hasErrors()) {//判断验证是否有错误信息
//            //错误信息字符串
//            String str = "";
//            //遍历验证错误的集合，并且拼接错误信息
//            for (FieldError fieldError : result.getFieldErrors()) {
//                str += fieldError.getDefaultMessage() + "<br>";
//            }
//            //把错误信息字符串响应给浏览器
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().print(str);
//            //跳出方法
//            return;
//        }
//        userService.addUser(userEntity);
//        //成功则响应字符串ok
//        response.getWriter().print("ok");
//    }
//
//}
