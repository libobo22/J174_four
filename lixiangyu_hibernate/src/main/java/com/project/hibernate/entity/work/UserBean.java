package com.project.hibernate.entity.work;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity //被hibernate管理的标记
@Table(name = "sys_user") //映射表
public class UserBean {
    @Id
    @Column(name = "u_id", length = 32)
    @GenericGenerator(name = "uuuid", strategy = "uuid")
    @GeneratedValue(generator = "uuuid")
    private String userId;
    @Column(name = "u_userName", length = 48)
    private String userName;
    @Column(name = "u_loginName", length = 48)
    private String loginName;
    @Column(name = "u_password", length = 48)
    private String password;
    @Column(name = "u_status", length = 48, columnDefinition = "ENUM('enabled','disabled')")
    private String userStatus = "enabled";
    @OneToMany(mappedBy = "user")
    private Set<RoleBean> roleSet;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public void setUserStatus(String status) {
        this.userStatus = status;
    }

    public Set<RoleBean> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<RoleBean> roleSet) {
        this.roleSet = roleSet;
    }
}
