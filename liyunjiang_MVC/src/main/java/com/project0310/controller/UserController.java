package com.project0310.controller;

import com.project.VO.UserVO;
import com.project0310.VO.InfoVO;
import com.project0310.utils.SendRequestUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/addUser")
    public String addUser(@RequestBody UserVO user){
        String json=SendRequestUtil.sendObjectParamRequest("http://localhost:8080/liyunjiang/user/addUser",user);
        return json;
    }
    @RequestMapping("/findAll")
    public String findAll(){
        String json=SendRequestUtil.sendGeneralParamRequest("http://localhost:8080/liyunjiang/user/findAll","get");
        return json;
    }
    @RequestMapping("/findUserInfoById")
    public String findUserInfoById(Integer userId){
        System.out.println("find..........");
        String json=SendRequestUtil.sendGeneralParamRequest("http://localhost:8080/liyunjiang/user/findUserInfoById?userId="+userId,"get");
        System.out.println(json);
        return json;
    }

    @RequestMapping("/addInfo")
    public String addInfo(Integer userId, InfoVO info){
        String uri="http://localhost:8080/liyunjiang/user/addInfo?userId="+userId+"&job="+info.getJob()+"&money="+info.getMoney()+"&changeDate="+info.getChangeDate();
        String json=SendRequestUtil.sendGeneralParamRequest(uri,"get");
        return json;
    }
}
