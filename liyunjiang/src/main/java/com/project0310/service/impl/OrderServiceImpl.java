package com.project0310.service.impl;

import com.project0310.bean.OrderBean;
import com.project0310.dao.IOrderDao;
import com.project0310.dao.IRepertoryDao;
import com.project0310.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;
    @Autowired
    private IRepertoryDao repertoryDao;
    @Override
    public void addOrder(OrderBean order,Integer num) {
        repertoryDao.updateNum(order.getRepertory().getGoodsId(),num);
        orderDao.addOrder(order);
        int x=9/0;
    }
}
