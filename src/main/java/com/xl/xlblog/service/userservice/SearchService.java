package com.xl.xlblog.service.userservice;

import com.github.pagehelper.PageInfo;
import com.xl.xlblog.pojo.Blog;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/9
 * @Time 17:02
 */
public interface SearchService {

    /**
     * 分页搜索
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    PageInfo<Blog> pageSearch(int currentPage,int pageSize,String search);
}
