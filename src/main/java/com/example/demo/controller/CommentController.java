package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService service;

    @RequestMapping("/select/{blogId}")
    @ResponseBody
    public List<Comment> getComment(@PathVariable("blogId")int blogId){
        List<Comment> comments = service.selectById(blogId,0);
        for (Comment comment:comments){
            List<Comment> comms = service.selectById(blogId,comment.getId());
            comment.setComments(comms);
            System.out.println("id:"+comment.getId());
            System.out.println("comms:"+comms);
        }
        System.out.println("c:"+comments);
        return comments;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public int insertComment(@RequestParam("content")String content, @RequestParam("tuserId")int tuserId,
                             @RequestParam("blogId")int blogId, @RequestParam("commentId")int commentId){
        Comment comment = new Comment();
        comment.setCContent(content);
        comment.setCFromTuserId(tuserId);
        comment.setCToBlogId(blogId);
        comment.setCToCommentId(commentId);
        return service.insertComment(comment);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int deleteComment(@RequestParam("commentId")int commentId){
        return service.deleteComment(commentId);
    }

}
