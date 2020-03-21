package com.project.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="sys_role")
public class RoleEntity {
    @Id
    @Column(length = 32,name = "pk_roleId")
    @GenericGenerator(name = "ruuid",strategy = "uuid")
    @GeneratedValue(generator = "ruuid")
    private String roleId;
    @Column(length = 20,name = "f_roleName")
    private String roleName;
    @OneToMany(mappedBy = "role")
    private Set<UserRoleEntity> userRoleSet;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
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

}
