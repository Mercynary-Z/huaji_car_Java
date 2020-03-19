package com.huajicar.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class CarSold implements Serializable {
    private String user_account;
    private int trade_id;
    private int car_id;
    private String car_name;
    private float price;
    private int on_sale;
    private Timestamp date;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getOn_sale() {
        return on_sale;
    }

    public void setOn_sale(int on_sale) {
        this.on_sale = on_sale;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CarSold{" +
                "user_account='" + user_account + '\'' +
                ", trade_id=" + trade_id +
                ", car_id=" + car_id +
                ", car_name='" + car_name + '\'' +
                ", price=" + price +
                ", on_sale=" + on_sale +
                ", date=" + date +
                '}';
    }
}
