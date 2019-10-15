package com.example.demo.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Comment {
    private int id;
    private Date cCreateTime;
    private String cContent;
    private int cFromTuserId;
    private String cToType;
    private int cToId;
    private TUser user;
    private List<Comment> comments;
    private List<Relate> relates;
}
