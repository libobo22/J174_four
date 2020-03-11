package com.project0310.entity;

import java.util.List;

/**
 * 用户实体类
 */
public class UserEntity0310 {
    private int id;
    private String userName;
    private String pwd;
    private int age;
    private List<UserInfoEntity> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<UserInfoEntity> getList() {
        return list;
    }

    public void setList(List<UserInfoEntity> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", list=" + list +
                '}';
    }
}
