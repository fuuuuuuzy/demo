package com.example.demo.service;

import com.example.demo.dao.BlogMapper;
import com.example.demo.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogMapper mapper;

    public int updateBlogHot(int id){
        return mapper.updateBlogHot(id);
    }

    public Blog selectBlogByBlogId(int id){
        return mapper.selectBlogByBlogId(id);
    }

    public List<Blog> selectAllBlogsByTUserId(int id){
        return mapper.selectAllBlogsByTUserId(id);
    }

    public List<Blog> selectBlogByIdAndRelate(int id,String relateType,String retaleToType){
        return mapper.selectBlogByIdAndRelate(id,relateType,retaleToType);
    }

    public int insertBlog(Blog blog){
        return mapper.insertBlog(blog);
    }

    public int deleteBlog(int id){
        return mapper.deleteBlog(id);
    }

    public List<Blog> selectBlogByHot(){
        return mapper.selectBlogByHot();
    }

    public List<Blog> selectBlogByText(String text){
        return mapper.selectBlogByText(text);
    }


}
