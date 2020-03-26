package com.project.dto;

public class UserPermissionDTO {
    private String userName;
    private String perName;
    private String perURL;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public String getPerURL() {
        return perURL;
    }

    public void setPerURL(String perURL) {
        this.perURL = perURL;
    }
}
