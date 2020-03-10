package com.project0310.dao;

import com.project0310.bean.InfoBean;
import com.project0310.bean.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into t_user3 values(null,#{userName},#{password},#{birthday})")
    public void addUser(UserBean user);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select pk_id id,f_userName userName,f_password password,f_birthday birthday from t_user3")
    @ResultType(UserBean.class)
    public List<UserBean> findAll();

    /**
     * 查询用户所有信息
     * @param userId
     * @return
     */
    public UserBean findUserInfoById(Integer userId);

    /**
     * 添加用户信息
     * @param userId
     * @param info
     */
    @Insert("insert into t_info values(null,#{info.job},#{info.money},#{info.changeDate},#{userId})")
    public void addInfo(@Param("userId") Integer userId,@Param("info") InfoBean info);
}
