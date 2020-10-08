package com.xl.xlblog.service.userservice;

import com.github.pagehelper.PageInfo;
import com.xl.xlblog.pojo.Blog;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/8
 * @Time 15:23
 */
public interface IndexService {
    /**
     * 最新推荐
     * @return
     */
   List<Blog> latestRecommended();


    /**
     * 最新博客，可以分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Blog> latestBlog(int currentPage, int pageSize);
}
