package com.project.test;

import com.project.entity.UserEntity;
import com.project.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JPATest {
    @Autowired
    private IUserService userService;
    @Test
    public void findAllUser(){
        List<UserEntity> list=userService.findUserList("0");
        System.out.println(list.size());
    }
    @Test
    public void findListMap(){
        List<Map> list=userService.getListMap();
        System.out.println(list.size());
    }
    @Test
    public void findAll(){
        List<UserEntity> list=userService.findAll();
        System.out.println(list.size());
    }
    @Test
    public void findAllById(){
        List<UserEntity> list=userService.findAllById();
        System.out.println(list.size());
    }

    @Test
    public void findById(){
        UserEntity user=userService.findById(5);
        System.out.println(user.getUserName());
    }
    @Test
    public void save(){
        UserEntity user=new UserEntity();
//        user.setUserId(7);
        user.setUserName("libobo");
        user.setPassword("7034520");
        user.setLoginName("李达");
        user.setUserStatus("1");
        user=userService.save(user);
        System.out.println(user.getUserId());
    }
    @Test
    public void deleteById(){
        userService.deleteById(7);
    }


}
