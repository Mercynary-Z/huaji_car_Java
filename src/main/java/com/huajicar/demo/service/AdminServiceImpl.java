package com.huajicar.demo.service;

import com.huajicar.demo.entity.*;
import com.huajicar.demo.mapper.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AgentMapper agentMapper;

    @Override
    public Admin checkLogin(Admin admin) {
        return adminMapper.selectAdminByNameAndPassword(admin.getAdmin_account(),admin.getAdmin_password());
    }

    @Override
    public List<Car> getAllCar() {
        return carMapper.getAllCar();
    }

    @Override
    public List<Comment> getAllComment() {
        return commentMapper.getAllComment();
    }

    @Override
    public List<Agent> getAllAgent() {
        return agentMapper.getAllAgent();
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public void deleteCommentById(int id) {
        commentMapper.deleteCommentById(id);
    }

    @Override
    public void addAgent(Agent agent, MultipartFile file) {
        agentMapper.insertAgent(agent);
        int id=agent.getAgent_id();
        if(!file.isEmpty()){
            String type=file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
            String filename="agent-"+id+type;
            String path="./src/main/resources/static/image/"+filename;
            File destFile=new File(path);
            try{
                FileUtils.copyInputStreamToFile(file.getInputStream(),destFile);
            }catch (IOException e){
                e.printStackTrace();
            }
            path="./target/classes/static/image/"+filename;
            destFile=new File(path);
            try{
                FileUtils.copyInputStreamToFile(file.getInputStream(),destFile);
            }catch (IOException e){
                e.printStackTrace();
            }
            agentMapper.updateAgentPhoto("/static/image/"+filename,id);
        }
    }

    @Override
    public boolean checkDuplicateAgent(Agent agent) {
        Agent agent1=agentMapper.getAgentByName(agent.getAgent_name());
        if(agent1==null){
            return false;
        }else {
            return true;
        }
    }
}
