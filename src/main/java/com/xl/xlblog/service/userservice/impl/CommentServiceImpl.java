package com.xl.xlblog.service.userservice.impl;

import com.xl.xlblog.mapper.CommentDao;
import com.xl.xlblog.pojo.Comment;
import com.xl.xlblog.pojo.Result;
import com.xl.xlblog.pojo.User;
import com.xl.xlblog.service.userservice.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/10
 * @Time 19:54
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Value("${comment.avatar}")
    private String avatar;

    @Override
    public List<Comment> selectCommentById(Long blogId) {
        List<Comment> comments = commentDao.selectParentCommentByBlogId(blogId);
        if (comments != null && comments.size()>0){
            for (int i = 0; i < comments.size(); i++) {
               List<Comment> childComments = commentDao.selectChildCommentByBlogIdAndParCommentId(blogId, comments.get(i).getId());
                comments.get(i).setChildComment(childComments);
            }
        }
        return comments;
    }

    @Override
    public Result insertComment(Comment comment, HttpSession session) {
        Result result = new Result();
       if (comment == null){
           result.setCode(0);
           result.setMessage("评论失败!");
           return result;
       }
        //判断是不是父评论
       if (comment.getParCommentId()>0){
           //不是父评论
           comment.setLevel(false);
       }else {
           comment.setLevel(true);
       }
       comment.setHeadImg(avatar);
       //如果是博主评论
       if (session.getAttribute("user") != null){
           User user = (User)session.getAttribute("user");
           comment.setHeadImg(user.getHeadImg());
           comment.setNickName(user.getNickName());
           comment.setEmail(user.getEmail());
           comment.setAdmin(true);
       }
        int i =commentDao.insertComment(comment);
        commentDao.incrCommentCount(comment.getBlogId());
       if (i==1){
           result.setCode(1);
           result.setMessage("评论成功!");
       }else {
           result.setCode(0);
           result.setMessage("评论失败!");
       }
       return result;
    }



    @Override
    public Result deleteComment(Long id,Long blogId) {
        Result result = new Result();
        if (id <= 0){
            result.setCode(0);
            result.setMessage("删除失败!");
            return result;
        }
        int code = 0;
            code = commentDao.deleteComment(id);
            commentDao.decrCommentCount(blogId,code);
        if (code != 0){
            result.setCode(1);
            result.setMessage("删除成功!");
        }else {
            result.setCode(0);
            result.setMessage("删除失败!");
        }
        return result;
    }
}
