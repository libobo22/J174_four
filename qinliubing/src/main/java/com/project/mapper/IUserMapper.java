package com.project.mapper;

import com.project.entity.UserEntity;

public interface IUserMapper {

    public UserEntity findByUserName(String userName);
    public void addUser(UserEntity userEntity);
}
