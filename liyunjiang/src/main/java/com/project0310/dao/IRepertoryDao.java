package com.project0310.dao;

import org.apache.ibatis.annotations.Update;

public interface IRepertoryDao {
    @Update("update t_repertory set f_num=f_num-#{param2} where pk_goodsId=#{param1}")
    public void updateNum(Integer goodsId,Integer num);
}
