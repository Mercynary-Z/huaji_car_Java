package com.huajicar.demo.service;

import com.huajicar.demo.entity.User;

import java.sql.Date;

public interface UserService {
    User checkUserPassword(String username,String password);

    User checkDuplicateUser(String username);

    void registerUser(String username,String email,String password);

    User getUserByAccount(String username);

    void updateUserInfo(String user_password, String user_name, String user_idnumber,
                        Date user_birthday, String user_gender, String user_nationality,
                        String user_email, String user_phone,String user_account);

    void updateUserImg(String user_img,String username);

    int getCount();
}
