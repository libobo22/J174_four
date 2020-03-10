package com.project0310.VO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class InfoVO {
    private Integer infoId;
    private String job;
    private Integer money;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date changeDate;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    @Override
    public String toString() {
        return "InfoBean{" +
                "infoId=" + infoId +
                ", job='" + job + '\'' +
                ", money=" + money +
                ", changeDate=" + changeDate +
                '}';
    }
}
