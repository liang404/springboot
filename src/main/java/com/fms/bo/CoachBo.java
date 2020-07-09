package com.fms.bo;

import com.fms.pojo.Coach;

/**
 * @author liang
 * @create 2020/6/28 13:33
 */
public class CoachBo extends Coach {

    private String username;
    private String password;

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

    @Override
    public String toString() {
        return "CoachBo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
