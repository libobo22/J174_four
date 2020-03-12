package com.project0312.service;


public interface IOrderService {
    /**
     * 添加订单，并且修改商品库存
     * @param productId 商品ID
     * @param number 销售数量
     */
    public void addOrder(int productId, int number);
}
