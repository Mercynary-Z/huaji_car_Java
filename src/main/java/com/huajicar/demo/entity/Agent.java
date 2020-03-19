package com.huajicar.demo.entity;

import java.io.Serializable;

public class Agent implements Serializable {
    private int agent_id;
    private String agent_name;
    private String agent_phone;
    private String agent_email;
    private String agent_photo;
    private int agent_num;
    private String agent_position;
    private String agent_href;

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getAgent_phone() {
        return agent_phone;
    }

    public void setAgent_phone(String agent_phone) {
        this.agent_phone = agent_phone;
    }

    public String getAgent_email() {
        return agent_email;
    }

    public void setAgent_email(String agent_email) {
        this.agent_email = agent_email;
    }

    public String getAgent_photo() {
        return agent_photo;
    }

    public void setAgent_photo(String agent_photo) {
        this.agent_photo = agent_photo;
    }

    public int getAgent_num() {
        return agent_num;
    }

    public void setAgent_num(int agent_num) {
        this.agent_num = agent_num;
    }

    public String getAgent_position() {
        return agent_position;
    }

    public void setAgent_position(String agent_position) {
        this.agent_position = agent_position;
    }

    public String getAgent_href() {
        return agent_href;
    }

    public void setAgent_href(String agent_href) {
        this.agent_href = agent_href;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agent_id=" + agent_id +
                ", agent_name='" + agent_name + '\'' +
                ", agent_phone='" + agent_phone + '\'' +
                ", agent_email='" + agent_email + '\'' +
                ", agent_photo='" + agent_photo + '\'' +
                ", agent_num=" + agent_num +
                ", agent_position='" + agent_position + '\'' +
                ", agent_href='" + agent_href + '\'' +
                '}';
    }
}
