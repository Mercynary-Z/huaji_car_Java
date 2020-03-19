package com.huajicar.demo.service;

import com.huajicar.demo.entity.User;
import com.huajicar.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUserPassword(String username, String password) {
        return userMapper.getUserByAccountAndPassword(username,password);
    }

    @Override
    public User checkDuplicateUser(String username) {
        return userMapper.getUserByAccount(username);
    }

    @Override
    public void registerUser(String username, String email, String password) {
        userMapper.insertUser(username,email,password);
    }

    @Override
    public User getUserByAccount(String username) {
        return userMapper.getUserByAccount(username);
    }

    @Override
    public void updateUserInfo(String user_password, String user_name, String user_idnumber, Date user_birthday, String user_gender, String user_nationality, String user_email, String user_phone,String user_account) {
        userMapper.updateUserinfo(user_password, user_name, user_idnumber, user_birthday, user_gender, user_nationality, user_email, user_phone,user_account);
    }

    @Override
    public void updateUserImg(String user_img, String username) {
        userMapper.updateUserImg(user_img,username);
    }

    @Override
    public int getCount() {
        return userMapper.getCount();
    }

}
