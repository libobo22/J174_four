package com.project0312.service.impl;

import com.project0312.mapper.IOrderMapper;
import com.project0312.mapper.IProductMapper;
import com.project0312.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IOrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderMapper orderMapper;
    @Autowired
    private IProductMapper productMapper;

    @Override
    public void addOrder(int productId, int number) {
        orderMapper.add(productId, number);
//        int a = 9 / 0;
        productMapper.update(productId, number);
    }
}
