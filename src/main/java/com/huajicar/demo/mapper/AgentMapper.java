package com.huajicar.demo.mapper;

import com.huajicar.demo.entity.Agent;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface AgentMapper {
    @Select("SELECT * FROM agent LIMIT 0,${num}")
    List<Agent> getNAgent(@Param("num")int num);

    @Select("SELECT * FROM agent WHERE agent_id=#{id}")
    Agent getAgentById(@Param("id")int id);

    @Select("SELECT DISTINCT agent_name FROM agent ORDER BY agent_name")
    List<String> getAllAgentName();

    @Select("SELECT agent_id FROM agent WHERE agent_name=#{name}")
    int getIdByName(@Param("name")String name);

    @SuppressWarnings("rawtypes")
    @Select("call update_count_agent()")
    @Options(statementType = StatementType.CALLABLE)
    HashMap updateAgentCount();

    @Select("SELECT count(*) FROM agent")
    int getCount();

    @Select("SELECT * FROM agent")
    List<Agent> getAllAgent();

    @Insert("INSERT INTO agent(agent_name,agent_phone,agent_email,agent_position,agent_href) VALUES (#{agent_name} ,#{agent_phone} ,#{agent_email},#{agent_position},#{agent_href});")
    @Options(useGeneratedKeys=true, keyProperty="agent_id")
    int insertAgent(Agent agent);

    @Update("UPDATE agent SET agent_photo=#{agent_photo} WHERE agent_id=#{agent_id}")
    void updateAgentPhoto(@Param("agent_photo")String agent_photo,@Param("agent_id")int agent_id);

    @Select("SELECT * FROM agent WHERE agent_name=#{agent_name}")
    Agent getAgentByName(@Param("agent_name")String agent_name);
}
