package com.project.dao;

import com.project.dto.UserPermissionDTO;
import com.project.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserDao extends CrudRepository<UserEntity,Integer> {
    @Query("from UserEntity where loginName=?1 and password=?2")
    public UserEntity login(String loginName,String password);

    /**
     * 根据登录名查询出用户的所有权限
     * @param loginName
     * @return
     */
    @Query(value = "SELECT DISTINCT a.f_userName userName,e.f_perName perName,e.f_perUrl perUrl " +
            "from x_user a,x_user_role b,x_role c,x_role_permission d,x_permission e " +
            "where a.pk_userId=b.fk_userId and b.fk_roleId=c.pk_roleId and c.pk_roleId=d.fk_roleId " +
            "and d.fk_perId=e.pk_perId and a.f_loginName=:loginName and b.f_roleStatus='1' and d.f_perStatus='1'",
            nativeQuery = true)
    public List<Object[]> findPermissionByLoginName(@Param("loginName") String loginName);
}
