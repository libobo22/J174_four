package com.project.entity;

import java.util.Set;
import javax.persistence.*;
/**
 * 角色实体类
 */
@Entity
@Table(name = "x_role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_roleId")
    private Integer roleId;
    @Column(name = "f_roleName",length = 32)
    private String roleName;
    @Column(name = "f_roleInfo")
    private String roleInfo;
    @OneToMany(mappedBy = "role")
    private Set<UserRoleEntity> userRoleSet;
    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    private Set<RolePermissionEntity> rolePerSet;

    public RoleEntity() {
    }

    public RoleEntity(String roleName, String roleInfo) {
        this.roleName = roleName;
        this.roleInfo = roleInfo;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserRoleEntity> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRoleEntity> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }

    public Set<RolePermissionEntity> getRolePerSet() {
        return rolePerSet;
    }

    public void setRolePerSet(Set<RolePermissionEntity> rolePerSet) {
        this.rolePerSet = rolePerSet;
    }

    public String getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo;
    }
}
