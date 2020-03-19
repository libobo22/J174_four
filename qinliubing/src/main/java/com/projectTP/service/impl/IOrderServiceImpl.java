package com.projectTP.service.impl;


import com.projectTP.mapper.IOrderMapper;
import com.projectTP.mapper.IProductMapper;
import com.projectTP.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IOrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderMapper orderMapper;
    @Autowired
    private IProductMapper productMapper;

    @Override
    public void addOrder(int id, int number) {
        orderMapper.add(id, number);

        productMapper.updateStock(id, number);
    }
}
