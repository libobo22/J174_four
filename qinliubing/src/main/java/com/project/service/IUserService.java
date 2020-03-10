package com.project.service;

import com.project.entity.UserEntity;

public interface IUserService {

    public UserEntity findByUserName(String UserName);

    public  void addUser(UserEntity userEntity);
}
