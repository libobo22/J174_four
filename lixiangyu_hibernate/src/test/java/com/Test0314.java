package com;

import com.project0314.hibernate.entity.UserEntity;
import com.project0314.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class Test0314 {
    @Test
    public void test() {
        System.out.println(SessionUtil.createSession());
    }

    @Test
    public void addUser() {
        UserEntity user = new UserEntity();
        user.setUserId(1);
        user.setUserName("rookie");
        user.setPassword("666");
        user.setAge(18);
        //得到Session
        Session session = SessionUtil.createSession();
        //得到事务
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();
        //执行保存
        session.save(user);
        //提交事务
        transaction.commit();
        //关闭Session
        session.close();
    }

    @Test
    public void getUser() {
        //得到Session
        Session session = SessionUtil.createSession();
        UserEntity user = session.get(UserEntity.class, 1);
        session.close();
        System.out.println(user.getUserName() + "  " + user.getPassword());
    }


    @Test
    public void updateUser() {
        //得到Session
        Session session = SessionUtil.createSession();
        //得到事务
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();
        //先查出来
        UserEntity user = session.get(UserEntity.class, 1);
        user.setAge(23);
        //执行修改
        session.update(user);
        transaction.commit();
        session.close();
    }


    @Test
    public void delUser() {
        //得到Session
        Session session = SessionUtil.createSession();
        //得到事务
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();
        UserEntity user = new UserEntity();
        user.setUserId(1);
        //执行删除
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
