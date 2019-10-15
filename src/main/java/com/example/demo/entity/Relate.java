package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Relate {
    private int id;
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Date rCreateTime;
    //关注是like，拉黑是dislike，点赞是good，转发是relay
    private String rType;
    private int rFromTuserId;
    //用户是user，评论是comment，博客是blog
    private String rToType;
    private int rToId;
    //未读是0，已读是1
    private int status;
}
