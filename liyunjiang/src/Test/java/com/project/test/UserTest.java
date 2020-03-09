package com.project.test;

import com.project0307.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserTest {
    @Resource(name = "userService")
    private IUserService userService;
    @Test
    public void test1(){
//        UserEntity user=new UserEntity();
//        user.setId(1);
//        user.setUserName("zhangsan");
//        user.setPassword("123456");
//        user.setBirthday(Date.valueOf("2012-03-05"));
//        List<UserEntity> list=userService.findAll();
//        for (UserEntity user:
//             list) {
//            System.out.println(user.getId()+" "+user.getUserName()+" "+user.getPassword());
//        }
//        userService.addUser(user);
//        userService.delUserById(18);
//        userService.updatePasswordById(1,"123456");
        System.out.println(userService.findByUserName("abc"));
    }
}
