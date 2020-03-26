package com.project.service;

import com.project.entity.UserEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IUserService {
    public List<UserEntity> findUserList(String userStatus);
    public List<Map> getListMap();
    public List<UserEntity> findAll();
    public List<UserEntity> findAllById();
    public UserEntity findById(Integer id);
    public UserEntity save(UserEntity user);
    public void deleteById(Integer id);
    public void saveAll(List<UserEntity> list);
    public List<UserEntity> getPageList(String userStatus, Pageable pageRequest);
}
