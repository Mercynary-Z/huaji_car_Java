package com.huajicar.demo.service;

import com.huajicar.demo.entity.Comment;
import com.huajicar.demo.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getNRandomCar(int num) {
        return commentMapper.getCommentRandom(num);
    }

    @Override
    public void addComment(Comment comment) {
        commentMapper.insertComment(comment);
    }

    @Override
    public int getCount() {
        return commentMapper.getCount();
    }
}
