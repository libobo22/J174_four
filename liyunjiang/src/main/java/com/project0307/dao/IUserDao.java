package com.project0307.dao;

import com.project0307.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {
    @Select("select pk_id id,f_userName userName,f_password password,f_birthday birthday from t_user3")
    @ResultType(UserEntity.class)
    public List<UserEntity> findAll();

    @Insert("insert into t_user3 values(null,#{userName},#{password},#{birthday})")
    public void addUser(UserEntity user);

    @Delete("delete from t_user3 where pk_id=#{userId}")
    public void delUserById(Integer userId);

    @Update("update t_user3 set f_password=#{param2} where pk_id=#{param1}")
    public void updatePasswordById(Integer userId,String password);

}
