package com.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "x_role_permission")
public class RolePermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_rolePerId")
    private Integer rolePerId;
    @JoinColumn(name="fk_roleId")
    @ManyToOne
    private RoleEntity role;
    @JoinColumn(name="fk_perId")
    @ManyToOne
    private PermissionEntity permission;
    @Column(name = "f_perStatus")
    private String perStatus;

    public RolePermissionEntity() {
    }

    public RolePermissionEntity(RoleEntity role, PermissionEntity permission, String perStatus) {
        this.role = role;
        this.permission = permission;
        this.perStatus = perStatus;
    }

    public Integer getRolePerId() {
        return rolePerId;
    }

    public void setRolePerId(Integer rolePerId) {
        this.rolePerId = rolePerId;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public PermissionEntity getPermission() {
        return permission;
    }

    public void setPermission(PermissionEntity permission) {
        this.permission = permission;
    }

    public String getPerStatus() {
        return perStatus;
    }

    public void setPerStatus(String perStatus) {
        this.perStatus = perStatus;
    }
}
