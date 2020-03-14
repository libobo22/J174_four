package com;

import com.lovo.hibernate.entity.UserEntity;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.HashMap;

public class TestH {
    @Test
    public  void test2(){
        System.out.println(HSession.createSession());
    }

    @Test
    public void saveUser(){
        UserEntity user =new UserEntity();
        user.setUserId(1);
        user.setUserName("卡哇伊.莱昂纳德");
        user.setPassword("6666");
        user.setAge(28);
        //获得session
        Session s=HSession.createSession();
        //获得事务---增删改要用事务，因为要有结果显示出来
        Transaction tr =s.getTransaction();
        //开启事务
        tr.begin();
        //执行保存
        s.save(user);
        //提交事务
        tr.commit();
        //关闭session
        s.close();

    }
    @Test
    //查询不需要事务
    public void findUser(){
        //获得session
        Session s=HSession.createSession();
        //把查询的对象放到user对象里面去，所以把user对象的类型（UserEntity.class给他，才可以通过反射放进去
       UserEntity user= s.get(UserEntity.class,1);
        System.out.println(user.getUserName());
        s.close();
    }
    @Test
    public  void updateUser(){
        //获得session
        Session s=HSession.createSession();
        //获得事务---增删改要用事务，因为要有结果显示出来
        Transaction tr =s.getTransaction();
        //开启事务
        tr.begin();
        //修改前，先查询出来
        UserEntity user= s.get(UserEntity.class,1);
        user.setAge(30);
        //修改
        s.update(user);
        tr.commit();
        s.close();
    }

    @Test
    public void delUser(){
        //获得session
        Session s=HSession.createSession();
        //获得事务
        Transaction tr =s.getTransaction();
        //开启事务
        tr.begin();
        UserEntity user =new UserEntity();
        user.setUserId(1);
        s.delete(user);
        tr.commit();
        s.close();
    }
}
