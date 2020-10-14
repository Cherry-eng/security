package com.oracle.domain;

import java.util.List;

public class UserInfo {
    private int id;
    private String username;
    private String password;
    private String phoneNum;
    private String email;
    private int status;// 0:未开启，1：已开启
    private String statusStr;
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusStr() {
            if (status==0){
                statusStr="未开启";
            }else if (status==1){
                statusStr="已启用";
            }else {
                statusStr="其他";
            }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public UserInfo(int id, String username, String password, String phoneNum, String email, int status, String statusStr, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.email = email;
        this.status = status;
        this.statusStr = statusStr;
        this.roles = roles;
    }

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", roles=" + roles +
                '}';
    }
}
