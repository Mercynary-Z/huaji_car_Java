package com.huajicar.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
    private String user_account;
    private String user_name;
    private String user_idnumber;
    private Date user_birthday;
    private String user_gender;
    private String user_nationality;
    private String user_email;
    private String user_img;
    private String user_phone;
    private int user_isfull;
    private String user_password;

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_idnumber() {
        return user_idnumber;
    }

    public void setUser_idnumber(String user_idnumber) {
        this.user_idnumber = user_idnumber;
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_nationality() {
        return user_nationality;
    }

    public void setUser_nationality(String user_nationality) {
        this.user_nationality = user_nationality;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public int getUser_isfull() {
        return user_isfull;
    }

    public void setUser_isfull(int user_isfull) {
        this.user_isfull = user_isfull;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_account='" + user_account + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_idnumber='" + user_idnumber + '\'' +
                ", user_birthday=" + user_birthday +
                ", user_gender='" + user_gender + '\'' +
                ", user_nationality='" + user_nationality + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_img='" + user_img + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_isfull=" + user_isfull +
                ", user_password='" + user_password + '\'' +
                '}';
    }
}
