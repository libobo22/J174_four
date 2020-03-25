package com;

import com.project.hibernate.dto.TeacherDto;
import com.project.hibernate.entity.StudentEntity;
import com.project.hibernate.entity.TeacherEntity;
import com.project.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestSQL {
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
    public void sql() {
        String sql = "select * from sys_teacher";
        NativeQuery query = session.createNativeQuery(sql);
        //把查询出来的数据放入实体中，该实体需要被hibernate管理
        query.addEntity(TeacherEntity.class);
        List<TeacherEntity> list = query.list();
        for (TeacherEntity t : list) {
            System.out.println(t.getTeacherName());
        }
    }

    @Test
    public void sql1() {
        String sql = "SELECT t.*,s.* FROM sys_teacher t left JOIN sys_student s on t.t_id=s.f_t_id WHERE t_name=?";
        List<Object[]> list = session.createNativeQuery(sql)
                .addEntity("t", TeacherEntity.class)
                .addEntity("s", StudentEntity.class)
                .setParameter(1, "陈老师")
                .list();
        for (Object[] objs : list) {
            TeacherEntity t = (TeacherEntity) objs[0];
            StudentEntity s = (StudentEntity) objs[1];
            System.out.println(t.getTeacherName() + "/" + s.getStudentName());
        }
    }

    @Test
    public void sql2() {
        String sql = "select t_name,t_class from sys_teacher";
        List<Object[]> list = session.createNativeQuery(sql).list();
        for (Object[] objs : list) {
            System.out.println(objs[0].toString() + "/" + objs[1].toString());
        }
    }

    //map
    @Test
    public void sql3() {
        String sql = "select t_name,t_class from sys_teacher where t_class=?";
        List<Map> list = session.createNativeQuery(sql).setParameter(1, "Java")
                .unwrap(NativeQueryImpl.class)//拆包
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)//设置结果转换器
                .list();
        for (Map map : list) {
            System.out.println(map.get("t_name") + "/" + map.get("t_class"));
        }
    }

    //dto
    @Test
    public void sql4() {
        String sql = "select t_name userName,t_class userClass from sys_teacher where t_class=?";
        List<TeacherDto> list = session.createNativeQuery(sql).setParameter(1, "Java")
                .unwrap(NativeQueryImpl.class)//拆包
                .setResultTransformer(Transformers.aliasToBean(TeacherDto.class))//设置结果转换器
                .list();
        for (TeacherDto dto : list) {
            System.out.println(dto.getUserName() + "/" + dto.getUserClass());
        }
    }

    //关联查询
    @Test
    public void sql5() {
        String sql = "SELECT t.t_name,t.t_class,s.s_name FROM sys_teacher t left JOIN sys_student s on t.t_id=s.f_t_id WHERE t_name=?";
        List<Map> list = session.createNativeQuery(sql).setParameter(1, "陈老师")
                .unwrap(NativeQueryImpl.class)//拆包
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)//设置结果转换器
                .list();
        for (Map map : list) {
            System.out.println(map.get("t_name") + "/" + map.get("t_class") + "/" + map.get("s_name"));
        }
    }


    //分页查询
    @Test
    public void sql6() {
        String sql = "SELECT * FROM sys_teacher";
        List<TeacherEntity> list = session.createNativeQuery(sql)
                .addEntity(TeacherEntity.class)
                .setFirstResult(0)
                .setMaxResults(10)
                .list();
        for (TeacherEntity t : list) {
            System.out.println(t.getTeacherName());
        }
    }

    @Test
    public void sql7() {
        String sql = "SELECT * FROM sys_teacher where t_name=?";
        TeacherEntity t = (TeacherEntity) session.createNativeQuery(sql)
                .addEntity(TeacherEntity.class)
                .setParameter(1, "陈老师")
                .uniqueResult();
        System.out.println(t.getTeacherName() + "/" + t.getTeacherClass());
    }

    //删除
    @Test
    public void sql8() {
        String sql = "delete from sys_teacher where t_name=?";
        //count为受影响的行数
        int count = session.createNativeQuery(sql)
                .setParameter(1, "测试修改")
                .executeUpdate();
        System.out.println(count);
    }

    //修改
    @Test
    public void sql9() {
        String sql = "update sys_teacher set t_class=? where t_name=?";
        int count = session.createNativeQuery(sql)
                .setParameter(1, "web")
                .setParameter(2, "刘老师17")
                .executeUpdate();
        System.out.println(count);
    }

}
