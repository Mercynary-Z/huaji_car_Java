package com.huajicar.demo.entity;

import java.io.Serializable;

public class Comment implements Serializable {
    private int message_id;
    private String user_account;
    private String user_name;
    private String email;
    private String phone;
    private String title;
    private String message;
    private User user;

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "message_id=" + message_id +
                ", user_account='" + user_account + '\'' +
                ", user_name='" + user_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", user=" + user +
                '}';
    }
}
