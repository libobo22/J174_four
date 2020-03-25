package com.project.hibernate.entity.work;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity //被hibernate管理的标记
@Table(name = "sys_power") //映射表
public class PowerBean {
    @Id
    @Column(name = "p_id", length = 32)
    @GenericGenerator(name = "puuid", strategy = "uuid")
    @GeneratedValue(generator = "puuid")
    private String powerId;
    @Column(name = "p_name", length = 48)
    private String powerName;
    @Column(name = "p_resource", length = 48)
    private String powerResource;
    @Column(name = "p_status", length = 48, columnDefinition = "ENUM('enabled','disabled')")
    private String powerStatus = "enabled";
    @ManyToOne
    @JoinColumn(name = "fk_r_id")
    private RoleBean role;

    public String getPowerId() {
        return powerId;
    }

    public void setPowerId(String powerId) {
        this.powerId = powerId;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getPowerResource() {
        return powerResource;
    }

    public void setPowerResource(String powerResource) {
        this.powerResource = powerResource;
    }

    public String getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(String powerStatus) {
        this.powerStatus = powerStatus;
    }

    public RoleBean getRole() {
        return role;
    }

    public void setRole(RoleBean role) {
        this.role = role;
    }
}
