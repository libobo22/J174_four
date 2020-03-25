package com.project.service.impl;

import com.project.dao.IUserDao;
import com.project.entity.UserEntity;
import com.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public List<UserEntity> findUserList(String userStatus) {
        return userDao.findUserList(userStatus);
    }

    @Override
    public List<Map> getListMap() {
        return userDao.getListMap();
    }

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) userDao.findAll();
    }

    @Override
    public List<UserEntity> findAllById() {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(5);

        return (List<UserEntity>) userDao.findAllById(list);
    }


    @Override
    public UserEntity findById(Integer id) {
        Optional<UserEntity> optional=userDao.findById(id);
        return optional.get();
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userDao.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }
}
