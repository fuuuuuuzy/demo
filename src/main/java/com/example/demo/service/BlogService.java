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

    public Blog selectBlogByBlogId(int id){
        return mapper.selectBlogByBlogId(id);
    }

    public List<Blog> selectBlogByTag(int tag,int currentPage){
        List<Blog> blogs = mapper.selectBlogByTag(tag);
        int firstPage = (currentPage-1)*5;
        int lastPage = currentPage*5;
        return blogs.subList(firstPage,lastPage);
    }
    public List<Blog> selectBlogByHot(int currentPage){
        List<Blog> blogs = mapper.selectBlogByHot();
        int firstPage = (currentPage-1)*5;
        int lastPage = currentPage*5;
        return blogs.subList(firstPage,lastPage);
    }

    public List<Blog> selectBlogByText(String text,int currentPage){
        List<Blog> blogs = mapper.selectBlogByText(text);
        int firstPage = (currentPage-1)*5;
        int lastPage = currentPage*5;
        return blogs.subList(firstPage,lastPage);
    }

    public List<Blog> selectAllBlogsByTUserId(int id,int currentPage){
        List<Blog> blogs = mapper.selectAllBlogsByTUserId(id);
        int firstPage = (currentPage-1)*5;
        int lastPage = currentPage*5;
        return blogs.subList(firstPage,lastPage);
    }

    public List<Blog> selectBlogByIdAndRelate(int id,String relateType,String retaleToType,int currentPage){
        List<Blog> blogs = mapper.selectBlogByIdAndRelate(id,relateType,retaleToType);
        int firstPage = (currentPage-1)*5;
        int lastPage = currentPage*5;
        return blogs.subList(firstPage,lastPage);
    }

    public int insertBlog(Blog blog){
        return mapper.insertBlog(blog);
    }

    public int deleteBlog(int id){
        return mapper.deleteBlog(id);
    }

    public int updateBlogHot(int id){
        return mapper.updateBlogHot(id);
    }

}
