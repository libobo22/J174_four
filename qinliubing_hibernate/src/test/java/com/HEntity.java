package com;

import com.lovo.hibernate.entity.RoleEntity;
import com.lovo.hibernate.entity.UserEntity;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

public class HEntity {
    Session session=null;
    @Before
    public void Before(){
        session= HSession.createSession();
    }
    public void saveRole(){
        //瞬时状态
        RoleEntity r= new RoleEntity();
        r.setRoleName("教师");
        //操作数据库
       Transaction tr= session.getTransaction();
       //持久状态
       tr.begin();
             session.save(r);
             //操作持久状态
             r.setRoleName("学生");
        //持久状态
        tr.commit();
        session.close();
        //游离状态

    }
    @Test
    public void testRole(){
        //持久状态
        RoleEntity roleEntity=  session.get(RoleEntity.class,"402881e570e15ce40170e15ce71f0009");
      //改变持久状态
        roleEntity.setRoleName("教师");
        session.close();
    }

}
