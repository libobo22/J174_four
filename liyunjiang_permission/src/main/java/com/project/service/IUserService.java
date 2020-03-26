package com.project.service;

import com.project.dto.UserPermissionDTO;
import com.project.entity.UserEntity;

import java.util.List;

public interface IUserService {
    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     */
    public UserEntity login(String loginName,String password);

    /**
     * 根据登录名查询出用户的所有权限
     * @param loginName
     * @return
     */
    public List<UserPermissionDTO> findPermissionByLoginName(String loginName);
}
