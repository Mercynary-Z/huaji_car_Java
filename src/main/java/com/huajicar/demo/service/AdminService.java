package com.huajicar.demo.service;

import com.huajicar.demo.entity.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdminService {
    Admin checkLogin(Admin admin);

    List<Car> getAllCar();

    List<Comment> getAllComment();

    List<Agent> getAllAgent();

    List<User> getAllUser();

    void deleteCommentById(int id);

    void addAgent(Agent agent, MultipartFile file);

    boolean checkDuplicateAgent(Agent agent);
}
