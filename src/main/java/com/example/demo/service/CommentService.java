package com.example.demo.service;

import com.example.demo.dao.CommentMpper;
import com.example.demo.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMpper mapper;

    public List<Comment> selectById(int blogId, int commentId){
        return mapper.selectById(blogId,commentId);
    }

    public int insertComment(Comment comment){
        return mapper.insertComment(comment);
    }

    public int deleteComment(int id){
        return mapper.deleteComment(id);
    }
}
