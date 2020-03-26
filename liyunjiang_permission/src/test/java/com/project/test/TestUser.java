package com.project.test;

import com.project.dao.BasicDao;
import com.project.dto.UserPermissionDTO;
import com.project.entity.UserEntity;
import com.project.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUser {
    @Autowired
    private IUserService userService;
    @Test
    public void login(){
        UserEntity user=userService.login("abc","123123");
        System.out.println(user.getUserName());
    }
    @Test
    public void findPermission(){
        List<UserPermissionDTO> list=userService.findPermissionByLoginName("superAdmin");
        System.out.println(list.size());
    }
}
