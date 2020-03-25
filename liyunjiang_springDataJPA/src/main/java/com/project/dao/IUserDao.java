package com.project.dao;

import com.project.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface IUserDao extends CrudRepository<UserEntity,Integer> {
    @Query("from UserEntity where userStatus=?1")
    public List<UserEntity> findUserList(String userStatus);
    @Query("select new map(userName,loginName) from UserEntity ")
    public List<Map> getListMap();
}
