package com.project.controller;

import com.project.dto.UserPermissionDTO;
import com.project.entity.UserEntity;
import com.project.service.IUserService;
import com.project.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginVO login, HttpServletRequest request){
        System.out.println("进入login方法");
        System.out.println(login.getLoginName());
        UserEntity user=userService.login(login.getLoginName(),login.getPassword());
        if (user==null){
            return "NoUser";
        }
        request.getSession().setAttribute("currentUser",user);
        List<UserPermissionDTO> list=userService.findPermissionByLoginName(user.getLoginName());
        request.getSession().setAttribute("userPermissionList",list);
        return "ok";
    }
    @RequestMapping("/findPermission")
    @ResponseBody
    public List<UserPermissionDTO> findPermission(HttpServletRequest request){
        System.out.println("findPermission");
        List<UserPermissionDTO> list=(List<UserPermissionDTO>)request.getSession().getAttribute("userPermissionList");
        System.out.println(list.get(0).getPerName());
        return  list;
    }
}
