package com.lovo.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="sys_role")
public class RoleEntity {
    @Id
    //设置本表中列的属性
    @Column(name = "r_id",length = 32)
    //自定义uuid
    @GenericGenerator(name = "roleuuid",strategy = "uuid")
    //给id一个生产策略
    @GeneratedValue(generator = "roleuuid")
    private String roleId;

    @Column(name="r_name",length =48)
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
}
