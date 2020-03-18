package com.lovo.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity//被hibernate管理的标记
@Table(name ="sys_user")//映射表
public class UserEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int userId;
////unique:是否默认为唯一索引，nullable = false是否为空，不能为空
//    @Column(name="u_name",length=48,nullable = false,unique = true)
//    private String userName;
//    //该列在SQL语句中的保存不添加,不怎么实用
//   //@Column(insertable = false)
//    private String password;
//    private int age;
//
//    @Column(columnDefinition = "TIMESTAMP")
//    private String addDate;
//    @Column(columnDefinition = "TEXT")
//    private String info;
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getAddDate() {
//        return addDate;
//    }
//
//    public void setAddDate(String addDate) {
//        this.addDate = addDate;
//    }
//
//    public String getInfo() {
//        return info;
//    }
//
//    public void setInfo(String info) {
//        this.info = info;
//    }
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


