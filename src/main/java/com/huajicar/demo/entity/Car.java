package com.huajicar.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Car implements Serializable {
    private int car_id;
    private String car_name;
    private float car_price;
    private String car_brand;
    private String car_type;
    private float car_mileage;
    private int car_door;
    private int car_seat;
    private float car_volume;
    private String car_shift;
    private String car_color;
    private float car_saleprice;
    private String note;
    private String user_account;
    private int on_sale;
    private String image_path;
    private String description;
    private int car_age;
    private String car_fuel;
    private Timestamp sale_date;
    private int agent_id;
    private Agent agent;
    private User user;

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

    public float getCar_price() {
        return car_price;
    }

    public void setCar_price(float car_price) {
        this.car_price = car_price;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public float getCar_mileage() {
        return car_mileage;
    }

    public void setCar_mileage(float car_mileage) {
        this.car_mileage = car_mileage;
    }

    public int getCar_door() {
        return car_door;
    }

    public void setCar_door(int car_door) {
        this.car_door = car_door;
    }

    public int getCar_seat() {
        return car_seat;
    }

    public void setCar_seat(int car_seat) {
        this.car_seat = car_seat;
    }

    public float getCar_volume() {
        return car_volume;
    }

    public void setCar_volume(float car_volume) {
        this.car_volume = car_volume;
    }

    public String getCar_shift() {
        return car_shift;
    }

    public void setCar_shift(String car_shift) {
        this.car_shift = car_shift;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public float getCar_saleprice() {
        return car_saleprice;
    }

    public void setCar_saleprice(float car_saleprice) {
        this.car_saleprice = car_saleprice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public int getOn_sale() {
        return on_sale;
    }

    public void setOn_sale(int on_sale) {
        this.on_sale = on_sale;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCar_age() {
        return car_age;
    }

    public void setCar_age(int car_age) {
        this.car_age = car_age;
    }

    public String getCar_fuel() {
        return car_fuel;
    }

    public void setCar_fuel(String car_fuel) {
        this.car_fuel = car_fuel;
    }

    public Timestamp getSale_date() {
        return sale_date;
    }

    public void setSale_date(Timestamp sale_date) {
        this.sale_date = sale_date;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_id=" + car_id +
                ", car_name='" + car_name + '\'' +
                ", car_price=" + car_price +
                ", car_brand='" + car_brand + '\'' +
                ", car_type='" + car_type + '\'' +
                ", car_mileage=" + car_mileage +
                ", car_door=" + car_door +
                ", car_seat=" + car_seat +
                ", car_volume=" + car_volume +
                ", car_shift='" + car_shift + '\'' +
                ", car_color='" + car_color + '\'' +
                ", car_saleprice=" + car_saleprice +
                ", note='" + note + '\'' +
                ", user_account='" + user_account + '\'' +
                ", on_sale=" + on_sale +
                ", image_path='" + image_path + '\'' +
                ", description='" + description + '\'' +
                ", car_age=" + car_age +
                ", car_fuel='" + car_fuel + '\'' +
                ", sale_date=" + sale_date +
                ", agent_id=" + agent_id +
                ", agent=" + agent +
                ", user=" + user +
                '}';
    }
}
