package com.project.dao;

import com.project.entity.UserEntity;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Map;

@Transactional
@Repository
public class BasicDao {
    @Autowired
    private LocalContainerEntityManagerFactoryBean managerFactory;
    public EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory=
                managerFactory.getNativeEntityManagerFactory();
        return entityManagerFactory.createEntityManager();
    }

    public List<UserEntity> findUserList(){
        String hql="from UserEntity";
        List<UserEntity> list=this.getEntityManager().createQuery(hql).getResultList();
        return list;
    }
    public UserEntity findUser(){
        String hql="from UserEntity where userId=?1";
        UserEntity user= (UserEntity) this.getEntityManager()
                .createQuery(hql).setParameter(1,5)
                .getSingleResult();
        return user;
    }
    public  UserEntity findUser2(){
        String hql="from UserEntity where userId=:userId";
        UserEntity user= (UserEntity) this.getEntityManager()
                .createQuery(hql).setParameter("userId",5)
                .getSingleResult();
        return user;
    }

    public  UserEntity findUserSQL(){
        String sql="select * from sys_user where pk_userId=:userId";
        NativeQuery nativeQuery = (NativeQuery) this.getEntityManager()
                .createNativeQuery(sql);
        UserEntity user= (UserEntity) nativeQuery.addEntity(UserEntity.class)
                .setParameter("userId",5).getSingleResult();
        return user;
    }
    public List<UserEntity> findUserListSQL(){
        String sql="select * from sys_user";
        NativeQuery nativeQuery = (NativeQuery) this.getEntityManager()
                .createNativeQuery(sql);
        List<UserEntity> list=nativeQuery.addEntity(UserEntity.class).getResultList();
        return list;
    }

    public List<Map> findUserMapSQL(){
        String sql="select f_loginName,f_password from sys_user";
        List<Map> list=this.getEntityManager().createNativeQuery(sql)
                .unwrap(NativeQueryImpl.class)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
                .list();
        return list;
    }
}
