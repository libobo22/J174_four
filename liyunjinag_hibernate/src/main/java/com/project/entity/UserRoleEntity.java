package com.project.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sys_user_role")
public class UserRoleEntity {
    @Id
    @GenericGenerator(name = "uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(name = "pk_id",length = 32)
    private String id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_userId")
    private UserEntity user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_roleId")
    private RoleEntity role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
