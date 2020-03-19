package com.huajicar.demo.service;

import com.huajicar.demo.entity.Agent;

import java.util.List;

public interface AgentService {
    List<Agent> getAgentByNum(int num);

    List<String> getAllAgentName();

    int getIdByName(String name);

    int getCount();
}
