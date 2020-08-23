package com.xl.xlblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/7/30
 * @Time 18:06
 *
 * 博客文章类
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    /**
     * id
     */
    private Long id;

    /**
     * 文章标题
     */
    @NotNull
    private String title;

    /**
     * 博客描述
     */
    @NotNull
    private String description;
    /**
     * 文章内容
     */
    @NotNull
    private String content;

    /**
     * 文章首图
     */
    @NotNull
    private String firstPicture;

    /**
     * 转载标记
     */
    private String flag;

    /**
     * 阅读次数
     */
    private Integer views;

    /**
     * 推荐开启
     */
    private boolean recommended;

    /**
     * 赞赏开启
     */
    private boolean appreciation;

    /**
     * 版权开启
     */
    private boolean shareStatement;

    /**
     * 评论开启
     */
    private boolean commentable;

    /**
     * 发布开启
     */
    private boolean publish;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 文章所属类型
     */
    private Type type;


    /**
     * 该博客所属的用户
     */
    private User user;

    /**
     * 博客下的评论
     */
    private List<Comment> commentList;


    /**
     * 评论总数
     */
    private Integer commentCount;
}
