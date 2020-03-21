package com.projectTP.service;


public interface IOrderService {
    /**
     * 添加订单，并且修改商品库存
     * @param id 商品ID
     * @param number 销售数量
     */
    public void addOrder(int id, int number);
}
