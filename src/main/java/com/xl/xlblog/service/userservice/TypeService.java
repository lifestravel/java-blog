package com.xl.xlblog.service.userservice;

import com.github.pagehelper.PageInfo;
import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.pojo.Type;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/14
 * @Time 14:19
 */
public interface TypeService {


    /**
     * 擦汗寻所有分类
     * @return
     */
    List<Type> selectAllType();

    /**
     * 根据type分页查询博客
     * @param typeId
     * @param  currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Blog> pageSelectBlogByType(int currentPage, int pageSize,Long typeId);
}
