package com.project.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sys_user_role")
public class UserRoleEntity {
    @Id
    @Column(name = "ur_id", length = 32)
    @GenericGenerator(name = "uruuid", strategy = "uuid")
    @GeneratedValue(generator = "uruuid")
    private String urId;
    @ManyToOne(cascade = CascadeType.ALL)
//    @ManyToOne
    @JoinColumn(name = "f_u_id")
    private UserEntity user;
    @ManyToOne(cascade = CascadeType.ALL)
//    @ManyToOne
    @JoinColumn(name = "f_r_id")
    private RoleEntity role;

    public String getUrId() {
        return urId;
    }

    public void setUrId(String urId) {
        this.urId = urId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
