package com.project;

import com.projectTP.service.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestTP {
    @Autowired
    private IOrderService service;

    @Test
    public void test() {
      // service.addOrder(2, 200);
        service.addOrder(1, 100);
    }
}
