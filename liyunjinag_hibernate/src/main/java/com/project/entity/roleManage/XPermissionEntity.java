package com.project.entity.roleManage;

import javax.persistence.*;
import java.util.Set;

/**
 * 权限实体类
 */
@Entity
@Table(name = "x_permission")
public class XPermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_perId")
    private Integer perId;
    @Column(name = "f_perName",length = 32)
    private String perName;
    @Column(name = "f_perUrl")
    private String perUrl;
    @OneToMany(mappedBy = "permission")
    private Set<XRolePermissionEntity> rolePerSet;

    public XPermissionEntity() {
    }

    public XPermissionEntity(String perName, String perUrl) {
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

    public Set<XRolePermissionEntity> getRolePerSet() {
        return rolePerSet;
    }

    public void setRolePerSet(Set<XRolePermissionEntity> rolePerSet) {
        this.rolePerSet = rolePerSet;
    }

    public String getPerUrl() {
        return perUrl;
    }

    public void setPerUrl(String perUrl) {
        this.perUrl = perUrl;
    }
}
