package com.project.test;

import com.project.entity.UserEntity;
import com.project.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
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
        user.setUserName("lo");
        user.setPassword("7034520");
        user.setLoginName("令狐冲");
        user.setUserStatus("1");
        user=userService.save(user);
        System.out.println(user.getUserId());
    }
    @Test
    public void saveAll(){
        List<UserEntity> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserEntity user=new UserEntity();
            user.setUserName("赵云"+i);
            user.setPassword("703452"+i);
            user.setLoginName("abc"+i);
            user.setUserStatus("1");
            list.add(user);
        }
        userService.saveAll(list);
    }

    @Test
    public void deleteById(){
        userService.deleteById(7);
    }
    @Test
    public void pageCutTest(){
        PageRequest pageRequest=PageRequest.of(1,5);
        List<UserEntity> list=userService.getPageList("1",pageRequest);
        System.out.println(list.size());
    }
}
