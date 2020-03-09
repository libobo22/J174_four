package com.project0307.service;

import com.project0307.entity.UserEntity;

import java.util.List;

public interface IUserService {
    public List<UserEntity> findAll();

    public void addUser(UserEntity user);

    public void delUserById(Integer userId);

    public void updatePasswordById(Integer userId,String password);

    public UserEntity findByUserName(String userName);
}
