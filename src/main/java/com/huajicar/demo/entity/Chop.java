package com.huajicar.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Chop implements Serializable {
    private int chop_id;
    private String account_name;
    private String former_owner_name;
    private float chop_price;
    private int deal_or_not;
    private Timestamp deal_time;
    private int car_id;

    private Car car;

    public int getChop_id() {
        return chop_id;
    }

    public void setChop_id(int chop_id) {
        this.chop_id = chop_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getFormer_owner_name() {
        return former_owner_name;
    }

    public void setFormer_owner_name(String former_owner_name) {
        this.former_owner_name = former_owner_name;
    }

    public float getChop_price() {
        return chop_price;
    }

    public void setChop_price(float chop_price) {
        this.chop_price = chop_price;
    }

    public int getDeal_or_not() {
        return deal_or_not;
    }

    public void setDeal_or_not(int deal_or_not) {
        this.deal_or_not = deal_or_not;
    }

    public Timestamp getDeal_time() {
        return deal_time;
    }

    public void setDeal_time(Timestamp deal_time) {
        this.deal_time = deal_time;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Chop{" +
                "chop_id=" + chop_id +
                ", account_name='" + account_name + '\'' +
                ", former_owner_name='" + former_owner_name + '\'' +
                ", chop_price=" + chop_price +
                ", deal_or_not=" + deal_or_not +
                ", deal_time=" + deal_time +
                ", car_id=" + car_id +
                ", car=" + car +
                '}';
    }
}
