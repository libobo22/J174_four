package com.project.test;

import com.project.dao.BasicDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitContext {
    @Test
    public void initContext1(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BasicDao basicDao= (BasicDao) context.getBean("basicDao");
        System.out.println(basicDao.getEntityManager());
    }
}
