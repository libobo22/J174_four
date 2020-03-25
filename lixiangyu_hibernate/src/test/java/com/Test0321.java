package com;

import com.project.hibernate.entity.work.PowerBean;
import com.project.hibernate.entity.work.RoleBean;
import com.project.hibernate.entity.work.UserBean;
import com.project.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class Test0321 {
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

    //添加用户角色权限
    @Test
    public void save() {
        for (int i = 1; i < 4; i++) {
            UserBean user = new UserBean();
            user.setUserName("张三" + i);
            user.setLoginName("aaa" + i);
            user.setPassword("666");
            session.save(user);
            for (int j = 1; j < 4; j++) {
                RoleBean role = new RoleBean();
                role.setRoleName("角色" + i + j);
                role.setRoleInfo("角色描述" + i + j);
                role.setUser(user);
                session.save(role);
                for (int k = 1; k < 4; k++) {
                    PowerBean power = new PowerBean();
                    power.setPowerName("权限" + i + j + k);
                    power.setPowerResource("url" + i + j + k);
                    power.setRole(role);
                    session.save(power);
                }
            }
        }
    }

    //根据用户登录名查询出，该用户的所有权限（用户名、权限名、权限资源）
    @Test
    public void find() {
        String logingName = "aaa1";
        String sql = "SELECT u.u_userName,p.p_name,p.p_resource FROM sys_role r JOIN sys_user u ON u.u_id=r.fk_u_id " +
                "JOIN sys_power p ON p.fk_r_id=r.r_id WHERE u.u_loginName=? and p.p_status='enabled'";
        List<Map> list = session.createNativeQuery(sql)
                .setParameter(1, logingName)
                .unwrap(NativeQueryImpl.class)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
                .list();
        for (Map map : list) {
            System.out.println(map.get("u_userName") + "/" + map.get("p_name") + "/" + map.get("p_resource"));
        }
    }

    //根据登录名,冻结该用户的某个角色或某个权限，然后再执行上面的查询
    @Test
    public void updateAndFind() {
        String hql = "update PowerBean set powerStatus=? where powerName=?";
        int count = session.createQuery(hql)
                .setParameter(0, "disabled")
                .setParameter(1, "权限111")
                .executeUpdate();
        System.out.println(count);
        this.find();
    }


}
