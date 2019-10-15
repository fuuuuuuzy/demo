package com.example.demo.json;

import com.example.demo.entity.Blog;
import lombok.Data;

import java.util.List;

@Data
public class BlogJson {
    private boolean flag;
    private String msg;
    private List<Blog> blogs;
}
