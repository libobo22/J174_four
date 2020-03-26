package com.project.entity;

import java.util.Set;
import javax.persistence.*;
/**
 * 权限实体类
 */
@Entity
@Table(name = "x_permission")
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_perId")
    private Integer perId;
    @Column(name = "f_perName",length = 32)
    private String perName;
    @Column(name = "f_perUrl")
    private String perUrl;
    @OneToMany(mappedBy = "permission")
    private Set<RolePermissionEntity> rolePerSet;

    public PermissionEntity() {
    }

    public PermissionEntity(String perName, String perUrl) {
        this.perName = perName;
        this.perUrl = perUrl;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public Set<RolePermissionEntity> getRolePerSet() {
        return rolePerSet;
    }

    public void setRolePerSet(Set<RolePermissionEntity> rolePerSet) {
        this.rolePerSet = rolePerSet;
    }

    public String getPerUrl() {
        return perUrl;
    }

    public void setPerUrl(String perUrl) {
        this.perUrl = perUrl;
    }
}
