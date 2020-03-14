package com.project0312.mapper;

public interface IOrderMapper {
    /**
     * 添加订单
     * @param productId 商品ID
     * @param number 销售数量
     */
    public void add(int productId,int number);
}
