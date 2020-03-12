package com.project0310.entity;



import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

/**
 * 用户信息实体类
 */
public class UserInfoEntity {
    private int id;
    private String job;
    private int money;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private UserEntity0310 userEntity;

    public UserInfoEntity() {

    }

    public UserInfoEntity(String job, int money, Date date, int userId) {
        this.job = job;
        this.money = money;
        this.date = date;
        this.userEntity = new UserEntity0310();
        this.userEntity.setId(userId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserEntity0310 getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity0310 userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public String toString() {
        return "UserInfoEntity{" +
                "id=" + id +
                ", job='" + job + '\'' +
                ", money=" + money +
                ", date=" + date +
                ", userEntity=" + userEntity +
                '}';
    }
}
