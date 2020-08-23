package com.xl.xlblog.service.userservice;

import com.xl.xlblog.pojo.Comment;
import com.xl.xlblog.pojo.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/10
 * @Time 22:10
 */
public interface CommentService {



    /**
     *  根据博客id查询评论
     * @param blogId
     * @return
     */
    List<Comment> selectCommentById(Long blogId);


    /**
     * 添加评论
     * @param comment
     * @param session
     * @return
     */
    Result insertComment(Comment comment, HttpSession session);


    /**
     * 删评论
     * @param id
     * @param blogId
     * @return
     */
    Result deleteComment(Long id,Long blogId);


}
