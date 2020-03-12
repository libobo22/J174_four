package com.project0310.dao;

import com.project0310.bean.OrderBean;
import org.apache.ibatis.annotations.Insert;

public interface IOrderDao {
    @Insert("insert into t_order values(null,#{repertory.goodsId},#{price})")
    public void addOrder(OrderBean order);
}
