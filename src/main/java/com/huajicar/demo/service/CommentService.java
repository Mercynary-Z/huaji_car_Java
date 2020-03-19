package com.huajicar.demo.service;

import com.huajicar.demo.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getNRandomCar(int num);

    void addComment(Comment comment);

    int getCount();
}
