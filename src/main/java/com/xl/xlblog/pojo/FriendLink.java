package com.xl.xlblog.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/13
 * @Time 11:11
 */
@Data
@Component
public class FriendLink {

    private Long id;

    /**
     * 博客名称
     */
    @NotBlank
    @NotNull
    private String blogName;

    /**
     * 博客地址
     */
    @NotBlank
    @NotNull
    private String blogAddress;


    /**
     * 图片地址
     */
    @NotBlank
    @NotNull
    private String pictureAddress;

    /**
     * 添加时间
     */
    private Date createTime;
}
