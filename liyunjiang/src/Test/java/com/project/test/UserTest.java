package com.project.test;

import com.project.bean.UserBean;
import org.junit.Test;

public class UserTest {
    @Test
    public void test1(){
        UserBean user=new UserBean();
        user.setId(1);
        user.setUserName("zhangsan");
        user.setPassword("123456");
        System.out.println(user.getId()+" "+user.getUserName()+" "+user.getPassword());
    }
}
