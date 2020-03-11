package com.project0310.mapper;

import com.project0310.entity.UserEntity0310;
import com.project0310.entity.UserInfoEntity;

import java.util.List;

public interface IUserMapper {
    /**
     * 注册
     *
     * @param userEntity 用户实体类
     */
    public void register(UserEntity0310 userEntity);

    /**
     * 添加用户详细信息
     *
     * @param userInfoEntity 用户信息实体类
     */
    public void addUserInfo(UserInfoEntity userInfoEntity);

    /**
     * 按ID查询该用户，联表查出该用户拥有的信息集合
     *
     * @param userId 用户ID
     * @return 用户对象
     */
    public UserEntity0310 getUserInfo(int userId);
    /**
     * 查询所有用户
     * @return 用户对象集合
     */
    public List<UserEntity0310> findAllUser();
}
