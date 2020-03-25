package com.project.test;

import com.project.dao.BasicDao;
import com.project.entity.UserEntity;
import com.project.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringHibernate {
    @Resource(name = "basicDao")
    BasicDao basicDao;
    @Autowired
    private IUserService userService;
    @Test
    public  void test1(){
//        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//        BasicDao basicDao= (BasicDao) context.getBean("basicDao");
        System.out.println(basicDao.getSession());
    }
    @Test
    public void test2(){
        UserEntity user=new UserEntity("张三丰","abcd","123123","1");
        userService.addUser(user);
    }
    @Test
    public void delUserById(){
        userService.delUserById(3);
    }
    @Test
    public void findAll(){
        List<UserEntity> list=userService.findAll();
        for (UserEntity user:
             list) {
            System.out.println(user.getUserName());
        }
    }
    @Test
    public void findByMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("userId",1);
        map.put("userName","abc");
        List<UserEntity> list=userService.findByMap(map);
        for (UserEntity user:
             list) {
            System.out.println(user.getLoginName());
        }
    }
    @Test
    public void findByArr(){
        List<UserEntity> list=userService.findByIdArr(new Object[]{"1"});
        System.out.println(list.size());
    }
    @Test
    public void findByObjects(){
        List<UserEntity> list=userService.findByStrings("1");
        System.out.println(list.size());
    }
    @Test
    public void test(){
        userService.test();
    }
}
