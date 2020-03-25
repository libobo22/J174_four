package com.project.hibernate.entity.work;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity //被hibernate管理的标记
@Table(name = "sys_role") //映射表
public class RoleBean {
    @Id
    @Column(name = "r_id", length = 32)
    @GenericGenerator(name = "ruuid", strategy = "uuid")
    @GeneratedValue(generator = "ruuid")
    private String roleId;
    @Column(name = "r_name", length = 48)
    private String roleName;
    @Column(name = "r_info", length = 48)
    private String roleInfo;
    @Column(name = "r_status", length = 48, columnDefinition = "ENUM('enabled','disabled')")
    private String roleStatus = "enabled";
    @ManyToOne
    @JoinColumn(name = "fk_u_id")
    private UserBean user;
    @OneToMany(mappedBy = "role")
    private Set<PowerBean> powerSet;

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

    public String getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public Set<PowerBean> getPowerSet() {
        return powerSet;
    }

    public void setPowerSet(Set<PowerBean> powerSet) {
        this.powerSet = powerSet;
    }
}
