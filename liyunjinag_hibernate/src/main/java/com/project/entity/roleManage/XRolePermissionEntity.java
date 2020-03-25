package com.project.entity.roleManage;

import javax.persistence.*;

@Entity
@Table(name = "x_role_permission")
public class XRolePermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_rolePerId")
    private Integer rolePerId;
    @JoinColumn(name="fk_roleId")
    @ManyToOne
    private XRoleEntity role;
    @JoinColumn(name="fk_perId")
    @ManyToOne
    private XPermissionEntity permission;
    @Column(name = "f_perStatus")
    private String perStatus;

    public XRolePermissionEntity() {
    }

    public XRolePermissionEntity(XRoleEntity role, XPermissionEntity permission, String perStatus) {
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

    public XRoleEntity getRole() {
        return role;
    }

    public void setRole(XRoleEntity role) {
        this.role = role;
    }

    public XPermissionEntity getPermission() {
        return permission;
    }

    public void setPermission(XPermissionEntity permission) {
        this.permission = permission;
    }

    public String getPerStatus() {
        return perStatus;
    }

    public void setPerStatus(String perStatus) {
        this.perStatus = perStatus;
    }
}
