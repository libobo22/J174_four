package com;

import com.lovo.hibernate.entity.*;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ORMT {
    Session session=null;
    Transaction tr=null;
    @Before
    public void Before(){
        session= HSession.createSession();
        tr=session.getTransaction();
        tr.begin();
    }

    @Test
    public void saveT(){
        TeacherEntity t= new TeacherEntity();
        t.setTeacherName("秦老师");
        t.setTeacherClass("篮球班");
        session.save(t);
    }
    @Test
    public void manyToOneSave(){
   //获得教师
        TeacherEntity t=
        session.get(TeacherEntity.class,"402881e570ebea730170ebea76e40000");
           //保存三个学生
        StudentEntity s1=new StudentEntity();
        s1.setStudentName("詹姆斯");
        s1.setTeacher(t);
        StudentEntity s2=new StudentEntity();
        s2.setStudentName("卡哇伊");
        s2.setTeacher(t);
        StudentEntity s3=new StudentEntity();
        s3.setStudentName("乔治");
        s3.setTeacher(t);
        session.save(s1);
        session.save(s2);
        session.save(s3);

    }

    @Test
    public void findManyToOne(){
        StudentEntity stu=
                session.get(StudentEntity.class,"402881e570ebf2d20170ebf2d5930000");
        System.out.println(
                stu.getStudentName()
                        +"对应的老师：" +stu.getTeacher().getTeacherName()
                        + ".所教的科目:" +stu.getTeacher().getTeacherClass());
    }

    //添加角色
    @Test
    public void addRole() {
        for (int i = 0; i < 10; i++) {
            RoleEntity role = new RoleEntity();
            role.setRoleName("角色" + i);
            session.save(role);
        }
    }

    //添加用户
    @Test
    public void addUser() {
        for (int i = 0; i < 5; i++) {
            UserEntity user = new UserEntity();
            user.setUserName("用户" + i);
            user.setPassword("12345");
            session.save(user);
        }
    }

    //添加用户角色
    @Test
    public void addUserRole() {
        //获得用户
        UserEntity user = session.get(UserEntity.class, "402881e570ed95620170ed9567ca0001");
        //获得角色
        RoleEntity role = session.get(RoleEntity.class, "402881e570ed941b0170ed94272b0001");
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



    @After
    public void after(){
        tr.commit();
        session.close();
    }
}
