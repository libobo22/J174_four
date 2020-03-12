package com.project0312.mapper;

public interface IProductMapper {
    /**
     * 修改商品库存
     * @param productId 商品ID
     * @param number 销售数量
     */
    public void update(int productId,int number);
}
