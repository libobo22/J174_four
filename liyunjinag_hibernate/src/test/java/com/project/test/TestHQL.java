package com.project.test;

import com.project.entity.many.MTeacherEntity;
import com.project.entity.many.TeacherDTO;
import com.project.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestHQL {
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
    public void hqlTest(){
        String hql="select t from MTeacherEntity t";
        Query query=session.createQuery(hql);
        List<MTeacherEntity> list=query.list();
        for (MTeacherEntity teacher:
             list) {
            System.out.println(teacher.getTeacherName());
        }
    }
    @Test
    public void hqlTest2(){
        String hql="from MTeacherEntity";
        List<MTeacherEntity> list=session.createQuery(hql).list();
        for (MTeacherEntity teacher:
                list) {
            System.out.println(teacher.getTeacherName());
        }
    }
    @Test
    public void hqlTest3(){
        String hql="from MTeacherEntity where teacherName like ?";
        List<MTeacherEntity> list=session.createQuery(hql)
                .setParameter(0,"%李%").list();
        for (MTeacherEntity teacher:
                list) {
            System.out.println(teacher.getTeacherName());
        }
    }

    /**
     * 返回多个对象
     */
    @Test
    public void hqlTest4(){
        String hql="select teacherId,teacherName from MTeacherEntity where teacherName like ?";
        List<Object[]> list=session.createQuery(hql)
                .setParameter(0,"%李%").list();
        for (Object obj[]:
                list) {
            System.out.println(obj[0].toString()+"  "+obj[1].toString());
        }
    }
    @Test
    public void hqlTest5(){
        String hql="select new com.project.entity.many.TeacherDTO(teacherId,teacherName) from MTeacherEntity where teacherName like ?";
        List<TeacherDTO> list=session.createQuery(hql)
                .setParameter(0,"%老师%").list();
        for (TeacherDTO teacher:
                list) {
            System.out.println(teacher.getTeacherId()+"  "+teacher.getTeacherName());
        }
    }
    @Test
    public void hqlTest6(){
        String hql="select new Map(teacherId,teacherName) from MTeacherEntity where teacherName like ?";
        List<Map> list=session.createQuery(hql)
                .setParameter(0,"%老师%").list();
        for (Map teacher:
                list) {
            System.out.println(teacher.get("0")+"  "+teacher.get("1"));
        }
    }

    /**
     * 关联查询
     */
    @Test
    public void hqlTest7(){
        String hql="select new Map(t.teacherId,t.teacherName,s.studentName)" +
                " from MTeacherEntity t left join t.studentSet s " +
                " where t.teacherName like ?";
        List<Map> list=session.createQuery(hql)
                .setParameter(0,"%老师%").list();
        for (Map teacher:
                list) {
            System.out.println(teacher.get("0")+"  "+teacher.get("1")+"学生："+teacher.get("2"));
        }
    }
    /**
     * 分页查询
     */
    @Test
    public void hqlTest8(){
        int pageNO=2;
        int pageSize=5;
        String hql="from MTeacherEntity";
        List<MTeacherEntity> list=session.createQuery(hql)
                .setFirstResult((pageNO-1)*pageSize)    //起始下标
                .setMaxResults(pageSize)        //返回多少条数据
                .list();
        for (MTeacherEntity t:
             list) {
            System.out.println(t.getTeacherName());
        }
    }

    /**
     * 查询一个对象
     */
    @Test
    public void hqlTest9(){
        String hql="from MTeacherEntity where teacherName=?";
        MTeacherEntity t= (MTeacherEntity) session.createQuery(hql)
                .setParameter(0,"李老师")
                .uniqueResult();    //查询一个对象，若返回多个，会报错
        System.out.println(t.getTeacherId()+" "+t.getTeacherName());
    }

    /**
     * 修改
     */
    @Test
    public void hqlTest10(){
        String hql="update MTeacherEntity set teacherName=? where teacherId=?";
        int i=session.createQuery(hql)
                .setParameter(0,"陈老师")
                .setParameter(1,"402881d670f68cf60170f68cfa600000")
                .executeUpdate();
        System.out.println(i);//打印修改、删除影响的条数
    }

    /**
     * 删除
     */
    @Test
    public void hqlTest11(){
        String hql="delete from MTeacherEntity where teacherName=?";
        int i=session.createQuery(hql)
                .setParameter(0,"陈老师")
                .executeUpdate();
        System.out.println(i);
    }

    public static int step(int s){
        if(s<=2)
        {
            return s;
        }
        else
        {
            return step(s-1)+step(s-2);
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int s=in.nextInt();
        System.out.println(step(s));
    }

}
