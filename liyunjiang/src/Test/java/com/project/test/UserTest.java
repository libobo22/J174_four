package com.project.test;

import com.project0310.bean.InfoBean;
import com.project0310.bean.UserBean;
import com.project0310.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserTest {
    @Autowired
    private IUserService userService;
    @Test
    public void test1(){
//        UserBean user=new UserBean();
//        user.setUserName("xxx");
//        user.setPassword("yyy");
//        user.setBirthday(Date.valueOf("2000-01-01"));
//        System.out.println(userService.findAll());
//        userService.addUser(user);
//        InfoBean info=new InfoBean();
//        info.setJob("java高级工程师");
//        info.setMoney(10000);
//        info.setChangeDate(Date.valueOf("2020-3-04"));
//        userService.addInfo(2,info);
        System.out.println(userService.findUserInfoById(2));
    }
}
