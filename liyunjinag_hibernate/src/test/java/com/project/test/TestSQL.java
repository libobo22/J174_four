package com.project.test;

import com.project.entity.StudentEntity;
import com.project.entity.TeacherEntity;
import com.project.entity.many.MTeacherEntity;
import com.project.entity.many.TeacherDTO;
import com.project.utils.HibernateSessionFactory;
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
    public void sql1(){
        String sql="select * from m_teacher";
        NativeQuery query= session.createNativeQuery(sql);
        //把查询出来的数据放入实体中，该实体是hibernate所管理起来的实体
        query.addEntity(MTeacherEntity.class);
        List<MTeacherEntity> list=query.list();
        for (MTeacherEntity t:
             list) {
            System.out.println(t.getTeacherName());
        }
    }
    @Test
    public void sql2(){
        String sql="select pk_teacherId,f_teacherName from m_teacher";
        NativeQuery query= session.createNativeQuery(sql);
        List<Object[]> list=query.list();
        for (Object[] t:
                list) {
            System.out.println(t[1]);
        }
    }

    /**
     * 使用map集合进行封装数据
     */
    @Test
    public void sql3(){
        String sql="select pk_teacherId,f_teacherName from m_teacher";
        NativeQuery query= session.createNativeQuery(sql)
                .unwrap(NativeQueryImpl.class)//拆包
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map> list=query.list();
        for (Map t:
                list) {
            System.out.println(t.get("pk_teacherId")+"/"+t.get("f_teacherName"));
        }
    }

    /**
     * 使用DTO进行封装返回数据
     */
    @Test
    public void sql4(){
        String sql="select pk_teacherId as teacherId,f_teacherName as teacherName from m_teacher";
        NativeQuery query= session.createNativeQuery(sql)
                .unwrap(NativeQueryImpl.class)//拆包
                .setResultTransformer(Transformers.aliasToBean(TeacherDTO.class));
        List<TeacherDTO> list=query.list();
        for (TeacherDTO t:
                list) {
            System.out.println(t.getTeacherId()+"/"+t.getTeacherName());
        }
    }
    /**
     * 分页
     */
    @Test
    public void sql5(){
        String sql="select pk_teacherId as teacherId,f_teacherName as teacherName from m_teacher";
        NativeQuery query= session.createNativeQuery(sql)
                .setFirstResult(0).setMaxResults(5) //起始位置以及，条数
                .unwrap(NativeQueryImpl.class)//拆包
                .setResultTransformer(Transformers.aliasToBean(TeacherDTO.class));
        List<TeacherDTO> list=query.list();
        for (TeacherDTO t:
                list) {
            System.out.println(t.getTeacherId()+"/"+t.getTeacherName());
        }
    }
    /**
     * 查询一个对象
     */
    @Test
    public void sql6(){
        String sql="select * from sys_teacher where f_teacherClass=?";
        TeacherEntity t= (TeacherEntity) session.createNativeQuery(sql)
                .addEntity(TeacherEntity.class)
                .setParameter(1,"servlet")
                .uniqueResult();//查询结果集只有一个，否则会报NonUniqueResultException异常
        System.out.println(t.getTeacherName()+"/"+t.getTeacherClass());
    }
    /**
     * 删除
     */
    @Test
    public void sql7(){
        String sql="delete from m_teacher where f_teacherName=?";
        int count=session.createNativeQuery(sql)
                .setParameter(1,"老师1")
                .executeUpdate();
        System.out.println(count);
    }
    /**
     * 修改
     */
    @Test
    public void sql8(){
        String sql="update m_teacher set f_teacherName=? where pk_teacherId=?";
        int count=session.createNativeQuery(sql)
                .setParameter(1,"花花老师")
                .setParameter(2,"402881d670f5f2110170f5f215af0001")
                .executeUpdate();
        System.out.println(count);
    }

    public void sql9(){
        String sql="SELECT t.*,s.* from sys_teacher t LEFT JOIN sys_student s " +
                "on t.pk_teacherId=s.fk_teacherId " +
                "where t.pk_teacherId=?";
        List<Object[]> list=session.createNativeQuery(sql)
                .setParameter(1,"402881d670eb91420170eb91452c0000")
                .addEntity("t",TeacherEntity.class)
                .addEntity("s", StudentEntity.class)
                .list();
        for (Object[] obj:
             list) {
            TeacherEntity t= (TeacherEntity) obj[0];
            StudentEntity s= (StudentEntity) obj[1];
            System.out.println(t.getTeacherName()+"的学生"+s.getStudentName());
        }
    }
}
