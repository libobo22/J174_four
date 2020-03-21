package com.project.hibernate.dto;

public class TeacherDto {
    private String userName;
    private String userClass;

    public TeacherDto() {
    }

    public TeacherDto(String userName, String userClass) {
        this.userName = userName;
        this.userClass = userClass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass = userClass;
    }
}
