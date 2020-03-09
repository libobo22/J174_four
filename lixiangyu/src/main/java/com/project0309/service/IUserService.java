package com.project0309.service;

import com.project0309.entity.UserEntity;

/**
 * 用户业务接口
 */
public interface IUserService {
    public UserEntity findByUserName(String userName);

    public void addUser(UserEntity userEntity);
}
