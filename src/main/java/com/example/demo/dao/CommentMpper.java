package com.example.demo.dao;

import com.example.demo.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMpper {
    List<Comment> selectById(@Param("blogId") int blogId, @Param("commentId") int commentId);
    int insertComment(Comment comment);
    int deleteComment(@Param("id") int id);
}
