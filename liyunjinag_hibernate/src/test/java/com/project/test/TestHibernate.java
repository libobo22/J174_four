package com.project.test;

import com.project.entity.UserEntity;
import com.project.utils.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestHibernate {
    @Test
    public void add(){
        Session session=HibernateSessionFactory.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();

        UserEntity user=new UserEntity(0,"xyz","123");
        session.save(user);

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
        user.setUserId(3);
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
            System.out.println(user.getUserName()+"  "+user.getPassword());
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
            System.out.println(user.getUserName()+"  "+user.getPassword());
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
            System.out.println(user.getUserName()+"  "+user.getPassword());
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
            System.out.println(user.getUserName()+"  "+user.getPassword());
        }
        session.close();
    }
}
