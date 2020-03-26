package com.project.entity;

import java.util.Set;
import javax.persistence.*;
/**
 * 用户实体类
 */
@Entity
@Table(name = "x_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_userId")
    private Integer userId;
    @Column(name = "f_userName",length = 32)
    private String userName;
    @Column(name = "f_loginName",length = 32)
    private String loginName;
    @Column(name = "f_password",length = 32)
    private String password;
    @Column(name = "f_userStatus",length = 32)
    private String userStatus;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Set<UserRoleEntity> userRoleSet;

    public UserEntity() {
    }

    public UserEntity(String userName, String loginName, String password, String userStatus) {
        this.userName = userName;
        this.loginName = loginName;
        this.password = password;
        this.userStatus = userStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Set<UserRoleEntity> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRoleEntity> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
}
