package com.project0310.service.impl;

import com.project0310.bean.InfoBean;
import com.project0310.bean.UserBean;
import com.project0310.dao.IUserDao;
import com.project0310.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Transactional
    @Override
    public void addUser(UserBean user) {
        userDao.addUser(user);
    }

    @Override
    public List<UserBean> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserBean findUserInfoById(Integer userId) {
        return userDao.findUserInfoById(userId);
    }

    @Transactional
    @Override
    public void addInfo(Integer userId, InfoBean info) {
        userDao.addInfo(userId,info);
    }

}
