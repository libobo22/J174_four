package com.project.test;

import com.project.entity.*;
import com.project.entity.many.MStudentEntity;
import com.project.entity.many.MTeacherEntity;
import com.project.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TestORM {
    @Test
    public void manyToOneSave(){
        TeacherEntity teacher=new TeacherEntity();
        teacher.setTeacherName("李老师");
        teacher.setTeacherClass("J2EE");
        Session session= HibernateSessionFactory.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();
        session.save(teacher);
        for(int i=0;i<3;i++){
            StudentEntity s=new StudentEntity();
            s.setStudentName("学生"+(i+1));
            s.setTeacher(teacher);
            session.save(s);
        }
        tr.commit();
        session.close();
        System.out.println(teacher.getTeacherId());
    }

    @Test
    public void findManyToOne(){
        Session session= HibernateSessionFactory.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();
        StudentEntity student=session.get(StudentEntity.class,"402881d670eb91420170eb91453a0001");
        System.out.println(student.getStudentName()+"对应的老师："+student.getTeacher().getTeacherName());
        tr.commit();
        session.close();

    }
    @Test
    public void caseSave(){
        TeacherEntity teacher=new TeacherEntity();
        teacher.setTeacherName("洪老师");
        teacher.setTeacherClass("servlet");
        Session session= HibernateSessionFactory.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();
        for(int i=0;i<3;i++){
            StudentEntity s=new StudentEntity();
            s.setStudentName("赵云"+(i+1));
            s.setTeacher(teacher);
            session.save(s);
        }
        tr.commit();
        session.close();
    }
    @Test
    public void caseDel(){
        Session session= HibernateSessionFactory.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();
        StudentEntity student=new StudentEntity();
        student.setStudentId("402881d670ec85b20170ec85b8450003");
        session.delete(student);
        tr.commit();
        session.close();
    }
    @Test
    public void findOneToMany(){
        Session session= HibernateSessionFactory.getSession();
        TeacherEntity teacher=session.get(TeacherEntity.class,"402881d670ec85b20170ec85b83b0001");
        System.out.println(teacher.getTeacherName());
        for (StudentEntity stu:
             teacher.getStudentSet()) {
            System.out.println(stu.getStudentName());
        }
    }
    @Test
    public void manyToMany(){
        Session session= HibernateSessionFactory.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();
        for(int i=0;i<2;i++){
            UserEntity user=new UserEntity();
            user.setUserName("用户"+(i+1));
            session.save(user);
            RoleEntity role=new RoleEntity();
            role.setRoleName("管理员"+(i+1));
            session.save(role);

            UserRoleEntity userRole=new UserRoleEntity();
            userRole.setUser(user);
            userRole.setRole(role);
            session.save(userRole);
        }
        tr.commit();
        session.close();
    }
    @Test
    public void addUserRole(){
        Session session= HibernateSessionFactory.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();
        UserEntity user=session.get(UserEntity.class,"402881d670ece2c60170ece2c99a0000");
        RoleEntity role=session.get(RoleEntity.class,"402881d670ece2c60170ece2c9a90001");
        UserRoleEntity userRole=new UserRoleEntity();
        userRole.setUser(user);
        userRole.setRole(role);
        session.save(userRole);
        tr.commit();
        session.close();
    }

    @Test
    public void findManyToMany(){
        Session session= HibernateSessionFactory.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();
        UserEntity user=session.get(UserEntity.class,"402881d670ece2c60170ece2c99a0000");

        tr.commit();
        session.close();
        System.out.println(user.getUserName());
        for (UserRoleEntity userRole:
             user.getUserRoleSet()) {
            System.out.println(userRole.getRole().getRoleName());
        }
    }
    @Test
    public void delUser(){
        Session session= HibernateSessionFactory.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();
        UserRoleEntity userRoleEntity=session.get(UserRoleEntity.class,"402881d670ed281a0170ed281f230005");
        System.out.println(userRoleEntity.getUser().getUserName());
        System.out.println(userRoleEntity.getRole().getRoleName());
        session.delete(userRoleEntity);

        tr.commit();
        session.close();
    }

    @Test
    public void test(){
        System.out.println(HibernateSessionFactory.getSession());
    }
    @Test
    public void manyToManyAdd(){
        Session session= HibernateSessionFactory.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();
        MStudentEntity stu=new MStudentEntity();
        stu.setStudentName("张三");

        MTeacherEntity teacher=new MTeacherEntity();
        teacher.setTeacherName("李老师");
        MTeacherEntity teacher2=new MTeacherEntity();
        teacher2.setTeacherName("黄老师");

        HashSet set=new HashSet();
        set.add(teacher);
        set.add(teacher2);
        stu.setTeacherSet(set);
        session.save(stu);

        session.save(teacher);
        session.save(teacher2);


        tr.commit();
        session.close();
    }
    @Test
    public void getManyToMany(){
        Session session= HibernateSessionFactory.getSession();
        MStudentEntity stu=session.get(MStudentEntity.class,"402881d670f0cf7a0170f0cf7ee40000");
        System.out.println("aaa");
    }

}
