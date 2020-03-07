package com.project.test;

import com.project0307.entity.StudentEntity;
import com.project0307.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StuTest {
    @Resource
    private IStudentService service;

    @Test
    public void test() {
//        service.add(new StudentEntity("小明", "15884867186"));
//        service.del(22);
//        service.update(2, "1666666666");
        System.out.println(service.findById(2).getName());
    }
}