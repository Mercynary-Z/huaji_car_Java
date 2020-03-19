package com.huajicar.demo.mapper;

import com.huajicar.demo.entity.Car;
import com.huajicar.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface UserMapper {
    @Select("SELECT * FROM user WHERE user_account=#{account}")
    User getUserByAccount(@Param("account")String account);

    @Select("SELECT * FROM user WHERE user_account=#{username} AND user_password=#{password}")
    User getUserByAccountAndPassword(@Param("username")String username,@Param("password")String password);

    @Insert("INSERT INTO user (user_account,user_email,user_password,user_isfull) VALUES (#{username},#{email},#{password},0)")
    void insertUser(@Param("username")String username, @Param("email")String email,@Param("password")String password);

    @Update("UPDATE user SET user_password=#{user_password},user_name=#{user_name},user_idnumber=#{user_idnumber},user_birthday=#{user_birthday},user_gender=#{user_gender},user_nationality=#{user_nationality},user_email=#{user_email},user_phone=#{user_phone} WHERE user_account=#{user_account}")
    void updateUserinfo(@Param("user_password")String user_password, @Param("user_name")String user_name, @Param("user_idnumber")String user_idnumber,
                        @Param("user_birthday")Date user_birthday, @Param("user_gender")String user_gender, @Param("user_nationality")String user_nationality,
                        @Param("user_email")String user_email, @Param("user_phone")String user_phone,@Param("user_account")String user_account);

    @Update("UPDATE user SET user_img=#{user_img} WHERE user_account=#{username}")
    void updateUserImg(@Param("user_img")String user_img,@Param("username")String username);

    @Select("SELECT count(*) FROM user")
    int getCount();

    @Select("SELECT * FROM user")
    List<User> getAllUser();
}
