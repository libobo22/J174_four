package com.project.test;

import com.project.entity.RoleEntity;
import com.project.entity.UserEntity;
import com.project.utils.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestHibernate {
    @Test
    public void add(){
        Session session=HibernateSessionFactory.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();

        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String d=dateFormat.format(new Date());
//        session.save(user);

        tr.commit();
        session.close();
    }
    @Test
    public void update(){
        Session session=HibernateSessionFactory.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();
        Query q=session.createQuery("update UserEntity set userName=:userName where userId=:userId");
        q.setParameter("userName","abc");
        q.setParameter("userId",2);
        q.executeUpdate();
        tr.commit();
        session.close();
    }
    @Test
    public void del(){
        Session session=HibernateSessionFactory.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();
        UserEntity user=new UserEntity();
        user.setUserId("");
        session.delete(user);
        tr.commit();
        session.close();
    }

    @Test
    public void select1(){
        Session session=HibernateSessionFactory.getSession();
        Query q = session.createQuery("from UserEntity");
        List<UserEntity> list=q.list();
        for (UserEntity user:
             list) {
            System.out.println(user.getUserName());
        }
        session.close();
    }
    @Test
    public void select2(){
        Session session=HibernateSessionFactory.getSession();
        Query q = session.createQuery("from UserEntity where userName=? and password=?");
        q.setParameter(0,"abc");
        q.setParameter(1,"123");
        List<UserEntity> list=q.list();
        for (UserEntity user:
                list) {
            System.out.println(user.getUserName());
        }
        session.close();
    }
    @Test
    public void select3(){
        Session session=HibernateSessionFactory.getSession();
        Query q = session.createQuery("from UserEntity where userName=:userName and password=:password");
        q.setParameter("userName","abc");
        q.setParameter("password","123");
        List<UserEntity> list=q.list();
        for (UserEntity user:
                list) {
            System.out.println(user.getUserName());
        }
        session.close();
    }
    @Test
    public void select4(){
        Session session=HibernateSessionFactory.getSession();
        Query q = session.createQuery("from UserEntity where userName=:userName or password=:password");
//        UserEntity userEntity=new UserEntity(0,"abc","123");
//        q.setProperties(userEntity);
        Map map=new HashMap();
        map.put("userName","xyz");
        map.put("password","123");
        q.setProperties(map);
        List<UserEntity> list=q.list();
        for (UserEntity user:
                list) {
            System.out.println(user.getUserName());
        }
        session.close();
    }
    @Test
    public void select5(){
        Session session=HibernateSessionFactory.getSession();
        Criteria criteria=session.createCriteria(UserEntity.class);
        criteria.add(Restrictions.eq("userName","abc"));
        List<UserEntity> list=criteria.list();
        for (UserEntity user:
                list) {
            System.out.println(user.getUserName());
        }
        session.close();
    }
    @Test
    public void addRole(){
        Session session=HibernateSessionFactory.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();

        for (int i=0;i<5;i++){
            RoleEntity role=new RoleEntity();
            role.setRoleName("管理员"+i);
            session.save(role);
        }
        RoleEntity role=new RoleEntity();
        session.save(role);
        tr.commit();
        session.close();
    }
    @Test
    public void findUser() throws Throwable {
        Session session=HibernateSessionFactory.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();
        // 查询id=2的user对象,如果查询到，会将user存储到一级缓存中。
        UserEntity user=session.get(UserEntity.class,2);
        // 会从一级缓存中查询，而不会向数据库在发送sql
        UserEntity user2=session.get(UserEntity.class,2);
        tr.commit();
        session.close();

    }

    public void addUser(){
        Session session=HibernateSessionFactory.getSession();
        //瞬时状态
        UserEntity user=new UserEntity();
        user.setUserName("libobo");


        //操作数据库
        Transaction tr=session.getTransaction();
        tr.begin();
        //=========持久状态============
        session.save(user);
        //=========操作持久状态============
        //=========持久状态============
        tr.commit();
        session.close();
        //=========游离状态============

    }

    /**
     * 急加载
     */
    @Test
    public void get(){
        Session session=HibernateSessionFactory.getSession();
        UserEntity user=session.get(UserEntity.class,1);
//        System.out.println("session关闭之前："+user.getUserName());
        session.close();
        System.out.println("session关闭之后："+user.getUserName());
    }
    /**
     * 懒加载
     */
    @Test
    public void load(){
        Session session=HibernateSessionFactory.getSession();
        UserEntity user=session.load(UserEntity.class,1);
//        System.out.println("session关闭之前："+user.getUserName());
        session.close();
        System.out.println("session关闭之后："+user.getUserName());
    }

}
