package com.project0307.service.impl;

import com.project0307.dao.IUserDao;
import com.project0307.entity.UserEntity;
import com.project0307.service.IUserService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;
    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public void addUser(UserEntity user) {
        userDao.addUser(user);
//        int x=9/0;
    }

    @Transactional
    @Override
    public void delUserById(Integer userId) {
        userDao.delUserById(userId);
    }

    @Transactional
    @Override
    public void updatePasswordById(Integer userId, String password) {
        userDao.updatePasswordById(userId,password);
    }
}
