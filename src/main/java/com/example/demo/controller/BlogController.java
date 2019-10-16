package com.example.demo.controller;

import com.example.demo.entity.Blog;
import com.example.demo.json.BlogJson;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService service;

    @RequestMapping("/selectByTag/{tag}/{page}")
    @ResponseBody
    public List<Blog> getBlogsByTag(@PathVariable("tag")int tag,@PathVariable("page")int page){
        List<Blog> blogs = service.selectBlogByTag(tag,page);
        for (Blog blog:blogs){
            System.out.println("id:"+blog.getId());
        }
        return blogs;
    }

    /**
     * 获取某类博客：①自己或其他用户的博客②关注的、粉丝的、点赞过的、评论过的、转发过的博客(√)
     * @param id
     * @param relateType
     * @param retaleToType
     * @return
     */
    @RequestMapping(value = {"/getBlog/{id}/{page}","/getBlog/{id}/{relateType}/{retaleToType}/{page}"})
    @ResponseBody
    public BlogJson getBlogs(@PathVariable("id")int id,@PathVariable("page")int page,
                             @PathVariable(required = false,value = "relateType")String relateType,
                             @PathVariable(required = false,value = "retaleToType")String retaleToType,
                             Model model){
        BlogJson json = new BlogJson();
        if (relateType==null){
            List<Blog> blogs = service.selectAllBlogsByTUserId(id,page);
            json.setFlag(true);
            json.setBlogs(blogs);
            model.addAttribute("blogs",blogs);
        }else if (relateType!=null){
            List<Blog> blogs = service.selectBlogByIdAndRelate(id,relateType,retaleToType,page);
            json.setFlag(true);
            json.setBlogs(blogs);
            model.addAttribute("blogs",blogs);
        }else {
            json.setFlag(false);
        }
        System.out.println(json);
        return json;
    }

    /**
     * 根据关键字搜索博客
     * @param text
     * @return
     */
    @RequestMapping("/select/{text}/{page}")
    @ResponseBody
    public List<Blog> selectBlogByText(@PathVariable String text,@PathVariable("page")int page){
        List<Blog> blogs = service.selectBlogByText(text,page);
        return blogs;
    }

    /**
     * 进入单条微博(√)
     * @param blogId
     * @return
     */
    @RequestMapping("/intoBlog/{blogId}")
    @ResponseBody
    public String intoBlog(@PathVariable int blogId){
        Blog blog = service.selectBlogByBlogId(blogId);
        service.updateBlogHot(blogId);
        System.out.println(blog);
        return "查询成功";
    }

    /**
     * 发表博客
     * @param blog
     * @return
     */
    @RequestMapping("/insertBlog")
    @ResponseBody
    public Blog insertBlog(@ModelAttribute Blog blog, @RequestParam("file") MultipartFile file){
        String fileName = file.getOriginalFilename();
        String filePath = "src/main/resources/static/images/";
        File targetFile = new File(filePath);
        try{
            if (!targetFile.exists()){
                targetFile.mkdirs();
            }
            FileOutputStream out = new FileOutputStream(filePath+fileName);
            out.write(file.getBytes());
            out.flush();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        blog.setPicUrl(fileName);
        service.insertBlog(blog);
        return blog;
    }

    /**
     * 点赞博客
     * @param blogId
     * @param userId
     * @return
     */
    @RequestMapping("/deleteBlog/{blogId}/{userId}")
    @ResponseBody
    public String deleteBlog(@PathVariable("blogId")int blogId,@PathVariable("userId")int userId){
        int blogFromId = service.selectBlogByBlogId(blogId).getBFromTuserId();
        if (userId==blogFromId){
            service.deleteBlog(blogId);
            return "删除成功";
        }else {
            return "无权限";
        }
    }

    /**
     * 获取热门博客
     * @return
     */
    @RequestMapping("/hotBlogs")
    @ResponseBody
    public List<Blog> getHotBlogs(@PathVariable("page")int page){
        return service.selectBlogByHot(page);
    }

}
