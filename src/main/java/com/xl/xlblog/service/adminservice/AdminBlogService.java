package com.xl.xlblog.service.adminservice;

import com.github.pagehelper.PageInfo;
import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.pojo.Result;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/5
 * @Time 14:39
 */
public interface AdminBlogService {

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @param title
     * @param typeName
     * @param recommended
     * @return
     */
    Result pageSelectBlog(int currentPage, int pageSize,String title,String typeName,boolean recommended);


    /**
     * 添加博客
     * @param blog
     * @param typeId
     * @param userId
     * @return
     */
    Result addBlog(Blog blog,Long typeId,Long userId);

    /**
     * 删除博客
     * @param id
     * @return
     */
    Result delBlog(Long id);

    /**
     * 编辑博客
     * @param id
     * @return
     */
    Blog selectBlogById(Long id);

    /**
     * 编辑博客
     * @param blog
     * @param typeId
     * @return
     */
    Result editBlog(Blog blog, long typeId);
}
