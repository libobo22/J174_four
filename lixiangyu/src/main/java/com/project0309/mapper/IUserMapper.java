package com.project0309.mapper;

import com.project0309.entity.UserEntity;

public interface IUserMapper {
    public UserEntity findByUserName(String userName);

    public void addUser(UserEntity userEntity);
}
