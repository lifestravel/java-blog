package com.xl.xlblog.controller.usercontroller;

import com.xl.xlblog.pojo.Comment;
import com.xl.xlblog.pojo.Result;
import com.xl.xlblog.service.userservice.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/10
 * @Time 21:47
 */
@Controller
@RequestMapping("/blog")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/insertComment")
    @ResponseBody
    public Result insertComment(Comment comment, HttpSession session){
       return commentService.insertComment(comment,session);
    }

    @PostMapping("/deleteComment/{id}/")
    @ResponseBody
    public Result deleteComment(@PathVariable("id") Long id,@RequestParam("blogId") Long blogId){
        return commentService.deleteComment(id,blogId);
    }

    @GetMapping("/getComment/{blogId}/")
    public ModelAndView getComment(@PathVariable("blogId") Long blogId){
        List<Comment> comments = commentService.selectCommentById(blogId);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("blog :: comment-list");
        mv.addObject("commentList",comments);
        return mv;
    }
}
