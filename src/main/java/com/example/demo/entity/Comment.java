package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Comment {
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date cCreateTime;
    private String cContent;
    private int cFromTuserId;
    private int cToBlogId;
    private int cToCommentId;
    private TUser user;
    private List<Relate> relates;
    private List<Comment> comments;
}
