package com.project0309.service.impl;

import com.project0309.entity.UserEntity;
import com.project0309.mapper.IUserMapper;
import com.project0309.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper mapper;

    @Override
    public UserEntity findByUserName(String userName) {
        return mapper.findByUserName(userName);
    }

    @Override
    public void addUser(UserEntity userEntity) {
        mapper.addUser(userEntity);
    }
}
