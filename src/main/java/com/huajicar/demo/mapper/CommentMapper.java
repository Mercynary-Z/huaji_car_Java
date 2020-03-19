package com.huajicar.demo.mapper;

import com.huajicar.demo.entity.Comment;
import com.huajicar.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    @Select("SELECT * FROM comment ORDER BY rand() LIMIT ${num}")
    @Results(value = {@Result(property ="user",column = "user_account",one = @One(select = "com.huajicar.demo.mapper.UserMapper.getUserByAccount"))})
    List<Comment> getCommentRandom(@Param("num")int num);

    @Insert("INSERT INTO comment(user_account, user_name , email, phone, title, message) VALUES(#{user_account}, #{user_name} , #{email}, #{phone}, #{title}, #{message})")
    void insertComment(Comment comment);

    @Select("SELECT count(*) FROM comment")
    int getCount();

    @Select("SELECT * FROM comment")
    List<Comment> getAllComment();

    @Delete("DELETE FROM comment WHERE message_id=#{id}")
    void deleteCommentById(@Param("id")int id);
}
