package com.example.demo.dao;

import com.example.demo.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogMapper {
    //查找单条博客
    Blog selectBlogByBlogId(@Param("id") int id);
    List<Blog> selectBlogByTag(@Param("tag")int tag);
    //查找某个用户的所有博客
    List<Blog> selectAllBlogsByTUserId(@Param("id") int id);
    //查找某人的（关注的，粉丝的，点赞的，转发的）的博客
    List<Blog> selectBlogByIdAndRelate(@Param("id") int id, @Param("relateType") String relateType, @Param("retaleToType") String retaleToType);
    //进入博客后增加点击量
    int updateBlogHot(@Param("id") int id);
    //发表博客
    int insertBlog(Blog blog);
    //删除博客
    int deleteBlog(@Param("id") int id);
    //查找热门博客：hint_count
    List<Blog> selectBlogByHot();
    //根据关键字查找
    List<Blog> selectBlogByText(@Param("text") String text);


}
