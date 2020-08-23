package com.xl.xlblog.mapper;

import com.xl.xlblog.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/14
 * @Time 20:17
 */
@Mapper
@Repository
public interface TimestampDao {

    /**
     * 查询所有博客
     * @return
     */
    List<Blog> selectAllBlog();
}
