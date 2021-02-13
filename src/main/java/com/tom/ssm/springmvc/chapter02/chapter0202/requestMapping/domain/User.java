package com.tom.ssm.springmvc.chapter02.chapter0202.requestMapping.domain;

import java.io.Serializable;

/**
 * domain.User
 *
 * @author Tom on 2021/2/11
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String loginname;
    private String password;
    private String username;

    public User() {
    }

    public User(String loginname, String password, String username) {
        this.loginname = loginname;
        this.password = password;
        this.username = username;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
