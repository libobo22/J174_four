package com.project.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity //被hibernate管理的标记
@Table(name = "sys_user") //映射表
public class UserEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int userId;
//    @Column(name = "u_name", length = 48, nullable = false, unique = true)
//    private String userName;
//    // @Column(insertable = false)
////    @Transient //暂态
//    private String password;
//    private int age;

//    @Column(columnDefinition = "TEXT")
//    private String info;
//    @Column(columnDefinition = "TIMESTAMP")
//    private String addDate;

    @Id
    @Column(name = "u_id", length = 32)
    @GenericGenerator(name = "uuuid", strategy = "uuid")
    @GeneratedValue(generator = "uuuid")
    private String userId;
    @Column(name = "u_name", length = 48)
    private String userName;
    @Column(name = "u_pwd", length = 48)
    private String password;
    @OneToMany(mappedBy = "user")
    private Set<UserRoleEntity> urSet;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRoleEntity> getUrSet() {
        return urSet;
    }

    public void setUrSet(Set<UserRoleEntity> urSet) {
        this.urSet = urSet;
    }
}
