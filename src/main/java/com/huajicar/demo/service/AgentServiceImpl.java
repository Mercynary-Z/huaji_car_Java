package com.huajicar.demo.service;

import com.huajicar.demo.entity.Agent;
import com.huajicar.demo.mapper.AgentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentMapper agentMapper;

    @Override
    public List<Agent> getAgentByNum(int num) {
        return agentMapper.getNAgent(num);
    }

    @Override
    public List<String> getAllAgentName() {
        return agentMapper.getAllAgentName();
    }

    @Override
    public int getIdByName(String name) {
        return agentMapper.getIdByName(name);
    }

    @Override
    public int getCount() {
        return agentMapper.getCount();
    }
}
