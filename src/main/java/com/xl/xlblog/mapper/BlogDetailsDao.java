package com.xl.xlblog.mapper;

import com.sun.org.apache.xerces.internal.dom.PSVIElementNSImpl;
import com.xl.xlblog.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/9
 * @Time 14:09
 */
@Repository
@Mapper
public interface BlogDetailsDao {

    /**
     * 根据博客id查询博客详情
     * @param id
     * @return
     */
    Blog selectBlogDetails(@Param("blogId") Long id);

    /**
     * 设置博客的阅读量+1
     * @param id
     */
    void incrViewsByBlog(@Param("id") Long id);
}
