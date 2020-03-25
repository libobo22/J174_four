package com;

import com.project.hibernate.dto.TeacherDto;
import com.project.hibernate.entity.TeacherEntity;
import com.project.hibernate.entity.many.MStudentEntity;
import com.project.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestHQL {
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
    public void hql1() {
        String hql = "select t from TeacherEntity t";
        //创建查询对象
        Query query = session.createQuery(hql);
        //执行查询
        List<Object> list = query.list();
        for (Object obj : list) {
            System.out.println(((TeacherEntity) obj).getTeacherName() + "/" + ((TeacherEntity) obj).getTeacherClass());
        }
    }

    @Test
    public void hql2() {
        String hql = "from TeacherEntity";
        List<TeacherEntity> list = session.createQuery(hql).list();
        for (TeacherEntity t : list) {
            System.out.println(t.getTeacherName() + "/" + t.getTeacherClass());
        }
    }

    @Test
    public void hql3() {
        String hql = "from TeacherEntity where teacherName=? ";
        List<TeacherEntity> list = session.createQuery(hql).setParameter(0, "陈老师").list();
        for (TeacherEntity t : list) {
            System.out.println(t.getTeacherName() + "/" + t.getTeacherClass());
        }
    }

    @Test
    public void hql33() {
        String hql = "from TeacherEntity where teacherName=:name ";
        List<TeacherEntity> list = session.createQuery(hql).setParameter("name", "陈老师").list();
        for (TeacherEntity t : list) {
            System.out.println(t.getTeacherName() + "/" + t.getTeacherClass());
        }
    }

    @Test
    public void hql4() {
        String hql = "select teacherName,teacherClass from TeacherEntity where teacherClass=?";
        List<Object[]> list = session.createQuery(hql).setParameter(0, "Java1").list();
        for (Object[] objs : list) {
            System.out.println(objs[0].toString() + "/" + objs[1].toString());
        }
    }

    @Test
    public void hql5() {
        String hql = "select new com.project.hibernate.dto.TeacherDto(teacherName,teacherClass) from TeacherEntity where teacherClass=?";
        List<TeacherDto> list = session.createQuery(hql).setParameter(0, "Java1").list();
        for (TeacherDto dto : list) {
            System.out.println(dto.getUserName() + "/" + dto.getUserClass());
        }
    }

    @Test
    public void hql6() {
        String hql = "select new map(teacherName,teacherClass,teacherId) from TeacherEntity where teacherClass=?";
        List<Map> list = session.createQuery(hql).setParameter(0, "Java1").list();
        for (Map map : list) {
            System.out.println(map.get("0") + "/" + map.get("1") + "/" + map.get("2"));
        }
    }

    //模糊查询
    @Test
    public void hql7() {
        // ||是字符串连接符
        String hql = "select new map(teacherName,teacherClass) from TeacherEntity where teacherClass like '%'||?||'%'";
        List<Map> list = session.createQuery(hql).setParameter(0, "J").list();
        for (Map map : list) {
            System.out.println(map.get("0") + "/" + map.get("1"));
        }
    }

    @Test
    public void hql8() {
        String hql = "select new map(teacherName,teacherClass) from TeacherEntity where teacherClass like ?";
        List<Map> list = session.createQuery(hql).setParameter(0, "%J%").list();
        for (Map map : list) {
            System.out.println(map.get("0") + "/" + map.get("1"));
        }
    }

    //关联查询
    @Test
    public void hql9() {
        String hql = "select new map(s.studentName,t.teacherName,t.teacherClass) from StudentEntity s left join s.teacher t where t.teacherName=? ";
        List<Map> list = session.createQuery(hql).setParameter(0, "陈老师").list();
        for (Map map : list) {
            System.out.println(map.get("0") + "/" + map.get("1") + "/" + map.get("2"));
        }
    }

    //分页查询
    @Test
    public void hql10() {
        //当前页码
        int currPage = 4;
        //每页显示条数
        int pageSize = 5;
        String hql = "from TeacherEntity where teacherName like ?";
        List<TeacherEntity> list = session.createQuery(hql).setParameter(0, "%刘老师%").
                setFirstResult((currPage - 1) * pageSize).setMaxResults(pageSize).list();
        for (TeacherEntity t : list) {
            System.out.println(t.getTeacherName());
        }
    }

    //返回一个对象
    @Test
    public void hql11() {
        String hql = "from TeacherEntity where teacherName=?";
        TeacherEntity t = (TeacherEntity) session.createQuery(hql).setParameter(0, "陈老师").uniqueResult();
        System.out.println(t.getTeacherName() + "/" + t.getTeacherClass());
    }

    //删除对象
    @Test
    public void hql12() {
        String hql = "delete from TeacherEntity where teacherName=?";
        int i = session.createQuery(hql).setParameter(0, "刘老师19").executeUpdate();
        System.out.println(i);
    }

    //修改对象
    @Test
    public void hql13() {
        String hql = "update TeacherEntity set teacherName=? where teacherId=?";
        int count = session.createQuery(hql).setParameter(0, "测试修改").setParameter(1, "40288ae670f5d8a30170f5d8a5e90011").executeUpdate();
        System.out.println(count);
    }


}
