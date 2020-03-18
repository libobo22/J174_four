package com;

import com.project.hibernate.entity.*;
import com.project.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestORM {
    Session session = null;
    Transaction tr = null;

    @Before
    public void before() {
        session = SessionUtil.createSession();
        tr = session.getTransaction();
        tr.begin();
    }

    @After
    public void after() {
        tr.commit();
        session.close();
    }

    @Test
    public void saveT() {
        TeacherEntity t = new TeacherEntity();
        t.setTeacherName("陈老师");
        t.setTeacherClass("J2EE");
        session.save(t);
    }

    @Test
    public void manyToOneSave() {
        //获得老师
        TeacherEntity t = session.get(TeacherEntity.class, "40288ae670ec1d860170ec1d88e10000");
        //添加三个学生
        for (int i = 0; i < 3; i++) {
            StudentEntity stu = new StudentEntity();
            stu.setStudentName("tom" + i);
            stu.setTeacher(t);
            session.save(stu);
        }
    }

    @Test
    public void findManyToOne() {
        StudentEntity stu = session.get(StudentEntity.class, "40288ae670ec23490170ec234d550000");
        System.out.println("----------------------------------------------------------");
        System.out.println(stu.getStudentName() + "的老师是：" + stu.getTeacher().getTeacherName() + "，教的科目：" + stu.getTeacher().getTeacherClass());
    }

    //级联添加（不推荐使用级联）
    @Test
    public void casAdd() {
        TeacherEntity t = new TeacherEntity();
        t.setTeacherName("张老师");
        t.setTeacherClass("servlet");
        //添加三个学生，并且添加学生所对应的老师
        for (int i = 0; i < 3; i++) {
            StudentEntity stu = new StudentEntity();
            stu.setStudentName("李四" + i);
            stu.setTeacher(t);
            session.save(stu);
        }
    }

    //级联删除（注意：查出来删除才能级联删除，不查出来删是不会级联删除的）
    @Test
    public void casDel() {
        StudentEntity stu = new StudentEntity();
        stu.setStudentId("40288ae670ec70c40170ec70c6af0003");
        session.delete(stu);
//        session.delete(session.get(StudentEntity.class, "40288ae670ec70c40170ec70c6af0003"));
    }

    @Test
    public void oneToManyFind() {
        TeacherEntity t = session.get(TeacherEntity.class, "40288ae670ec56b10170ec56b5b80000");
        System.out.println("-----------------------------------------");
        for (StudentEntity stu : t.getStuSet()) {
            System.out.println(stu.getStudentName());
        }
    }


    //添加角色
    @Test
    public void addRole() {
        for (int i = 0; i < 5; i++) {
            RoleEntity role = new RoleEntity();
            role.setRoleName("角色" + i);
            session.save(role);
        }
    }

    //添加用户
    @Test
    public void addUser() {
        for (int i = 0; i < 3; i++) {
            UserEntity user = new UserEntity();
            user.setUserName("用户" + i);
            user.setPassword("666");
            session.save(user);
        }
    }

    //添加用户角色
    @Test
    public void addUserRole() {
        //获得用户
        UserEntity user = session.get(UserEntity.class, "40288ae670ecd9d00170ecd9d35f0000");
        //获得角色
        RoleEntity role = session.get(RoleEntity.class, "40288ae670ecd5ee0170ecd5f6ab0002");
        //添加用户角色
        UserRoleEntity ur = new UserRoleEntity();
        ur.setUser(user);
        ur.setRole(role);
        session.save(ur);
    }

    //根据用户ID查询该用户拥有的角色(默认懒加载)
    @Test
    public void getUser() {
        UserEntity user = session.get(UserEntity.class, "40288ae670ecd9d00170ecd9d35f0000");
        System.out.println("----------------------------------------------");
        for (UserRoleEntity ur : user.getUrSet()) {
            System.out.println(ur.getRole().getRoleName());
        }
    }

    //级联添加用户角色
    @Test
    public void casAddUserRole() {
        UserEntity user = new UserEntity();
        user.setUserName("张三");
        user.setPassword("666");
        RoleEntity role = new RoleEntity();
        role.setRoleName("管理员");
        UserRoleEntity ur = new UserRoleEntity();
        ur.setUser(user);
        ur.setRole(role);
        session.save(ur);
    }

    //测试级联删除
    @Test
    public void casDelUser() {
        session.delete(session.get(UserEntity.class, "40288ae670ed0d200170ed0d24860002"));
    }

    //测试级联删除(注意：从表加了级联，删主表是不会级联删到从表记录的，只会在删除从表记录时级联删除到主表记录)
    @Test
    public void casDelUserRole() {
        session.delete(session.get(UserRoleEntity.class, "40288ae670ed0ea90170ed0ead4b0000"));
    }
}
