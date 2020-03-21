//package com;
//
//import com.lovo.hibernate.entity.RoleEntity;
//import com.lovo.hibernate.entity.UserEntity;
//import com.lovo.hibernate.util.HSession;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.junit.Test;
//
//import java.io.StringWriter;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//
//public class TestH {
//    @Test
//    public  void test2(){
//        System.out.println(HSession.createSession());
//    }
//
//    @Test
//    public void saveUser(){
//        UserEntity user =new UserEntity();
//
//        user.setUserName("乔治");
//        user.setPassword("8888");
//        user.setAge(30);
//        String str="1关系数据库：关系型数据库源于关系模型。关系模型认为，世界由实体和实体之间的联系组成。关系型数据库是一种以表做为实体，以主键和外键关系做联系的一种数据库结构。\n" +
//                "2主键：在关系型数据库表中。用唯一的标识符来标识每一行，这个标识符就是主键\n" +
//                "主建两个特点：不可以重复，不能为空\n" +
//                "外键：在关系型数据库中，外键（forergn Key）是用来表达表和表之间关联关系的列\n" +
//                "外键加在从表之中。\n" +
//                "3一对一：一条主表记录对应一条从表记录，同时一条从表记录对应一条主表记录\n" +
//                "对象模型：在一个实体中拥有另一个实体类，同时在另一个实体类中拥有该实体类的对象：\n" +
//                "class ManBean{                          class CodeBean{                                    \n" +
//                "Private CodeBean code;                           private ManBean man;\n" +
//                "}                                                                 }\n";
//        user.setInfo(str);
//        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd hh:mm");
//       String date=sd.format(new Date());
//       user.setAddDate(date);
//        //获得session
//        Session s=HSession.createSession();
//        //获得事务---增删改要用事务，因为要有结果显示出来
//        Transaction tr =s.getTransaction();
//        //开启事务
//        tr.begin();
//        //执行保存
//        s.save(user);
//        //提交事务
//        tr.commit();
//        //关闭session
//        s.close();
//
//    }
//    @Test
//    //查询不需要事务
//    public void findUser(){
//        //获得session
//        Session s=HSession.createSession();
//        //把查询的对象放到user对象里面去，所以把user对象的类型（UserEntity.class给他，才可以通过反射放进去
//       UserEntity user= s.get(UserEntity.class,1);
//        System.out.println(user.getUserName());
//        s.close();
//    }
//    @Test
//    public  void updateUser(){
//        //获得session
//        Session s=HSession.createSession();
//        //获得事务---增删改要用事务，因为要有结果显示出来
//        Transaction tr =s.getTransaction();
//        //开启事务
//        tr.begin();
//        //修改前，先查询出来
//        UserEntity user= s.get(UserEntity.class,1);
//        user.setAge(30);
//        //修改
//        s.update(user);
//        tr.commit();
//        s.close();
//    }
//
//    @Test
//    public void delUser(){
//        //获得session
//        Session s=HSession.createSession();
//        //获得事务
//        Transaction tr =s.getTransaction();
//        //开启事务
//        tr.begin();
//        UserEntity user =new UserEntity();
//        user.setUserId(1);
//        s.delete(user);
//        tr.commit();
//        s.close();
//    }
//
//    @Test
//    public void saveRole(){
//        //获得session
//        Session s=HSession.createSession();
//        //获得事务---增删改要用事务，因为要有结果显示出来
//        Transaction tr =s.getTransaction();
//        for(int i=0;i<10;i++) {
//            tr.begin();
//            RoleEntity r = new RoleEntity();
//            r.setRoleName("管理员"+i);
//            s.save(r);
//            tr.commit();
//        }
//        s.close();
//    }
//}
