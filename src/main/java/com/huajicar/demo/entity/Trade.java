package com.huajicar.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Trade implements Serializable {
    private int trade_id;
    private int car_id;
    private String user_account;
    private Timestamp date;
    private float trade_price;
    private String former_owner_account;

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

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public float getTrade_price() {
        return trade_price;
    }

    public void setTrade_price(float trade_price) {
        this.trade_price = trade_price;
    }

    public String getFormer_owner_account() {
        return former_owner_account;
    }

    public void setFormer_owner_account(String former_owner_account) {
        this.former_owner_account = former_owner_account;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "trade_id=" + trade_id +
                ", car_id=" + car_id +
                ", user_account='" + user_account + '\'' +
                ", date=" + date +
                ", trade_price=" + trade_price +
                ", former_owner_account='" + former_owner_account + '\'' +
                '}';
    }
}
