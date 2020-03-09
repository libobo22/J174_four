package com.project0309.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * 用户实体类
 */
public class UserEntity {
    private int id;
    @Pattern(regexp = "[a-z]{3}", message = "用户名必须是三位的小写字母")
    private String userName;
    @Pattern(regexp = "\\d{3}", message = "密码必须是三位数字")
    private String pwd;
    @Min(value = 1, message = "年龄必须是数字")
    private int age;

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
}
