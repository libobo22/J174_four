package com.project.dao;

import com.project.entity.UserEntity;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
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
@Repository("basicDao")
public class BasicDao {
    @Autowired
    private LocalContainerEntityManagerFactoryBean managerFactory;
    public EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory=
                managerFactory.getNativeEntityManagerFactory();
        return entityManagerFactory.createEntityManager();
    }

}
