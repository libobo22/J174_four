package com.project.service.impl;

import com.project.dao.BasicDao;
import com.project.dao.UserDao;
import com.project.entity.UserEntity;
import com.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = {Exception.class})
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void addUser(UserEntity user) {
        userDao.saveObject(user);
//        int x=9/0;
    }

    @Override
    public void delUser(UserEntity user) {

    }

    @Override
    public void delUserById(int id) {
        userDao.delObjectById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public List<UserEntity> findByIdArr(Object[] objArr) {
        String hql="from UserEntity where userStatus=?";
        return userDao.findByIdArr(hql,objArr);
    }
    @Transactional(readOnly = true)
    @Override
    public List<UserEntity> findByMap(Map<String, Object> map) {
        return userDao.findByMap(map);
    }
    @Transactional(readOnly = true)
    @Override
    public List<UserEntity> findByStrings(Object... objects) {
        String hql="from UserEntity where userStatus=?";
        return userDao.findByIdArr(hql,objects);
    }

    @Override
    public void test() {
        userDao.test();
    }


}
