package com.huajicar.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class CarBought implements Serializable {
    private String user_account;
    private int trade_id;
    private int car_id;
    private String car_name;
    private Timestamp date;
    private float price;
    private String former_owner;

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public int getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(int trade_id) {
        this.trade_id = trade_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getFormer_owner() {
        return former_owner;
    }

    public void setFormer_owner(String former_owner) {
        this.former_owner = former_owner;
    }

    @Override
    public String toString() {
        return "CarBought{" +
                "user_account='" + user_account + '\'' +
                ", trade_id=" + trade_id +
                ", car_id=" + car_id +
                ", car_name='" + car_name + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", former_owner='" + former_owner + '\'' +
                '}';
    }
}
