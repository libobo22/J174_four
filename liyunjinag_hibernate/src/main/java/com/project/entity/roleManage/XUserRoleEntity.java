package com.project.entity.roleManage;

import javax.persistence.*;

/**
 * 用户与角色的中间实体类
 */
@Entity
@Table(name = "x_user_role")
public class XUserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_userRoleId")
    private Integer userRoleId;
    @JoinColumn(name="fk_userId")
    @ManyToOne
    private XUserEntity user;
    @JoinColumn(name="fk_roleId")
    @ManyToOne
    private XRoleEntity role;
    @Column(name = "f_roleStatus")
    private String roleStatus;

    public XUserRoleEntity() {
    }

    public XUserRoleEntity(XUserEntity user, XRoleEntity role, String roleStatus) {
        this.user = user;
        this.role = role;
        this.roleStatus = roleStatus;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public XUserEntity getUser() {
        return user;
    }

    public void setUser(XUserEntity user) {
        this.user = user;
    }

    public XRoleEntity getRole() {
        return role;
    }

    public void setRole(XRoleEntity role) {
        this.role = role;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }
}
