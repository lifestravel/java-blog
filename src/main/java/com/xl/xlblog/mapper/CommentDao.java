package com.xl.xlblog.mapper;

import com.github.pagehelper.ISelect;
import com.xl.xlblog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/10
 * @Time 19:54
 */
@Repository
@Mapper
public interface CommentDao {

    /**
     * 根据博客id查询父评论
     * @param blogId
     * @return
     */
    List<Comment> selectParentCommentByBlogId(@Param("blogId") Long blogId);


    /**
     *  根据博客id和父评论id查询子评论
     * @param blogId
     * @param parCommentId
     * @return
     */
    List<Comment> selectChildCommentByBlogIdAndParCommentId(@Param("blogId") Long blogId,@Param("parCommentId") Long parCommentId);


    /**
     * 添加评论
     * @param comment
     * @return
     */
    int insertComment(Comment comment);



    /**
     * 删除
     * 删除父评论会删除所有的子评论
     * @param id
     * @return
     */
    int deleteComment(@Param("id") Long id);


    /**
     * 该博客下面的评论数+1
     * @param blogId
     */
    void incrCommentCount(@Param("blogId") Long blogId);

    /**
     * 该博客下面的评论数量-count
     * @param blogId
     * @param count
     */
    void decrCommentCount(@Param("blogId") Long blogId,@Param("count") int count);

    /**
     * 查询该父评论有多少条子评论
     * @param id
     * @return
     */
    int selectChildCommentCount(@Param("commentId") Long id);
}
