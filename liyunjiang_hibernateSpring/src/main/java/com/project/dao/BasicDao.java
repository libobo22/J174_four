package com.project.dao;

import com.project.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Repository(value = "basicDao")
public class BasicDao<T> {
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;
    private Class<T> clazz;

    public void getCurrentGeneric(){
        Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.clazz=tClass;
    }
    public Session getSession(){
        this.getCurrentGeneric();
        return localSessionFactoryBean.getObject().openSession();
    }
    public Session getCurrentSession(){
        this.getCurrentGeneric();
        return localSessionFactoryBean.getObject().getCurrentSession();
    }


    /**
     * 封装添加对象方法
     * @param t
     */
    public void saveObject(T t){
        this.getCurrentSession().save(t);
    }

    /**
     * 删除数据
     * @param t
     */
    public void delObject(T t){
        this.getCurrentSession().delete(t);
    }

    /**
     * 根据整形id删除数据
     * @param id
     */
    public void delObjectById(int id){
        Object obj=this.getCurrentSession().get(this.clazz,id);
        this.getCurrentSession().delete(obj);
    }

    /**
     * 根据字符串id删除数据
     * @param id
     */
    public void delObjectById(String id){
        Object obj=this.getCurrentSession().get(this.clazz,id);
        this.getCurrentSession().delete(obj);
    }

    /**
     * 更新
     * @param t
     */
    public void updateObject(T t){
        this.getCurrentSession().update(t);
    }

    public List<T> findAll(){
        Session session=this.getCurrentSession();
        String hql="from "+this.clazz.getSimpleName();
        return session.createQuery(hql).list();
    }

    public List<T> findByIdArr(String hql,Object objArr[]){
        Query query=this.getCurrentSession().createQuery(hql);
        for (int i = 0; i < objArr.length; i++) {
            query.setParameter(i,objArr[i]);
        }
        List<T> list=query.list();
        return list;
    }

    public List<T> findByMap(Map<String,Object> map){
        Session session=this.getCurrentSession();
        List<String> keyList=new ArrayList<>(map.keySet());
        String hql="from "+this.clazz.getSimpleName()+" where 1=1";
        for (String str:
                keyList) {
            hql+=" and "+str+"=?";
        }
        int i=0;
        Query query=session.createQuery(hql);
        for (String obj:
                keyList) {
            query.setParameter(i++,map.get(obj));
        }
        List<T> list=query.list();
        return list;
    }

    public List<T> findByStrings(String hql,Object...objects){
        Session session=this.getCurrentSession();
        Query query=this.getCurrentSession().createQuery(hql);
        for (int i = 0; i < objects.length; i++) {
            query.setParameter(i,objects[i]);
        }
        return query.list();
    }

    public void test(){
        Session session=this.getSession();
        Transaction tr=session.getTransaction();
        tr.begin();
        UserEntity user1=session.get(UserEntity.class,5);
        System.out.println(user1.getUserName());
        try {
            Thread.sleep(1000*10);
            session.clear();
            session.flush();
            tr.commit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserEntity user2=session.get(UserEntity.class,5);
        System.out.println(user2.getUserName());
        UserEntity user3=session.get(UserEntity.class,5);
        System.out.println(user3.getUserName());

        session.close();
    }
}
