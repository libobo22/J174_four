package com.project0310.service.impl;

import com.project0310.entity.UserEntity0310;
import com.project0310.entity.UserInfoEntity;
import com.project0310.mapper.IUserMapper;
import com.project0310.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserMapper mapper;

    @Override
    public void register(UserEntity0310 userEntity) {
        mapper.register(userEntity);
    }

    @Override
    public void addUserInfo(UserInfoEntity userInfoEntity) {
        mapper.addUserInfo(userInfoEntity);
    }

    @Override
    public UserEntity0310 getUserInfo(int userId) {
        return mapper.getUserInfo(userId);
    }

    @Override
    public List<UserEntity0310> findAllUser() {
        return mapper.findAllUser();
    }
}
