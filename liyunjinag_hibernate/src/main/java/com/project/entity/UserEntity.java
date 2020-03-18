package com.project.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "sys_user")
public class UserEntity {
    @Id
    @GenericGenerator(name = "useruuid",strategy = "uuid")
    @GeneratedValue(generator = "useruuid")
    @Column(name = "pk_userId",length = 32)
    private String userId;
    private String userName;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Set<UserRoleEntity> userRoleSet;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<UserRoleEntity> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRoleEntity> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }

}
