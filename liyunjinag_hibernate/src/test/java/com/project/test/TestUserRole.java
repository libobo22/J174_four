package com.project.test;

import com.project.entity.roleManage.*;
import com.project.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestUserRole {
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
    public void addData(){
        XUserEntity user1=new XUserEntity("用户1","abc","123123","1");
        XUserEntity user2=new XUserEntity("用户2","xyz","123123","1");
        XUserEntity user3=new XUserEntity("用户3","superAdmin","123123","1");
        XRoleEntity role1=new XRoleEntity("管理员1","管理库存人员");
        XRoleEntity role2=new XRoleEntity("管理员2","管理资料人员");
        XRoleEntity role3=new XRoleEntity("管理员3","超级管理员");
        XPermissionEntity per1=new XPermissionEntity("入库权限","/repertory/add/**");
        XPermissionEntity per2=new XPermissionEntity("出库权限","/repertory/out/**");
        XPermissionEntity per3=new XPermissionEntity("查看库存权限","/repertory/find/**");
        XPermissionEntity per4=new XPermissionEntity("资料添加权限","/data/add/**");
        XPermissionEntity per5=new XPermissionEntity("资料删除权限","/data/del/**");
        XPermissionEntity per6=new XPermissionEntity("资料查询权限","/data/find/**");
        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.save(role1);
        session.save(role2);
        session.save(role3);
        session.save(per1);
        session.save(per2);
        session.save(per3);
        session.save(per4);
        session.save(per5);
        session.save(per6);

        XUserRoleEntity userRole1=new XUserRoleEntity(user1,role1,"1");
        XUserRoleEntity userRole2=new XUserRoleEntity(user1,role2,"1");
        XUserRoleEntity userRole3=new XUserRoleEntity(user2,role2,"1");
        XUserRoleEntity userRole4=new XUserRoleEntity(user3,role3,"1");
        session.save(userRole1);
        session.save(userRole2);
        session.save(userRole3);
        session.save(userRole4);
        XRolePermissionEntity rolePer1=new XRolePermissionEntity(role1,per1,"1");
        XRolePermissionEntity rolePer2=new XRolePermissionEntity(role1,per2,"1");
        XRolePermissionEntity rolePer3=new XRolePermissionEntity(role1,per3,"1");
        XRolePermissionEntity rolePer4=new XRolePermissionEntity(role2,per4,"1");
        XRolePermissionEntity rolePer5=new XRolePermissionEntity(role2,per5,"1");
        XRolePermissionEntity rolePer6=new XRolePermissionEntity(role2,per6,"1");
        XRolePermissionEntity rolePer7=new XRolePermissionEntity(role3,per1,"1");
        XRolePermissionEntity rolePer8=new XRolePermissionEntity(role3,per2,"1");
        XRolePermissionEntity rolePer9=new XRolePermissionEntity(role3,per3,"1");
        XRolePermissionEntity rolePer10=new XRolePermissionEntity(role3,per4,"1");
        XRolePermissionEntity rolePer11=new XRolePermissionEntity(role3,per5,"1");
        XRolePermissionEntity rolePer12=new XRolePermissionEntity(role3,per6,"1");
        session.save(rolePer1);
        session.save(rolePer2);
        session.save(rolePer3);
        session.save(rolePer4);
        session.save(rolePer5);
        session.save(rolePer6);
        session.save(rolePer7);
        session.save(rolePer8);
        session.save(rolePer9);
        session.save(rolePer10);
        session.save(rolePer11);
        session.save(rolePer12);
    }

    /**
     * 根据登录用户名查询用户所拥有的权限
     */
    @Test
    public void findUserPermission(){
        String sql="SELECT DISTINCT a.f_userName userName,e.f_perName perName,e.f_perUrl perUrl " +
                "from x_user a,x_user_role b,x_role c,x_role_permission d,x_permission e " +
                "where a.pk_userId=b.fk_userId and b.fk_roleId=c.pk_roleId " +
                "and c.pk_roleId=d.fk_roleId and d.fk_perId=e.pk_perId " +
                "and a.f_loginName=? and b.f_roleStatus='1' and d.f_perStatus='1'";
        List<Map> list=session.createNativeQuery(sql)
                .setParameter(1,"abc")
                .unwrap(NativeQueryImpl.class)//拆包
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
                .list();
        for (Map map:
             list) {
            System.out.println("用户名："+map.get("userName")+"  权限名："+map.get("perName")+"  权限资源："+map.get("perUrl"));
        }
    }

    /**
     * 冻结某个用户的某个角色
     */
    @Test
    public void updateRoleStatus(){
        String hql="update XUserRoleEntity set roleStatus=? where role=? and user=?";
        XUserEntity user=new XUserEntity();
        user.setUserId(1);
        XRoleEntity role=new XRoleEntity();
        role.setRoleId(1);
        int count=session.createQuery(hql).setParameter(0,"0")
        .setParameter(1,role)
        .setParameter(2,user).executeUpdate();
        System.out.println(count);
        findUserPermission();
    }

//    /**
//     * 根据某个用户冻结某个权限
//     */
//    @Test
//    public void updatePermissionStatus(){
//        String hql="from XUserEntity where userId=?";
//
//        int count=session.createQuery(hql).setParameter(0,"0")
//                .setParameter(1,role)
//                .setParameter(2,user).executeUpdate();
//        System.out.println(count);
//        findUserPermission();
//    }




}
