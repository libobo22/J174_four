package com.project.test;

import com.project.entity.many.MTeacherEntity;
import com.project.entity.many.TeacherDTO;
import com.project.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestHQL {
    private Session session= null;
    private Transaction tr=null;
    @Before
    public void before(){
        session= HibernateSessionFactory.getSession();
        tr=session.getTransaction();
        tr.begin();
    }
    @After
    public void after(){
        tr.commit();
        session.close();
    }
    @Test
    public void hqlTest(){
        String hql="select t from MTeacherEntity t";
        Query query=session.createQuery(hql);
        List<MTeacherEntity> list=query.list();
        for (MTeacherEntity teacher:
             list) {
            System.out.println(teacher.getTeacherName());
        }
    }
    @Test
    public void hqlTest2(){
        String hql="from MTeacherEntity";
        List<MTeacherEntity> list=session.createQuery(hql).list();
        for (MTeacherEntity teacher:
                list) {
            System.out.println(teacher.getTeacherName());
        }
    }
    @Test
    public void hqlTest3(){
        String hql="from MTeacherEntity where teacherName like ?";
        List<MTeacherEntity> list=session.createQuery(hql)
                .setParameter(0,"%李%").list();
        for (MTeacherEntity teacher:
                list) {
            System.out.println(teacher.getTeacherName());
        }
    }
    @Test
    public void hqlTest4(){
        String hql="select teacherId,teacherName from MTeacherEntity where teacherName like ?";
        List<Object[]> list=session.createQuery(hql)
                .setParameter(0,"%李%").list();
        for (Object obj[]:
                list) {

            System.out.println(obj[0].toString()+"  "+obj[1].toString());
        }
    }
    @Test
    public void hqlTest5(){
        String hql="select new com.project.entity.many.TeacherDTO(teacherId,teacherName) from MTeacherEntity where teacherName like ?";
        List<TeacherDTO> list=session.createQuery(hql)
                .setParameter(0,"%老师%").list();
        for (TeacherDTO teacher:
                list) {
            System.out.println(teacher.getTeacherId()+"  "+teacher.getTeacherName());
        }
    }
    @Test
    public void hqlTest6(){
        String hql="select new Map(teacherId,teacherName) from MTeacherEntity where teacherName like ?";
        List<Map> list=session.createQuery(hql)
                .setParameter(0,"%老师%").list();
        for (Map teacher:
                list) {
            System.out.println(teacher.get("0")+"  "+teacher.get("1"));
        }
    }
}
