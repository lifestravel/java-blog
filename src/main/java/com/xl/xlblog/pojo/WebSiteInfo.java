package com.xl.xlblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/16
 * @Time 10:58
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class WebSiteInfo {

    /**
     * 网站文章总数
     */
    private Integer articles;

    /**
     * 网站访问量
     */
    private Integer views;

    /**
     * 评论总数
     */
    private Integer commentCount;
}
