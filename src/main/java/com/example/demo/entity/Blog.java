package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Blog {
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date bCreateTime;
    private String bContent;
    private int bFromTuserId;
    private int hintCount;
    //允许查看对象：所有人是0，用户关注对象是1，用户粉丝是2,
    private int permission;
    private String picUrl;
    private TUser user;
    private List<Relate> relates;
    private List<Comment> comments;
}
