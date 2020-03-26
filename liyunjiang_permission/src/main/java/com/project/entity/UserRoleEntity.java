package com.project.entity;
import javax.persistence.*;
/**
 * 用户与角色的中间实体类
 */
@Entity
@Table(name = "x_user_role")
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_userRoleId")
    private Integer userRoleId;
    @JoinColumn(name="fk_userId")
    @ManyToOne
    private UserEntity user;
    @JoinColumn(name="fk_roleId")
    @ManyToOne
    private RoleEntity role;
    @Column(name = "f_roleStatus")
    private String roleStatus;

    public UserRoleEntity() {
    }

    public UserRoleEntity(UserEntity user, RoleEntity role, String roleStatus) {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }
}
