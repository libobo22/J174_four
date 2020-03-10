package com.project0310.service;

import com.project0310.bean.InfoBean;
import com.project0310.bean.UserBean;

import java.util.List;

public interface IUserService {
    /**
     * 添加用户
     * @param user
     */
    public void addUser(UserBean user);

    /**
     * 查询所有用户
     * @return
     */
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
    public void addInfo(Integer userId, InfoBean info);
}
