package com.project.test;

import com.project.dao.BasicDao;
import com.project.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PrintEntityManager {
    @Autowired
    private BasicDao basicDao;
    @Test
    public void test1(){
        System.out.println(basicDao.getEntityManager());
    }
    @Test
    public void findUserList(){
        List<UserEntity> list=basicDao.findUserList();
        System.out.println(list.size());
    }
    @Test
    public void findUser(){
        System.out.println(basicDao.findUser().getUserName());
    }
    @Test
    public void findUser2(){
        System.out.println(basicDao.findUser2().getUserName());
    }
    @Test
    public void findUserSQL(){
        UserEntity user=basicDao.findUserSQL();
        System.out.println(user.getUserName());
    }
    @Test
    public void findUserListSQL(){
        List<UserEntity> list=basicDao.findUserListSQL();
        for (UserEntity user:
             list) {
            System.out.println(user.getUserName());
        }
    }
    @Test
    public void findUserMapSQL(){
        List<Map> list=basicDao.findUserMapSQL();
        for (Map map:
                list) {
            System.out.println(map.get("f_loginName"));
        }
    }

}
