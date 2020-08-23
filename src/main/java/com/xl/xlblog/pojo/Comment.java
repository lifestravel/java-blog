package com.xl.xlblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/7/30
 * @Time 18:20
 * 评论类
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 是否是管理员
     */
    private boolean admin;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 内容
     */
    private String content;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 评论所属的博客
     */
    private Long blogId;

    /**
     * 目标用户
     */
    private String targetUser;

    /**
     * true 为 1级评论
     * false 为2级评论
     */
    private boolean level;

    /**
     * 父评论id
     */
    private Long parCommentId;

    /**
     * 该评论下的子评论
     */
    private List<Comment> childComment;


}
