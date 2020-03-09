package com.project.service.impl;

import com.project.entity.UserEntity;
import com.project.mapper.IUserMapper;
import com.project.service.IUserService;
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
}
