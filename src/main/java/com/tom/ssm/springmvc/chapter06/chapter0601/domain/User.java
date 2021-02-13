package com.tom.ssm.springmvc.chapter06.chapter0601.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

/**
 * User
 *
 * @author Tom on 2021/2/13
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String loginname;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Past
    private Date birthday;
    @NumberFormat(style= NumberFormat.Style.NUMBER,pattern = "#,###")
    private int total;

    private String password;
    @NotBlank
    @Length(min=6,max=8)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String loginname, Date birthday) {
        this.loginname = loginname;
        this.birthday = birthday;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginname='" + loginname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
