package com.project;


import com.project.entity.StudentEntity;
import com.project.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentTest {
    @Resource
    private IStudentService service;

    @Test
    public void test() {
            service.add(new StudentEntity("詹姆斯", "12348900987"));
     //  service.del(4);
      //service.updatePhone(4, "18888888888");
      //  System.out.println(service.findById(4).getName());
    }

}
