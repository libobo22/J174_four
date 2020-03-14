package com.project.test;

import com.project0312.service.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test0312 {
    @Autowired
    private IOrderService service;

    @Test
    public void testSHIWU() {
//        service.addOrder(1, 100);
        service.addOrder(2, 50);
    }
}
