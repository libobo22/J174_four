package com;

import com.project.hibernate.util.SessionUtil;
import org.junit.Test;

public class Test0314 {
    @Test
    public void test() {
        System.out.println(SessionUtil.createSession());
    }

//    @Test
//    public void addUser() {
//        UserEntity user = new UserEntity();
//        user.setUserName("rookie");
//        user.setPassword("666");
//        user.setAge(18);
//        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                "bbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccc" +
//                "cccccccccccdddddddddddddddddddddddddddddddddddddde";
//        user.setInfo(str);
//        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//        String now = sdf.format(new Date());
//        user.setAddDate(now);
//
//        //得到Session
//        Session session = SessionUtil.createSession();
//        //得到事务
//        Transaction transaction = session.getTransaction();
//        //开启事务
//        transaction.begin();
//        //执行保存
//        session.save(user);
//        //提交事务
//        transaction.commit();
//        //关闭Session
//        session.close();
//    }
//
//    @Test
//    public void getUser() {
//        //得到Session
//        Session session = SessionUtil.createSession();
//        UserEntity user = session.get(UserEntity.class, 1);
//        session.close();
//        System.out.println(user.getUserName() + "  " + user.getPassword());
//    }
//
//
//    @Test
//    public void updateUser() {
//        Session session = SessionUtil.createSession();
//        Transaction transaction = session.getTransaction();
//        transaction.begin();
//        UserEntity user = session.get(UserEntity.class, 1);
//        user.setAge(28);
//        //持久化对象的id不能修改，否则报错
//        //user.setUserId(2);
//        //执行修改(多余的，因为在提交事务时hibernate会自动将持久化状态的实体同步到数据库中)
////        session.update(user);
//        transaction.commit();
//        session.close();
//    }
//
//
//    @Test
//    public void delUser() {
//        //得到Session
//        Session session = SessionUtil.createSession();
//        //得到事务
//        Transaction transaction = session.getTransaction();
//        //开启事务
//        transaction.begin();
//        UserEntity user = new UserEntity();
//        user.setUserId(1);
//        //执行删除
//        session.delete(user);
//        transaction.commit();
//        session.close();
//    }
//
//    @Test
//    public void saveRole() {
//        Session s = SessionUtil.createSession();
//        Transaction tr = s.getTransaction();
//        //瞬时状态
//        RoleEntity r = new RoleEntity();
//        r.setRoleName("瞬时");
//        tr.begin();
//        //持久状态
//        s.save(r);
//        //操作持久状态
//        r.setRoleName("持久");
//        tr.commit();
//        //游离状态
//        s.close();
//    }
//
//    @Test
//    public void testRole() {
//        Session s = SessionUtil.createSession();
//        Transaction tr = s.getTransaction();
//        tr.begin();
//        //持久状态
//        RoleEntity r = s.get(RoleEntity.class, "40288ae670e6599b0170e659a39b0000");
//        //操作持久状态对象(此时不会立即同步到数据库，会先放到一级缓存，当我们提交事务的时候，hibernate会把缓存与数据库同步)
//        r.setRoleName("嗯嗯");
//        r.setRoleName("哦");
//        tr.commit();
//        s.close();
//    }
//
//    //证明一级缓存的存在
//    @Test
//    public void testOne() {
//        Session s = SessionUtil.createSession();
//        UserEntity u1 = s.get(UserEntity.class, 1);
//        UserEntity u2 = s.get(UserEntity.class, 1);
//        UserEntity u3 = s.get(UserEntity.class, 1);
//        System.out.println(u1 == u2);   //true，说明第一次s.get是发送select语句从数据库取出记录封装成对象，
//        // 将对象放入session缓存中，后面两次只是从缓存中取出对象
//        System.out.println(u1 == u3);//true
//        System.out.println(u2 == u3);//true
//        s.close();
//    }
//
//    //急加载
//    @Test
//    public void get() {
//        Session s = SessionUtil.createSession();
//        RoleEntity r = s.get(RoleEntity.class, "40288ae670e6599b0170e659a39b0000");
//        System.out.println("session关闭之前：  " + r.getRoleName());
//        s.close();
//        System.out.println("session关闭之后：  " + r.getRoleName());
//    }
//
//    //急加载
//    @Test
//    public void get1() {
//        Session s = SessionUtil.createSession();
//        RoleEntity r = s.get(RoleEntity.class, "40288ae670e6599b0170e659a39b0000");
//        System.out.println("-----------------------");
//        System.out.println(r.getRoleName());
//        s.close();
//    }
//
//    //懒加载
//    @Test
//    public void load1() {
//        Session s = SessionUtil.createSession();
//        RoleEntity r = s.load(RoleEntity.class, "40288ae670e6599b0170e659a39b0000");
//        System.out.println("-----------------------");
//        System.out.println(r.getRoleName());
//        s.close();
//    }
//
//    //懒加载
//    @Test
//    public void load() {
//        Session s = SessionUtil.createSession();
//        RoleEntity r = s.load(RoleEntity.class, "40288ae670e6599b0170e659a39b0000");
//        System.out.println("session关闭之前：  " + r.getRoleName());
//        s.close();
//        System.out.println("session关闭之后：  " + r.getRoleName());
//    }


}
