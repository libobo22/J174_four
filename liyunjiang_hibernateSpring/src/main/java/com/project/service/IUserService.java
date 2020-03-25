package com.project.service;

import com.project.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface IUserService {
    public void addUser(UserEntity user);
    public void delUser(UserEntity user);
    public void delUserById(int id);
    public List<UserEntity> findAll();
    public List<UserEntity> findByIdArr(Object[] objArr);
    public List<UserEntity> findByMap(Map<String,Object> map);
    public List<UserEntity> findByStrings(Object...objects);
    public void test();
}
