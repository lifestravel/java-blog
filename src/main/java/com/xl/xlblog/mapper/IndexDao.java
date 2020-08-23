package com.xl.xlblog.mapper;

import com.xl.xlblog.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/8
 * @Time 15:25
 */
@Mapper
@Repository
public interface IndexDao {
    /**
     * 最新推荐博客
     * @return
     */
    List<Blog> latestRecommended();


    /**
     * 最新博客，可以分页
     * @return
     */
    List<Blog> latestBlog();

}
