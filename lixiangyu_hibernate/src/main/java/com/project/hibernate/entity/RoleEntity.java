package com.project.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sys_role")
public class RoleEntity {
    @Id
    //设置表中列的属性
    @Column(name = "r_id", length = 32)
    //自定义UUID策略
    @GenericGenerator(name = "ruuid", strategy = "uuid")
    //给id一个生成策略，自定义生成策略
    @GeneratedValue(generator = "ruuid")
    private String roleId;
    @Column(name = "r_name", length = 48)
    private String roleName;
    @OneToMany(mappedBy = "role")
    private Set<UserRoleEntity> urSet;

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

    public Set<UserRoleEntity> getUrSet() {
        return urSet;
    }

    public void setUrSet(Set<UserRoleEntity> urSet) {
        this.urSet = urSet;
    }
}
